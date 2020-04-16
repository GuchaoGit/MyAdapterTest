package com.guc.myadptertest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.guc.myadptertest.activity.TestAidl;
import com.guc.myadptertest.activity.TestArrayAdaper;
import com.guc.myadptertest.activity.TestCalendar;
import com.guc.myadptertest.activity.TestCalendarMeizu;
import com.guc.myadptertest.activity.TestCardAdapter;
import com.guc.myadptertest.activity.TestGroupRecycleView;
import com.guc.myadptertest.activity.TestPageAdapter;
import com.guc.myadptertest.activity.TestRecycleView;
import com.guc.myadptertest.activity.TestSimpleAdapter;
import com.guc.myadptertest.activity.TestSwipeCardview;
import com.guc.myadptertest.activity.Viewpager2Activity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_array_adapter, R.id.tv_simple_adapter, R.id.tv_page_adapter, R.id.tv_card_adapter, R.id.tv_swipe_cardview, R.id.tv_test_calendar, R.id.tv_test_calendar_meizu, R.id.tv_test_recycler_view, R.id.tv_test_group_recycler_view, R.id.tv_test_aidl, R.id.tv_test_vp2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_array_adapter:
                TestArrayAdaper.jump(this);
                break;
            case R.id.tv_simple_adapter:
                TestSimpleAdapter.jump(this);
                break;
            case R.id.tv_page_adapter:
                TestPageAdapter.jump(this);
                break;
            case R.id.tv_card_adapter:
                TestCardAdapter.jump(this);
                break;
            case R.id.tv_swipe_cardview:
                TestSwipeCardview.jump(this);
                break;
            case R.id.tv_test_calendar:
                TestCalendar.jump(this);
                break;
            case R.id.tv_test_calendar_meizu:
                TestCalendarMeizu.jump(this);
                break;
            case R.id.tv_test_recycler_view:
                TestRecycleView.jump(this);
                break;
            case R.id.tv_test_group_recycler_view:
                TestGroupRecycleView.jump(this);
                break;
            case R.id.tv_test_aidl:
                TestAidl.jump(this);
                break;
            case R.id.tv_test_vp2:
                Viewpager2Activity.jump(this);
                break;
        }
    }

}
