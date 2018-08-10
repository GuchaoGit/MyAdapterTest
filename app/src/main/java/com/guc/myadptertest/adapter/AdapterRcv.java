package com.guc.myadptertest.adapter;

import android.content.Context;

import com.guc.myadptertest.R;

import java.util.List;

/**
 * Created by guc on 2018/8/10.
 * 描述：
 */
public class AdapterRcv<BeanRemind> extends CommonRecycleAdapter {

    public AdapterRcv(Context context, List<BeanRemind> datas){
        super(context,datas, R.layout.item_card);
    }

    @Override
    public void bindData(CommonViewHolder holder, Object data) {

    }
}
