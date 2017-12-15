package com.recipe.recipe.domain.interactor;


import android.content.Context;



public abstract class AbstractInteractor implements Interactor {

    protected Context mContext;

    public AbstractInteractor( Context context) {
        mContext = context;
    }


}
