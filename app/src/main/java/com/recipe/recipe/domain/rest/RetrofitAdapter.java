package com.recipe.recipe.domain.rest;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luis on 15/12/17.
 */

public class RetrofitAdapter {

    public Retrofit retrofit;

    public RetrofitAdapter(Context context) {
        init(context);
    }

    private void init(Context context) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(provideOkHTTPClient(context))
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                        .create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getAdapter() {
        return this.retrofit;
    }

    private OkHttpClient provideOkHTTPClient(final Context context) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Set timeout
        httpClient.readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);

        return httpClient.build();
    }
}
