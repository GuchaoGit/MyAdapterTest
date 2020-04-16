package com.guc.myadptertest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by guc on 2020/4/16.
 * 描述：通用Viewpager2适配器
 */
public abstract class Viewpager2Adapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected List<T> dataList;
    protected int layoutId;
    protected Context mContext;
    private LayoutInflater layoutInflater;

    public Viewpager2Adapter(Context context, List<T> dataList, int layoutId) {
        this.mContext = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.dataList = dataList;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = layoutInflater.inflate(layoutId, parent, false);
        return new ViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        bindData(viewHolder, dataList.get(i));
    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    public void update(List<T> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void addList(List<T> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void clear() {
        this.dataList.clear();
        notifyDataSetChanged();
    }

    public boolean hasData() {
        return dataList != null && dataList.size() > 0;
    }

    public abstract void bindData(ViewHolder holder, T data);
}
