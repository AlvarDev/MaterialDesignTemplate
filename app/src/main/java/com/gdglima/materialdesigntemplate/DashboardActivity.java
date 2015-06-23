package com.gdglima.materialdesigntemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gdglima.materialdesigntemplate.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class DashboardActivity extends AppCompatActivity{

    private static final String TAG = "DashboardActivity";
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @InjectView(R.id.add) Button add;
    @InjectView(R.id.remove) Button remove;
    @InjectView(R.id.update) Button update;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.inject(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);


        final List<String> myDataset = new ArrayList<String>();

        for(int i=0; i<10; i++){
            myDataset.add("dota "+i);
        }
        mAdapter = new MyAdapter(myDataset);
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView text = (TextView) v.findViewById(R.id.tviTextItem);
                Log.i(TAG, "text "+ text.getText().toString());

            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataset.add(1, "Peru");
                mAdapter.notifyItemInserted(1);
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myDataset.size()>1) {
                    myDataset.remove(1);
                    mAdapter.notifyItemRemoved(1);
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myDataset.size()>2) {
                    String aux = myDataset.get(1);
                    myDataset.set(1, myDataset.get(2));
                    myDataset.set(2, aux);

                    mAdapter.notifyItemMoved(1, 2);
                }
            }
        });

    }


}
