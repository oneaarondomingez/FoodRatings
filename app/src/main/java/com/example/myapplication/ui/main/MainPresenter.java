package com.example.myapplication.ui.main;

import com.example.myapplication.data.ratings.RatingsRepository;
import com.example.myapplication.data.ratings.entities.authority.ResultAuthority;

import rx.Observer;


/**
 * Created by user on 3/30/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    private RatingsRepository ratingsRepository;

    private Observer<ResultAuthority> observer;

    public MainPresenter(RatingsRepository ratingsRepository) {
        this.ratingsRepository = ratingsRepository;

        observer = new Observer<ResultAuthority>() {
            @Override
            public void onCompleted() {
                view.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.toString());
            }

            @Override
            public void onNext(ResultAuthority resultAuthority) {
                view.updateAuthorities(resultAuthority.getAuthorities());
            }
        };

    }

    @Override
    public void loadAuthorities() {
        if (view != null) {
            view.showProgress();
            ratingsRepository.loadAuthorities();
        }
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
        ratingsRepository.addObserver(observer);
    }

    @Override
    public void detachView() {
        view = null;
        ratingsRepository.removeObserver(observer);
    }
}
