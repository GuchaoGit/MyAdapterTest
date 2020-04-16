package com.guc.myadptertest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.guc.myadptertest.Fragment.FragmentContent;
import com.guc.myadptertest.R;
import com.guc.myadptertest.adapter.viewpage.AdapterViewPager;
import com.guc.myadptertest.adapter.viewpage.AdapterViewPager1;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import github.chenupt.springindicator.SpringIndicator;

/**
 * Created by guc on 2018/7/30.
 * 描述：
 */
public class TestPageAdapter extends AppCompatActivity {
    @BindView(R.id.vp_1)
    ViewPager mVp1;
    @BindView(R.id.vp_2)
    ViewPager mVp2;
    private static int[] mImages = {R.drawable.bg_guide_1, R.drawable.bg_guide_2, R.drawable.bg_guide_3};
    @BindView(R.id.indicator)
    SpringIndicator mIndicator;
    private AdapterViewPager mAdapter1;
    private List<Fragment> fragments;
    private AdapterViewPager1 mAdapter2;

    public static void jump(Context context) {
        Intent intent = new Intent(context, TestPageAdapter.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_pageadapter);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        fragments = new ArrayList<>();
        fragments.add(FragmentContent.newInstance(0));
        fragments.add(FragmentContent.newInstance(1));
        fragments.add(FragmentContent.newInstance(2));
        mAdapter1 = new AdapterViewPager(getSupportFragmentManager(), fragments);
        mVp1.setAdapter(mAdapter1);


        ViewPager.LayoutParams params = new ViewPager.LayoutParams();
        List<ImageView> imageViewList = new ArrayList<>(3);
        for (int i = 0; i < mImages.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(params);//设置布局
            iv.setImageResource(mImages[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageViewList.add(iv);
        }

        mAdapter2 = new AdapterViewPager1(imageViewList);
        mVp2.setAdapter(mAdapter2);

        mIndicator.setViewPager(mVp2);

    }
}
