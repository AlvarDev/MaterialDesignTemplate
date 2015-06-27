package com.gdglima.materialdesigntemplate;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SplashActivity extends AppCompatActivity {

    @InjectView(R.id.imtTemp) ImageView imtTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getContentTransitionFeature();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);

        imtTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(DashboardActivity.class);
            }
        });

    }

    private void getContentTransitionFeature(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
    }

    private void goToActivity(Class<?> cls){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            Intent intent = new Intent(SplashActivity.this, cls);
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());

        } else {
            Intent intent = new Intent(SplashActivity.this, cls);
            startActivity(intent);
        }
    }


}
