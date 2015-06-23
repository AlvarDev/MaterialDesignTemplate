package com.gdglima.materialdesigntemplate.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdglima.materialdesigntemplate.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener{

    private List<String> mDataset;
    private View.OnClickListener listener;

    public MyAdapter(List<String> myDataset) {
        mDataset = myDataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tviTextItem;
        public ImageView iviImageItem;
        public ViewHolder(View v) {
            super(v);
            tviTextItem = (TextView)v.findViewById(R.id.tviTextItem);
            iviImageItem = (ImageView)v.findViewById(R.id.iviImageItem);
        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycle_view_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tviTextItem.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
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
