package com.recipe.recipe.domain.interactor.home.implementation;

import android.content.Context;

import com.recipe.recipe.data.repository.RecipeRepository;
import com.recipe.recipe.domain.executor.MainThreadExecutor;
import com.recipe.recipe.domain.interactor.AbstractInteractor;
import com.recipe.recipe.domain.interactor.home.HomeInteractor;
import com.recipe.recipe.domain.model.Recipe;
import com.recipe.recipe.domain.model.server.RecipeResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by luis on 15/12/17.
 */

public class HomeInteractorImpl extends AbstractInteractor implements HomeInteractor {

    private CompositeDisposable mCompositeDisposable;
    private MainThreadExecutor mMainThreadExecutor;
    private RecipeRepository mRepository;
    private HomeInteractorImpl.Callback mCallback;


    @Inject
    public HomeInteractorImpl(Context context, MainThreadExecutor mainThreadExecutor, CompositeDisposable compositeDisposable, RecipeRepository repository) {
        super(context);

        this.mMainThreadExecutor = mainThreadExecutor;
        this.mCompositeDisposable = compositeDisposable;
        this.mRepository = repository;
    }

    @Override
    public void run() {

    }

    @Override
    public void removeCallbacks() {
        mCallback = null;
    }

    @Override
    public void destroy() {
        mCompositeDisposable.clear();
    }

    public void addCallback(HomeInteractor.Callback callback) {
        this.mCallback = callback;
    }

    public void requestRecipeByText(String text) {
        mCompositeDisposable.clear();
        mCompositeDisposable.add(
                mRepository
                        .getService()
                        .getRecipes(text)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Response<RecipeResponse>>() {
                            @Override
                            public void accept(@NonNull Response<RecipeResponse> recipesResponse) throws Exception {
                                if (recipesResponse != null && recipesResponse.body() != null && recipesResponse.body().getResults() != null) {
                                    postHeroesReceived(recipesResponse.body().getResults());
                                } else {
                                    postError();
                                }
                            }
                        }));

    }

    private void postError() {
        if (mMainThreadExecutor.getHandler() != null && mCallback != null) {
            mMainThreadExecutor.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onRecipesError();
                }
            });
        }
    }

    private void postHeroesReceived(final ArrayList<Recipe> recipes) {
        if (mMainThreadExecutor.getHandler() != null && mCallback != null) {
            mMainThreadExecutor.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onRecipesReceived(recipes);
                }
            });
        }
    }
}
