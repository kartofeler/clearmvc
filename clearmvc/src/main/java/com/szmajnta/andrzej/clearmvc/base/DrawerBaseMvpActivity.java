package com.szmajnta.andrzej.clearmvc.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.ViewStub;


import com.szmajnta.andrzej.clearmvc.R;

import butterknife.Bind;

/**
 * Created by andrzej on 05.02.2016.
 */
public abstract class DrawerBaseMvpActivity<V extends Presenter> extends BaseMvpActivity<V> implements NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.drawer)
    protected DrawerLayout drawerLayout;
    @Bind(R.id.navigation_view)
    protected NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                null, R.string.open, R.string.close);

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    protected void closeDrawer(){
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    protected void openDrawer(){
        drawerLayout.openDrawer(GravityCompat.START);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        closeDrawer();
        int id = item.getItemId();

        switch (id) {
            case R.id.logout:
                break;
        }
        return true;
    }

    protected int getDefaultBaseLayout(){
        return R.layout.drawer_activity;
    }
}
