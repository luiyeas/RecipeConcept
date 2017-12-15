package com.recipe.recipe.app.di;

import android.content.Context;

import com.recipe.recipe.domain.interactor.home.implementation.HomeInteractorImpl;
import com.recipe.recipe.presentation.home.HomePresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    HomePresenterImpl provideHomePresenter(Context context, HomeInteractorImpl interactor) {
        return new HomePresenterImpl(context, interactor);
    }

}
