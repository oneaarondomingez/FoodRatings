package com.example.myapplication.di;

import android.content.Context;

import com.example.myapplication.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 3/30/17.
 */

@Singleton
@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    public Context provideContext() {
        return app.getApplicationContext();
    }

    @Provides
    public App provideApp() {
        return app;
    }
}