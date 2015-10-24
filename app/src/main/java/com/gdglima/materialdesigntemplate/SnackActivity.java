package com.gdglima.materialdesigntemplate;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SnackActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.bt_normal) Button btNormal;
    @InjectView(R.id.bt_action) Button btAction;
    @InjectView(R.id.bt_infinite) Button btInfinite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);
        ButterKnife.inject(this);

        setToolBar();
        setComponents();
    }

    private void setToolBar() {
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle(getString(R.string.title_activity_snack));
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

    }

    private void setComponents(){
        btNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnack("This is a normal Snack");
            }
        });

        btAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActionSnack("This is a Snack with Action");
            }
        });

        btInfinite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfiniteSnack("This is a Infinite Snack");
            }
        });

    }


    private void showSnack(String message){
        Snackbar.make(findViewById(R.id.lla_container), message, Snackbar.LENGTH_LONG)
                .setAction("", null)
                .show();
    }

    private void showActionSnack(String message){
        Snackbar.make(findViewById(R.id.lla_container), message, Snackbar.LENGTH_LONG)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showSnack("You pressed Ok");
                    }
                })
                .show();
    }

    private void showInfiniteSnack(String message){
        Snackbar.make(findViewById(R.id.lla_container), message, Snackbar.LENGTH_INDEFINITE)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showSnack("You pressed Ok");
                    }
                })
                .show();
    }

}
