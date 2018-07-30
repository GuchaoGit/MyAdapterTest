package com.guc.myadptertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.guc.myadptertest.activity.TestArrayAdaper;
import com.guc.myadptertest.activity.TestPageAdapter;
import com.guc.myadptertest.activity.TestSimpleAdapter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_array_adapter, R.id.tv_simple_adapter,R.id.tv_page_adapter})
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
        }
    }

}
