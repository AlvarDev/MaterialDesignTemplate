package com.gdglima.materialdesigntemplate;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.gdglima.materialdesigntemplate.adapters.OptionAdapter;
import com.gdglima.materialdesigntemplate.entities.OptionEntity;
import com.gdglima.materialdesigntemplate.utils.Const;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class DashboardActivity extends AppCompatActivity{

    @InjectView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsing_toolbar;
    @InjectView(R.id.toolbar) Toolbar mToolbar;
    @InjectView(R.id.rvOptions) RecyclerView rvOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getContentTransitionFeature();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.inject(this);

        setRecyclerView();
        setToolBar();
    }

    private void getContentTransitionFeature(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
    }

    private void setToolBar() {
        setSupportActionBar(mToolbar);
        collapsing_toolbar.setTitle(getString(R.string.app_name));
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        //mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
    }

    private void setRecyclerView(){

        rvOptions.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        rvOptions.setLayoutManager(mLayoutManager);

        final List<OptionEntity> myData = Const.getOptionsDashboard();

        OptionAdapter mAdapter = new OptionAdapter(myData);
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setActions(rvOptions.getChildLayoutPosition(view),view);
            }
        });

        rvOptions.setAdapter(mAdapter);
        rvOptions.setItemAnimator(new DefaultItemAnimator());

    }

    private void setActions(int action, View view){

        switch (action){
            case Const.RV_LINEAR:
                goToActivity(RecyclerViewLinearActivity.class, null);
                break;
            case Const.RV_STAGGERED:
                goToActivity(RecyclerViewStaggeredActivity.class, null);
                break;
            case Const.RV_GRID:
                showMessage("This Activity is already a RecyclerView GridLayoutManager Example");
                break;
            case Const.COLLAPSING_TOOLBAR:
                goToActivity(CollapsingToolbarActivity.class, view);
                break;
            case Const.NAV_VIEW:
                goToActivity(NavViewActivity.class, view);
                break;
            case Const.TABS:
                goToActivity(TabsActivity.class, view);
                break;
            case Const.F_ACTION_BUTON:
                goToActivity(FloatsActivity.class,null);
                break;
            case Const.F_EDIT_TEXT:
                goToActivity(FloatsActivity.class, null);
                break;
            case Const.EXPLODE_ANIMATION:
                goToActivity(ExplodeAnimationActivity.class, null);
                break;
            case Const.SNACK:
                showSnack("This is a Snack");
                break;
        }

    }

    private void goToActivity(Class<?> cls, View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            Intent intent = new Intent(DashboardActivity.this, cls);

            ActivityOptions options = view != null ?
                    ActivityOptions.makeSceneTransitionAnimation(
                    DashboardActivity.this, view, "view") :
                    ActivityOptions.makeSceneTransitionAnimation(
                    DashboardActivity.this);

            startActivity(intent,options.toBundle());

        } else {
            Intent intent = new Intent(DashboardActivity.this, cls);
            startActivity(intent);
        }
    }

    private void showMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    private void showSnack(String message){
        Snackbar.make(findViewById(R.id.rlaContainer), message, Snackbar.LENGTH_LONG)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();
    }


}
