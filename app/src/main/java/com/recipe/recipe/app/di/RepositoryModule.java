package com.recipe.recipe.app.di;

import android.content.Context;

import com.recipe.recipe.data.repository.RecipeRepository;
import com.recipe.recipe.domain.rest.RetrofitAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class RepositoryModule {

    @Singleton
    @Provides
    RecipeRepository provideHeroesRepository(Context context, RetrofitAdapter retrofitAdapter) {
        return new RecipeRepository(context, retrofitAdapter);
    }
}
