package com.example.myapplication;

/**
 * Created by user on 3/30/17.
 */

public interface BaseView {
    void showProgress();

    void hideProgress();

    void showError(String error);
}
