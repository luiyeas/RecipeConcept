package com.recipe.recipe.app.di.component;

import com.recipe.recipe.app.di.RootModule;
import com.recipe.recipe.app.ui.home.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by luis on 15/12/17.
 */

@Singleton
@Component(modules = RootModule.class)
public interface RootComponent {
    void inject(MainActivity activity);
}
