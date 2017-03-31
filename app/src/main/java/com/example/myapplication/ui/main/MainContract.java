package com.example.myapplication.ui.main;

import com.example.myapplication.BasePresenter;
import com.example.myapplication.BaseView;
import com.example.myapplication.data.ratings.entities.authority.Authority;

import java.util.List;

/**
 * Created by user on 3/30/17.
 */

public interface MainContract {
    interface View extends BaseView {
        void updateAuthorities(List<Authority> authorities);
    }

    interface Presenter extends BasePresenter<View> {
        void loadAuthorities();
    }
}
