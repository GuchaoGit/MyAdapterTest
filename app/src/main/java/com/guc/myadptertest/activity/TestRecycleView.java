package com.guc.myadptertest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.guc.myadptertest.R;
import com.guc.myadptertest.adapter.AdapterRcv;
import com.guc.myadptertest.adapter.HeaderAndFooterWrapper;
import com.guc.myadptertest.bean.BeanRemind;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guc on 2018/8/10.
 * 描述：RecycleView添加header
 */
public class TestRecycleView extends AppCompatActivity {
    @BindView(R.id.rcv)
    RecyclerView mRcv;

    private AdapterRcv mAdapter;
    private List<BeanRemind> mDatas;
    private HeaderAndFooterWrapper mWrapper;

    public static void jump(Context context) {
        Intent intent = new Intent(context, TestRecycleView.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_recycleview);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mRcv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        mRcv.setLayoutManager(new GridLayoutManager(this,2));
        mDatas = new ArrayList<>();
        mDatas.add(new BeanRemind());
        mDatas.add(new BeanRemind());
        mDatas.add(new BeanRemind());
        mDatas.add(new BeanRemind());
        mDatas.add(new BeanRemind());
        mAdapter = new AdapterRcv(this,mDatas);
        mWrapper = new HeaderAndFooterWrapper(mAdapter);
        mWrapper.addHeaderView(View.inflate(this,R.layout.item_view,null));
        mWrapper.addHeaderView(View.inflate(this,R.layout.item_view,null));
        mWrapper.addFootView(View.inflate(this,R.layout.item_view,null));
        mWrapper.addFootView(View.inflate(this,R.layout.item_view,null));
        mRcv.setAdapter(mWrapper);
    }

}
