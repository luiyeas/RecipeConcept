package com.recipe.recipe.data.repository;

import android.content.Context;

import com.recipe.recipe.domain.model.server.RecipeResponse;
import com.recipe.recipe.domain.rest.Api;
import com.recipe.recipe.domain.rest.RetrofitAdapter;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by luis on 15/12/17.
 */

@Singleton
public class RecipeRepository {

    @NonNull
    private HeroesRepositoryService service;

    @Inject
    public RecipeRepository(Context context, RetrofitAdapter rAdapter) {
        this.service = rAdapter.getAdapter().create(HeroesRepositoryService.class);
    }

    public HeroesRepositoryService getService() {
        return this.service;
    }

    public interface HeroesRepositoryService {
        @Headers({"Accept: application/json"})
        @GET(Api.ENDPOINT.HEROES)
        Single<Response<RecipeResponse>> getRecipes(@Query("q") String q);
    }


}
