package com.guc.myadptertest.adapter;

import android.content.Context;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.guc.myadptertest.R;

import java.util.List;

/**
 * Created by guc on 2018/8/10.
 * 描述：可分组显示的Adapter
 */
public class GroupAdapter<P,C> extends GroupedRecyclerViewAdapter {
    private List<P> parents;
    private List<List<C>> childs;

    public GroupAdapter(Context context,List<P> parents,List<List<C>> childs){
        super(context);
        this.parents = parents;
        this.childs = childs;
    }
    @Override
    public int getGroupCount() {
        return parents == null ?0:parents.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childs==null?0:childs.get(groupPosition)==null?0:childs.get(groupPosition).size();
    }

    @Override
    public boolean hasHeader(int groupPosition) {
        return true;
    }

    @Override
    public boolean hasFooter(int groupPosition) {
        return false;
    }

    @Override
    public int getHeaderLayout(int viewType) {
        return R.layout.item_view;
    }

    @Override
    public int getFooterLayout(int viewType) {
        return 0;
    }

    @Override
    public int getChildLayout(int viewType) {
        return R.layout.item_card;
    }

    @Override
    public void onBindHeaderViewHolder(BaseViewHolder holder, int groupPosition) {

    }

    @Override
    public void onBindFooterViewHolder(BaseViewHolder holder, int groupPosition) {

    }

    @Override
    public void onBindChildViewHolder(BaseViewHolder holder, int groupPosition, int childPosition) {

    }
}
