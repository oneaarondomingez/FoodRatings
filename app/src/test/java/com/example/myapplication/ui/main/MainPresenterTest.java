package com.example.myapplication.ui.main;

import com.example.myapplication.data.ratings.RatingsRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by user on 3/30/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {
    @Mock
    MainContract.View view;

    @Mock
    RatingsRepository ratingsRepository;

    private MainPresenter mainPresenter;

    @Before
    public void setupPresenter() {
        mainPresenter = new MainPresenter(ratingsRepository);
        mainPresenter.attachView(view);
    }

    @Test
    public void attachView() throws Exception {
        mainPresenter.attachView(view);
        verify(ratingsRepository, times(2)).addObserver(any());
    }

    @Test
    public void loadAuthorities() throws Exception {
        mainPresenter.loadAuthorities();
        verify(view).showProgress();
        verify(ratingsRepository).loadAuthorities();
    }

    @Test
    public void detachView() throws Exception {
        mainPresenter.detachView();
        verify(ratingsRepository).removeObserver(any());
    }

}