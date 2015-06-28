package com.gdglima.materialdesigntemplate;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.gdglima.materialdesigntemplate.adapters.OptionAdapter;
import com.gdglima.materialdesigntemplate.entities.OptionEntity;
import com.gdglima.materialdesigntemplate.utils.Const;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CollapsingToolbarActivity extends AppCompatActivity {

    @InjectView(R.id.ctToolbar) CollapsingToolbarLayout ctToolbar;
    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.zig) ImageView zig;
    @InjectView(R.id.rvOptions)RecyclerView rvOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);
        ButterKnife.inject(this);

        validateTransitions();
        setToolBar();
        setRecyclerView();
    }

    private void validateTransitions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            zig.setTransitionName("view");
        }
    }

    private void setToolBar() {
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        ctToolbar.setTitle(getString(R.string.title_activity_collapsing_toolbar));
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
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

            }
        });

        rvOptions.setAdapter(mAdapter);
        rvOptions.setItemAnimator(new DefaultItemAnimator());

    }

}
