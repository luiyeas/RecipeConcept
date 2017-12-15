package com.recipe.recipe.app.di.component;


import com.recipe.recipe.app.di.PresenterModule;

import dagger.Component;

/**
 * Created by luis on 1/11/17.
 */
@Component(modules = PresenterModule.class, dependencies = {InteractorComponent.class})
public interface PresenterComponent {
}
