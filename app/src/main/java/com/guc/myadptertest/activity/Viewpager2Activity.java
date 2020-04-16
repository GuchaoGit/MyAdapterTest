package com.guc.myadptertest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.guc.myadptertest.R;
import com.guc.myadptertest.adapter.ViewHolder;
import com.guc.myadptertest.adapter.ViewPager2FragmentStateAdapter;
import com.guc.myadptertest.adapter.Viewpager2Adapter;
import com.guc.myadptertest.bean.BeanRemind;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Viewpager2Activity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager2 viewPager2;
    @BindView(R.id.view_pager_fg)
    ViewPager2 viewPager2Fg;
    private Viewpager2Adapter<BeanRemind> mAdapter;
    private ViewPager2FragmentStateAdapter mAdapterFg;
    private List<BeanRemind> mDatas = new ArrayList<>();


    public static void jump(Context context) {
        Intent intent = new Intent(context, Viewpager2Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager2);
        ButterKnife.bind(this);

        mDatas.add(new BeanRemind());
        mDatas.add(new BeanRemind());
        mDatas.add(new BeanRemind());

        mAdapter = new Viewpager2Adapter<BeanRemind>(this, mDatas, R.layout.item_card) {
            @Override
            public void bindData(ViewHolder holder, BeanRemind data) {

            }
        };

        viewPager2.setAdapter(mAdapter);
        vp2Fg();
    }

    /**
     * Viewpager2+Fragment
     */
    private void vp2Fg() {
        viewPager2Fg.setOffscreenPageLimit(2);//懒加载中使用
        mAdapterFg = new ViewPager2FragmentStateAdapter(this);

        viewPager2Fg.setAdapter(mAdapterFg);
    }
}
