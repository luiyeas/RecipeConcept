package com.recipe.recipe.domain.executor;

import android.os.Handler;


public class MainThreadExecutor {

    private Handler handler;

    public MainThreadExecutor(Handler handler){
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
