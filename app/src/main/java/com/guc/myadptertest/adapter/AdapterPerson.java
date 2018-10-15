package com.guc.myadptertest.adapter;

import android.content.Context;

import com.guc.myadptertest.R;
import com.guc.myadptertest.bean.BeanPerson;

import java.util.List;

/**
 * Created by guc on 2018/8/17.
 * 描述：
 */
public class AdapterPerson extends CommonRecycleAdapter<BeanPerson> {

    public AdapterPerson(Context context, List<BeanPerson> mDatas) {
        super(context, mDatas, R.layout.item_person);

    }

    @Override
    public void bindData(CommonViewHolder holder, BeanPerson data) {
        holder.setText(R.id.tv_name, "姓名：" + data.name)
                .setText(R.id.tv_age, "年龄：" + data.age);
    }
}
