package com.gdglima.materialdesigntemplate;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NavViewActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar) Toolbar mToolbar;
    @InjectView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @InjectView(R.id.nav_view) NavigationView navView;
    @InjectView(R.id.img_pic) ImageView imgPic;
    @InjectView(R.id.tvi_pic) TextView tviPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_view);
        ButterKnife.inject(this);

        validateTransitions();
        setToolBar();
        setNavigationView(R.id.drawer_option_one);
    }

    private void validateTransitions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imgPic.setTransitionName("view");
        }
    }


    private void setToolBar() {
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        mToolbar.setTitle(getString(R.string.title_activity_nav_view));
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setNavigationView(int idSelectedOption) {
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                setSelectedOption(menuItem);
                return true;
            }
        });

        setSelectedOption(navView.getMenu().findItem(idSelectedOption));
    }

    private void setSelectedOption(MenuItem menuItem){

        menuItem.setChecked(true);
        drawerLayout.closeDrawers();

        switch (menuItem.getItemId()) {
            case R.id.drawer_option_one:
                tviPic.setText(getString(R.string.s_option_one));
                imgPic.setImageResource(R.drawable.ioe5);
                break;

            case R.id.drawer_option_two:
                tviPic.setText(getString(R.string.s_option_two));
                imgPic.setImageResource(R.drawable.ioe1);
                break;

            case R.id.drawer_option_three:
                tviPic.setText(getString(R.string.s_option_three));
                imgPic.setImageResource(R.drawable.ioe2);
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
