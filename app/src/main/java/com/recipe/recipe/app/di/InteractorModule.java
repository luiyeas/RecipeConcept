package com.recipe.recipe.app.di;

import android.content.Context;


import com.recipe.recipe.data.repository.RecipeRepository;
import com.recipe.recipe.domain.executor.MainThreadExecutor;
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
    HomeInteractorImpl provideHomeInteractor(Context context, MainThreadExecutor mainThreadExecutor, CompositeDisposable compositeDisposable, RecipeRepository repository) {
        return new HomeInteractorImpl(context, mainThreadExecutor, compositeDisposable, repository);
    }

}
