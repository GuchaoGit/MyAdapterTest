package com.guc.myadptertest.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;

import com.guc.myadptertest.R;
import com.guc.myadptertest.adapter.AdapterSwipeCardView;
import com.guc.myadptertest.bean.BeanRemind;
import com.guc.myadptertest.widget.swipecardview.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guc on 2018/7/30.
 * 描述：滑动切换View
 */
public class TestSwipeCardview extends Activity implements SwipeFlingAdapterView.onFlingListener {
    @BindView(R.id.swipe_view)
    SwipeFlingAdapterView mSwipeView;
    private AdapterSwipeCardView mSwipeViewAdapter;
    private List<BeanRemind> mSwipeViewDatas;
    public static void jump(Context context) {
        Intent intent = new Intent(context, TestSwipeCardview.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_swipe_cardview);
        ButterKnife.bind(this);
        initSwipeView();
        initData();
    }

    private void initSwipeView() {
        mSwipeViewDatas = new ArrayList<>();
        mSwipeView.setIsNeedSwipe(true);
        mSwipeView.setFlingListener(this);
        mSwipeView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(MotionEvent event, View v, Object dataObject) {
            }
        });
        mSwipeViewAdapter = new AdapterSwipeCardView(this);
        mSwipeView.setAdapter(mSwipeViewAdapter);
        mSwipeViewAdapter.addAll(mSwipeViewDatas);
    }

    private void initData() {
        mSwipeViewDatas = new ArrayList<>();
        mSwipeViewDatas.add(new BeanRemind());
        mSwipeViewDatas.add(new BeanRemind());
        mSwipeViewDatas.add(new BeanRemind());
        mSwipeViewDatas.add(new BeanRemind());
        mSwipeViewAdapter.addAll(mSwipeViewDatas);
    }

    @Override
    public void removeFirstObjectInAdapter() {//移除一个再添加一个，从而实现循环显示
        BeanRemind obj = mSwipeViewAdapter.getItem(0);
        mSwipeViewAdapter.remove(0);
        mSwipeViewAdapter.add(obj);
    }

    @Override
    public void onLeftCardExit(Object dataObject) {

    }

    @Override
    public void onRightCardExit(Object dataObject) {

    }

    @Override
    public void onAdapterAboutToEmpty(int itemsInAdapter) {

    }

    @Override
    public void onScroll(float progress, float scrollXProgress) {

    }
}
