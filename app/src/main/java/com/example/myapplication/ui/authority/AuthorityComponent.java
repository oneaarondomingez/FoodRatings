package com.example.myapplication.ui.authority;

import com.example.myapplication.di.AppComponent;
import com.example.myapplication.di.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by user on 3/30/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = AuthorityModule.class)
public interface AuthorityComponent {
    void inject(AuthorityActivity authorityActivity);
}
