package com.guc.myadptertest.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.guc.myadptertest.R;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guc on 2018/7/30.
 * 描述：日历工具--自定义界面风格
 * 使用说明：https://juejin.im/post/5a6743836fb9a01caa20aefc
 */
public class TestCalendarMeizu extends Activity {

    @BindView(R.id.calendarView)
    CalendarView mCalendarView;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_cur_date)
    TextView mIvCurDate;
    @BindView(R.id.tv_go_back)
    TextView mTvGoBack;

    private List<Calendar> mSchemeData;
    public static void jump(Context context) {
        Intent intent = new Intent(context, TestCalendarMeizu.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_calendar_meizu);
        ButterKnife.bind(this);
        initView();
        initData();
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
                Toast.makeText(TestCalendarMeizu.this,String.format("月发生改变了：当前%d年%d月",year,month),Toast.LENGTH_SHORT).show();
            }
        });
        mCalendarView.setOnYearChangeListener(new CalendarView.OnYearChangeListener() {
            @Override
            public void onYearChange(int year) {
                Toast.makeText(TestCalendarMeizu.this,String.format("年发生改变了：当前%d年",year),Toast.LENGTH_SHORT).show();
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

    private void initData() {
        mSchemeData = new ArrayList<>();
        Calendar calendar = new Calendar();
        calendar.setYear(2018);
        calendar.setMonth(7);
        calendar.setDay(31);
        calendar.setScheme("事");
        calendar.setSchemeColor(Color.parseColor("#ff2d2d"));
        mSchemeData.add(calendar);
        calendar = new Calendar();
        calendar.setYear(2018);
        calendar.setMonth(8);
        calendar.setDay(5);
        calendar.setScheme("事");
        calendar.setSchemeColor(Color.parseColor("#ff2d2d"));
        mSchemeData.add(calendar);
        calendar = new Calendar();
        calendar.setYear(2018);
        calendar.setMonth(8);
        calendar.setDay(10);
        calendar.setScheme("休");
        calendar.setSchemeColor(Color.parseColor("#009100"));
        mSchemeData.add(calendar);
        calendar = new Calendar();
        calendar.setYear(2018);
        calendar.setMonth(8);
        calendar.setDay(11);
        mSchemeData.add(calendar);
        calendar.setScheme("休");
        calendar.setSchemeColor(Color.parseColor("#009100"));
        mCalendarView.setSchemeDate(mSchemeData);
    }

}
