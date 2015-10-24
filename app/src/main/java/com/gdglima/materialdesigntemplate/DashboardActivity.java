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
import android.widget.ImageView;
import android.widget.Toast;

import com.gdglima.materialdesigntemplate.adapters.OptionAdapter;
import com.gdglima.materialdesigntemplate.entities.OptionEntity;
import com.gdglima.materialdesigntemplate.utils.Const;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class DashboardActivity extends AppCompatActivity{

    @InjectView(R.id.ctToolbar) CollapsingToolbarLayout ctToolbar;
    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.rvOptions) RecyclerView rvOptions;
    @InjectView(R.id.logoGDG) ImageView logoGDG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getContentTransitionFeature();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.inject(this);

        validateTransitions();
        setRecyclerView();
        setToolBar();
    }

    private void getContentTransitionFeature(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
    }

    private void validateTransitions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            logoGDG.setTransitionName("view");
        }
    }

    private void setToolBar() {
        setSupportActionBar(toolbar);
        ctToolbar.setTitle(getString(R.string.app_name));
        ctToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        ctToolbar.setExpandedTitleColor(getResources().getColor(R.color.bg_transparent));
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
                showSnack("This Activity is already a RecyclerView GridLayoutManager Example");
                break;
            case Const.COLLAPSING_TOOLBAR:
                goToActivity(CollapsingToolbarActivity.class, view);
                break;
            case Const.NAV_VIEW:
                goToActivity(NavViewActivity.class, view);
                break;
            case Const.TABS:
                goToActivity(TabsActivity.class, null);
                break;
            case Const.F_ACTION_BUTON:
                goToActivity(FloatsActivity.class,null);
                break;
            case Const.F_EDIT_TEXT:
                goToActivity(FloatLabelActivity.class, null);
                break;
            case Const.EXPLODE_ANIMATION:
                goToActivity(ExplodeAnimationActivity.class, null);
                break;
            case Const.SNACK:
                goToActivity(SnackActivity.class, null);
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

    private void showSnack(String message){
        Snackbar.make(findViewById(R.id.rlaContainer), message, Snackbar.LENGTH_LONG)
                .setAction("", null)
                .show();
    }


}
