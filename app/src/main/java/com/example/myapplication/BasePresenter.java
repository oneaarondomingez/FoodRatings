package com.example.myapplication;

/**
 * Created by user on 3/30/17.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
