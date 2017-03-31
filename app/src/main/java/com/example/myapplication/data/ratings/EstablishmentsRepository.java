package com.example.myapplication.data.ratings;

import com.example.myapplication.App;
import com.example.myapplication.data.ratings.entities.establishments.ResultEstablishments;
import com.example.myapplication.data.ratings.remote.RatingsService;

import java.util.HashSet;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by user on 3/30/17.
 */

public class EstablishmentsRepository {
    @Inject
    RatingsService ratingsService;

    private HashSet<Observer<ResultEstablishments>> observers;

    public EstablishmentsRepository(App app) {
        app.getAppComponent().inject(this);

        observers = new HashSet<>();
    }

    public void loadEstablishments(int authorityId, int size) {
        ratingsService.getEstablishments(authorityId, size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultEstablishments>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e);
                    }

                    @Override
                    public void onNext(ResultEstablishments resultEstablishments) {
                        publishEstablishments(resultEstablishments);
                    }
                });
    }

    private void publishEstablishments(ResultEstablishments resultEstablishments) {
        for (Observer<ResultEstablishments> observer : observers) {
            Observable.just(resultEstablishments).subscribe(observer);
        }
    }

    public void addObserver(Observer<ResultEstablishments> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<ResultEstablishments> observer) {
        observers.remove(observer);
    }

}
