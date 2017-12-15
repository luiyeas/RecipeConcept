package com.recipe.recipe.app.base;

import android.app.Application;

import com.recipe.recipe.app.di.RootModule;
import com.recipe.recipe.app.di.component.DaggerRootComponent;
import com.recipe.recipe.app.di.component.RootComponent;

/**
 * Created by luis on 15/12/17.
 */

public class RecipeApplication extends Application {

    RootComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        mainComponent = DaggerRootComponent.builder().rootModule(new RootModule(this)).build();
    }

    public RootComponent getMainComponent() {
        return mainComponent;
    }

}
