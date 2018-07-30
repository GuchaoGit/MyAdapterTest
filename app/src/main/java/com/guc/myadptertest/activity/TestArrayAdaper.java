package com.guc.myadptertest.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.guc.myadptertest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guc on 2018/7/30.
 * 描述：（数组适配器）
 */
public class TestArrayAdaper extends Activity {
    @BindView(R.id.list_view)
    ListView mLv;

    private ArrayAdapter<String> mArrayAdapter;
    private List<String> mDatas;

    public static void jump(Context context) {
        Intent intent = new Intent(context, TestArrayAdaper.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_arrayadapter);
        ButterKnife.bind(this);
        initData();
    }

    /**
     * 系统提供的item的样式，可以试一试
     * simple_list_item1:单独的一行文本框
     * simple_list_item2:有两个文本框组成
     * simple_list_item_checked每项都是由一个已选中的列表项
     * simple_list_item_multiple_choice:都带有一个复选框
     * simple_list_item_single_choice：都带有一个单选框
     */
    private void initData() {
        mDatas = new ArrayList<>();
        mDatas.add("张三");
        mDatas.add("李四");
        mDatas.add("王五");
        mDatas.add("赵六");
        mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, mDatas);
        mLv.setAdapter(mArrayAdapter);
    }
}
