package com.szmajnta.andrzej.clearmvc.base;

/**
 * Created by andrzej on 05.02.2016.
 */
public abstract class NoDrawerBaseMvpActivity<V extends Presenter> extends BaseMvpActivity<V> {
    @Override
    protected final void createLayout() {
        setContentView(getContentView());
    }
}
