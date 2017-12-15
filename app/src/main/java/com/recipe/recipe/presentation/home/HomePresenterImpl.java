package com.recipe.recipe.presentation.home;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.recipe.recipe.domain.interactor.home.HomeInteractor;
import com.recipe.recipe.domain.interactor.home.implementation.HomeInteractorImpl;
import com.recipe.recipe.presentation.Presenter;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by luis on 15/12/17.
 */

public class HomePresenterImpl extends Presenter<HomePresenterImpl.View> {

    HomeInteractor mInteractor;

    @Inject
    public HomePresenterImpl(Context context, HomeInteractorImpl interactor) {
        super(context);

        this.mInteractor = interactor;
    }

    public void create() {
        mView.configureView();
    }

    public void destroy() {
        mInteractor.destroy();
    }

    public void textChanged(String text) {
        if(!TextUtils.isEmpty(text)){
            Log.d("tag", " perform search");
        }
    }

    public interface View extends Presenter.View {
        void configureView();
    }
}
