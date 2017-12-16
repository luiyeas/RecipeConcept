package com.recipe.recipe.presentation.home;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.recipe.recipe.domain.interactor.home.HomeInteractor;
import com.recipe.recipe.domain.interactor.home.implementation.HomeInteractorImpl;
import com.recipe.recipe.domain.model.Recipe;
import com.recipe.recipe.presentation.Presenter;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by luis on 15/12/17.
 */

public class HomePresenterImpl extends Presenter<HomePresenterImpl.View> implements HomeInteractorImpl.Callback {

    private HomeInteractorImpl mInteractor;

    public interface View extends Presenter.View {
        void configureView();

        void showHideEmptyView(boolean show);

        void showErrorView();

        void updateRecipes(ArrayList<Recipe> recipes);

        void clearData();
    }

    @Inject
    public HomePresenterImpl(Context context, HomeInteractorImpl interactor) {
        super(context);

        this.mInteractor = interactor;
    }

    public void create() {
        mView.configureView();
        mView.showHideEmptyView(true);
        mInteractor.addCallback(this);
    }

    public void destroy() {
        mInteractor.destroy();
    }

    public void textChanged(String text) {
        if (!TextUtils.isEmpty(text)) {
            mInteractor.requestRecipeByText(text);
        } else {
            showEmptyView();
        }
    }

    @Override
    public void onRecipesReceived(ArrayList<Recipe> listRecipes) {
        if (listRecipes.size() > 0) {
            mView.showHideEmptyView(false);
            mView.updateRecipes(listRecipes);
        } else {
            showEmptyView();
        }
    }

    @Override
    public void onRecipesError() {
        mView.showErrorView();
    }

    private void showEmptyView() {
        mView.showHideEmptyView(true);
        mView.clearData();
    }
}
