package com.gdglima.materialdesigntemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FloatLabelActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.ete_one) EditText eteOne;
    @InjectView(R.id.ete_two) EditText eteTwo;
    @InjectView(R.id.ete_three) EditText eteThree;
    @InjectView(R.id.bt_click_me) Button btClickMe;
    @InjectView(R.id.tvi_text) TextView tviText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_label);
        ButterKnife.inject(this);

        setToolBar();
        setComponents();
    }

    private void setToolBar() {
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle(getString(R.string.title_activity_floats));
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

    }

    private void setComponents(){
        btClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                text += eteOne.getText().toString()+"\n";
                text += eteTwo.getText().toString()+"\n";
                text += eteThree.getText().toString();

                tviText.setText(text);
            }
        });

        btClickMe.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                eteOne.setText("");
                eteTwo.setText("");
                eteThree.setText("");
                tviText.setText("");
                return false;
            }
        });
    }
}
