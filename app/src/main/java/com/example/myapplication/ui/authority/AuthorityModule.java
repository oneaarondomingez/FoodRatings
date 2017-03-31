package com.example.myapplication.ui.authority;

import com.example.myapplication.data.ratings.EstablishmentsRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 3/30/17.
 */

@Module
public class AuthorityModule {

    @Provides
    public AuthorityContract.Presenter providePresenter(EstablishmentsRepository establishmentsRepository) {
        return new AuthorityPresenter(establishmentsRepository);
    }
}
