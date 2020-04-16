package com.guc.myadptertest.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.guc.myadptertest.Fragment.FragmentContent;

/**
 * Created by guc on 2020/4/16.
 * 描述：VP2 + Fragment适配器
 */
public class ViewPager2FragmentStateAdapter extends FragmentStateAdapter {
    private static final String TAG = "ViewPager2FragmentState";

    public ViewPager2FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPager2FragmentStateAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPager2FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.e(TAG, "createFragment " + position);
        return FragmentContent.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
