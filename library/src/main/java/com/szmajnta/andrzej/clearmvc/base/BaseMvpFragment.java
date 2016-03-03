package com.szmajnta.andrzej.clearmvc.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by andrzej on 11.02.2016.
 */
public abstract class BaseMvpFragment<P extends Presenter> extends Fragment implements com.szmajnta.andrzej.clearmvc.base.View{

    protected P presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getDefaultLayout(), container, false);
        presenter = createPresenter();
        presenter.bindView(this);
        presenter.onCreate();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    protected abstract int getDefaultLayout();

    protected abstract P createPresenter();
}
