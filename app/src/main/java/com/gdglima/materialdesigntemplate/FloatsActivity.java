package com.gdglima.materialdesigntemplate;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FloatsActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar) Toolbar mToolbar;
    @InjectView(R.id.sum) FloatingActionButton sum;
    @InjectView(R.id.counter) TextView counter;

    private int counterNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floats);
        ButterKnife.inject(this);

        counterNumber = 0;
        setToolBar();
        setFloatingActionButton();
    }

    private void setToolBar() {
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        mToolbar.setTitle(getString(R.string.title_activity_floats));
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(mToolbar);
    }

    private void  setFloatingActionButton(){
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterNumber++;
                counter.setText(String.valueOf(counterNumber));
            }
        });

        sum.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                counterNumber = -1;
                counter.setText(String.valueOf(counterNumber));
                return false;
            }
        });
    }

}
