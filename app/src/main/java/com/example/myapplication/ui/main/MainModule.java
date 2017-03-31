package com.example.myapplication.ui.main;

import com.example.myapplication.data.ratings.RatingsRepository;
import com.example.myapplication.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 3/30/17.
 */

@ActivityScope
@Module
public class MainModule {
    @Provides
    public MainContract.Presenter providePresenter(RatingsRepository ratingsRepository) {
        return new MainPresenter(ratingsRepository);
    }
}
