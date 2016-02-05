package com.szmajnta.andrzej.clearmvc.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by andrzej on 01.02.2016.
 */
public abstract class BaseMvpActivity<T extends Presenter> extends
        AppCompatActivity implements View{
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLayout();
        ButterKnife.bind(this);
        presenter = createPresenter();
        presenter.bindView(this);
        presenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    protected abstract  T createPresenter();
    protected abstract void createLayout();
    protected abstract int getContentView();

}
