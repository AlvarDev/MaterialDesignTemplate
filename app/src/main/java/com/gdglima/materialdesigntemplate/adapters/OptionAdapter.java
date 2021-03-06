package com.gdglima.materialdesigntemplate.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdglima.materialdesigntemplate.R;
import com.gdglima.materialdesigntemplate.entities.OptionEntity;

import java.util.List;

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.ViewHolder>
        implements View.OnClickListener{

    private List<OptionEntity> mData;
    private View.OnClickListener listener;

    public OptionAdapter(List<OptionEntity> myData) {
        mData = myData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivImage;
        public TextView title;

        public ViewHolder(View v) {
            super(v);
            ivImage = (ImageView)v.findViewById(R.id.ivImage);
            title = (TextView)v.findViewById(R.id.title);
        }
    }

    @Override
    public OptionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_recycle_view_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mData.get(position).getTitle());
        holder.ivImage.setImageResource(mData.get(position).getIdImage());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }


}
