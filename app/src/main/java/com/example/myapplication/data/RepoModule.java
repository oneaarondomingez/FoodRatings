package com.example.myapplication.data;

import com.example.myapplication.App;
import com.example.myapplication.data.ratings.EstablishmentsRepository;
import com.example.myapplication.data.ratings.RatingsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 3/30/17.
 */

@Singleton
@Module
public class RepoModule {

    @Singleton
    @Provides
    public RatingsRepository provideCountriesRepository(App app) {
        return new RatingsRepository(app);
    }

    @Singleton
    @Provides
    public EstablishmentsRepository provideEstablishmentsRepository(App app) {
        return new EstablishmentsRepository(app);
    }

}
