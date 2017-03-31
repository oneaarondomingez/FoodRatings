package com.example.myapplication.ui.authority;

import com.example.myapplication.data.ratings.EstablishmentsRepository;
import com.example.myapplication.data.ratings.entities.establishments.ResultEstablishments;
import com.example.myapplication.utils.EstablishmentsMapper;

import java.util.Map;
import java.util.TreeMap;

import rx.Observer;


/**
 * Created by user on 3/30/17.
 */

public class AuthorityPresenter implements AuthorityContract.Presenter {
    private static final String TAG = "AuthorityPresenterTAG_";

    private EstablishmentsRepository establishmentsRepository;
    private AuthorityContract.View view;
    private Observer<ResultEstablishments> observer;

    public AuthorityPresenter(EstablishmentsRepository establishmentsRepository) {
        this.establishmentsRepository = establishmentsRepository;

        observer = new Observer<ResultEstablishments>() {
            @Override
            public void onCompleted() {
                view.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.toString());
            }

            @Override
            public void onNext(ResultEstablishments resultEstablishments) {
                TreeMap<String, Double> map =
                        EstablishmentsMapper.establishmentsToMap(resultEstablishments.getEstablishments());

                averageMap(map);

                view.updateEstablishments(map);
            }
        };
    }

    private void averageMap(TreeMap<String, Double> map) {
        int total = 0;
        for (Double frequency : map.values()) {
            total += frequency;
        }

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            double frequency = entry.getValue();

            map.put(key, frequency / total);
        }
    }

    @Override
    public void attachView(AuthorityContract.View view) {
        this.view = view;
        establishmentsRepository.addObserver(observer);
    }

    @Override
    public void detachView() {
        view = null;
        establishmentsRepository.removeObserver(observer);
    }

    @Override
    public void loadEstablishments(int establishmentId, int numberEstablishments) {
        view.showProgress();
        establishmentsRepository.loadEstablishments(establishmentId, numberEstablishments);
    }
}
