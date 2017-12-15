package com.recipe.recipe.presentation;

import android.content.Context;


public abstract class Presenter<T extends Presenter.View> {

    protected Context mContext;
    protected T mView;

    public Presenter(Context context) {
        mContext = context;
    }

    public T getView() {
        return mView;
    }

    public void setView(T view) {
        this.mView = view;
    }

    protected void onCreate() {
        // Empty
    }

    protected void onResume() {
        // Empty
    }

    protected void onPause() {
        // Empty
    }

    protected void onDestroy() {
        // Empty
    }

    public interface View {

    }

}
