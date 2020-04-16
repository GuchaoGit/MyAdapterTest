package com.guc.myadptertest.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.guc.myadptertest.R;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guc on 2018/7/30.
 * 描述：日历工具
 * 使用说明：https://juejin.im/post/5a6743836fb9a01caa20aefc
 */
public class TestCalendar extends Activity {

    @BindView(R.id.calendarView)
    CalendarView mCalendarView;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_cur_date)
    TextView mIvCurDate;
    @BindView(R.id.tv_go_back)
    TextView mTvGoBack;

    public static void jump(Context context) {
        Intent intent = new Intent(context, TestCalendar.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_calendar);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mIvCurDate.setText(String.format("当前日期：%d年%d月%d日", mCalendarView.getCurYear(), mCalendarView.getCurMonth(), mCalendarView.getCurDay()));
        mCalendarView.setOnDateSelectedListener(new CalendarView.OnDateSelectedListener() {//日期选择变化
            @Override
            public void onDateSelected(Calendar calendar, boolean isClick) {
                mIvCurDate.setText(String.format("当前日期：%d年%d月%d日", calendar.getYear(), calendar.getMonth(), calendar.getDay()));
            }
        });
        mCalendarView.setOnMonthChangeListener(new CalendarView.OnMonthChangeListener() {
            @Override
            public void onMonthChange(int year, int month) {
                Toast.makeText(TestCalendar.this,String.format("月发生改变了：当前%d年%d月",year,month),Toast.LENGTH_SHORT).show();
            }
        });
        mCalendarView.setOnYearChangeListener(new CalendarView.OnYearChangeListener() {
            @Override
            public void onYearChange(int year) {
                Toast.makeText(TestCalendar.this,String.format("年发生改变了：当前%d年",year),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick({R.id.tv_cur_date, R.id.tv_go_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cur_date:
                mCalendarView.showYearSelectLayout(mCalendarView.getSelectedCalendar().getYear());
                break;
            case R.id.tv_go_back:
                if (mCalendarView.isYearSelectLayoutVisible()){
                    mCalendarView.closeYearSelectLayout();
                }
                mCalendarView.scrollToCalendar(mCalendarView.getCurYear(), mCalendarView.getCurMonth(), mCalendarView.getCurDay());
                break;
        }
    }
}
