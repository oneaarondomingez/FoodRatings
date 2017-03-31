package com.example.myapplication.ui.authority;

import com.example.myapplication.BasePresenter;
import com.example.myapplication.BaseView;

import java.util.TreeMap;

/**
 * Created by user on 3/30/17.
 */

public interface AuthorityContract {
    interface View extends BaseView {
        void updateEstablishments(TreeMap<String, Double> map);
    }

    interface Presenter extends BasePresenter<View> {
        void loadEstablishments(int establishmentId, int numberEstablishments);
    }
}
