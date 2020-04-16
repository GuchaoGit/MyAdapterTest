package com.guc.myadptertest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.guc.myadptertest.R;
import com.guc.myadptertest.adapter.cards.CardPagerAdapter;
import com.guc.myadptertest.adapter.cards.ShadowTransformer;
import com.guc.myadptertest.bean.BeanRemind;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guc on 2018/7/30.
 * 描述：卡片滑动列表布局
 */
public class TestCardAdapter extends AppCompatActivity {
    @BindView(R.id.vp_remind)
    ViewPager mVpRemind;
    private CardPagerAdapter mCardPagerAdapter;
    private ShadowTransformer mCardShadowTransformer;

    public static void jump(Context context) {
        Intent intent = new Intent(context, TestCardAdapter.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_cardadapter);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        mCardPagerAdapter = new CardPagerAdapter();
        mCardShadowTransformer = new ShadowTransformer(mVpRemind, mCardPagerAdapter);
        mCardShadowTransformer.enableScaling(true);
        mVpRemind.setPageTransformer(false, mCardShadowTransformer);
        mVpRemind.setAdapter(mCardPagerAdapter);
    }

    private void initData() {
        BeanRemind beanRemind = new BeanRemind();
        mCardPagerAdapter.addCardItem(beanRemind);
        beanRemind = new BeanRemind();
        mCardPagerAdapter.addCardItem(beanRemind);
        beanRemind = new BeanRemind();
        mCardPagerAdapter.addCardItem(beanRemind);
        mCardPagerAdapter.notifyDataSetChanged();
    }

}
