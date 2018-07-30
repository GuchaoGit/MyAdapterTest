package com.guc.myadptertest.adapter.viewpage;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class AdapterViewPager1 extends PagerAdapter {

    private List<ImageView> mImageViews;

    public AdapterViewPager1(List<ImageView> imageViews) {
        this.mImageViews = imageViews;
    }

    @Override
    public int getCount() {
        return mImageViews == null ? 0 : mImageViews.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImageViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mImageViews.get(position));
        return mImageViews.get(position);
    }
}
