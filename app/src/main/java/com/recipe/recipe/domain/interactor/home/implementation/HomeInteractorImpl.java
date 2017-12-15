package com.recipe.recipe.domain.interactor.home.implementation;

import android.content.Context;

import com.recipe.recipe.domain.interactor.AbstractInteractor;
import com.recipe.recipe.domain.interactor.home.HomeInteractor;

import javax.inject.Inject;

/**
 * Created by luis on 15/12/17.
 */

public class HomeInteractorImpl extends AbstractInteractor implements HomeInteractor {

    @Inject
    public HomeInteractorImpl(Context context) {
        super(context);
    }

    @Override
    public void run() {

    }

    @Override
    public void removeCallbacks() {

    }

    @Override
    public void destroy() {

    }
}
