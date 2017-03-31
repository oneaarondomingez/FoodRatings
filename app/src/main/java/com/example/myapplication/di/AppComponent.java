package com.example.myapplication.di;

import com.example.myapplication.data.DataModule;
import com.example.myapplication.data.RepoModule;
import com.example.myapplication.data.ratings.EstablishmentsRepository;
import com.example.myapplication.data.ratings.RatingsRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by user on 3/30/17.
 */

@Singleton
@Component(modules = {AppModule.class, DataModule.class, RepoModule.class})
public interface AppComponent {
    RatingsRepository ratingsRepository();
    EstablishmentsRepository establishmentsRepository();

    void inject(RatingsRepository ratingsRepository);
    void inject(EstablishmentsRepository establishmentsRepository);
}
