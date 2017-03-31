package com.example.myapplication.data.ratings;

import com.example.myapplication.App;
import com.example.myapplication.data.ratings.entities.authority.ResultAuthority;
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

public class RatingsRepository {

    @Inject
    RatingsService ratingsService;

    private HashSet<Observer<ResultAuthority>> observers;

    public RatingsRepository(App app) {
        app.getAppComponent().inject(this);

        observers = new HashSet<>();
    }

    public void loadAuthorities() {
        ratingsService.getAuthorities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultAuthority>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onComplete: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e);
                    }

                    @Override
                    public void onNext(ResultAuthority resultAuthority) {
                        publishAuthorities(resultAuthority);
                    }
                });
    }

    private void publishAuthorities(ResultAuthority resultAuthority) {
        for (Observer<ResultAuthority> observer : observers) {
            Observable.just(resultAuthority).subscribe(observer);
        }
    }

    public void addObserver(Observer<ResultAuthority> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<ResultAuthority> observer) {
        observers.remove(observer);
    }

}
