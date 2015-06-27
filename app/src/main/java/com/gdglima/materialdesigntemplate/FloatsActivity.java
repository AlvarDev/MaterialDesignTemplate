package com.gdglima.materialdesigntemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FloatsActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floats);
        ButterKnife.inject(this);

        setToolBar();
    }

    private void setToolBar() {
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        mToolbar.setTitle(getString(R.string.title_activity_floats));
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(mToolbar);
    }

}
