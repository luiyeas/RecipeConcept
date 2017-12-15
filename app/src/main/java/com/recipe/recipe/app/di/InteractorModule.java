package com.recipe.recipe.app.di;

import android.content.Context;


import com.recipe.recipe.domain.interactor.home.implementation.HomeInteractorImpl;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by luis on 1/11/17.
 */

@Module
public class InteractorModule {

    @Provides
    HomeInteractorImpl provideHomeInteractor(Context context) {
        return new HomeInteractorImpl(context);
    }

}
