package com.gdglima.materialdesigntemplate.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdglima.materialdesigntemplate.R;
import com.gdglima.materialdesigntemplate.entities.OptionEntity;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder>{

    private List<String> mData;

    public TextAdapter(List<String> myData) {
        mData = myData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tviText;

        public ViewHolder(View v) {
            super(v);
            tviText = (TextView)v.findViewById(R.id.tviText);
        }
    }

    @Override
    public TextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tviText.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



}
