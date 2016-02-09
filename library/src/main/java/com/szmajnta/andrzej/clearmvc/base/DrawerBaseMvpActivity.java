package com.szmajnta.andrzej.clearmvc.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.ViewStub;

import com.szmajnta.andrzej.clearmvc.R;

/**
 * Created by andrzej on 05.02.2016.
 */
public abstract class DrawerBaseMvpActivity<V extends Presenter> extends BaseMvpActivity<V> implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawerLayout = (DrawerLayout)findViewById(R.id.clearmvp_drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.clearmvp_navigation_view);
        setupDrawer();
    }

    @Override
    protected final void createLayout() {
        setContentView(getDefaultBaseLayout());
        ViewStub stub = (ViewStub)findViewById(R.id.contentStub);
        stub.setLayoutResource(getContentView());
        stub.inflate();
    }

    private void setupDrawer() {
        navigationView.inflateHeaderView(getDefaultHeaderLayout());
        navigationView.inflateMenu(getMenu());

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getHeaderView(0);
    }

    protected void closeDrawer(){
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    protected void openDrawer(){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    protected int getDefaultBaseLayout(){
        return R.layout.clearmvp_drawer_activity;
    }

    protected int getDefaultHeaderLayout(){
        return R.layout.clearmvp_drawer_header;
    }

    protected int getMenu(){
        return R.menu.clearmvp_drawer_menu;
    }
}
