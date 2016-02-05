package com.szmajnta.andrzej.clearmvc.base;

/**
 * Created by andrzej on 01.02.2016.
 */
public abstract class Presenter<T extends View> {
    protected T view;

    protected void onCreate(){

    }

    protected void onResume(){

    }

    protected void onStop(){

    }

    protected void onDestroy(){

    }

    public void bindView(T view){
        this.view = view;
    }
}
