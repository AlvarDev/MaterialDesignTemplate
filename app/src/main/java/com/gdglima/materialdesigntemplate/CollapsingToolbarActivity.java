package com.gdglima.materialdesigntemplate;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.gdglima.materialdesigntemplate.adapters.TextAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CollapsingToolbarActivity extends AppCompatActivity {

    @InjectView(R.id.ctToolbar) CollapsingToolbarLayout ctToolbar;
    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.zig) ImageView zig;
    @InjectView(R.id.rvOptions) RecyclerView rvOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);
        ButterKnife.inject(this);

        validateTransitions();
        setRecyclerView();
        setToolBar();
    }

    private void validateTransitions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            zig.setTransitionName("view");
        }
    }

    private void setToolBar() {
        ctToolbar.setTitle(getString(R.string.title_activity_collapsing_toolbar));
        ctToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        ctToolbar.setExpandedTitleColor(getResources().getColor(R.color.white));

        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
    }

    private void setRecyclerView(){
        rvOptions.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvOptions.setLayoutManager(mLayoutManager);

        List<String> myData = new ArrayList<>();
        myData.add(getString(R.string.s_message));
        myData.add(getString(R.string.some_text));

        TextAdapter mAdapter = new TextAdapter(myData);
        rvOptions.setAdapter(mAdapter);

    }



}
