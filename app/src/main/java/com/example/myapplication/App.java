package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.data.DataModule;
import com.example.myapplication.data.RepoModule;
import com.example.myapplication.data.ratings.remote.RatingsService;
import com.example.myapplication.di.AppComponent;
import com.example.myapplication.di.AppModule;
import com.example.myapplication.di.DaggerAppComponent;

/**
 * Created by user on 3/30/17.
 */
public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        buildDaggerComponent();
    }

    private void buildDaggerComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule(RatingsService.BASE_URL))
                .repoModule(new RepoModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
