package com.guc.myadptertest.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.guc.myadptertest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guc on 2018/7/30.
 * 描述：（简单适配器）
 */
public class TestSimpleAdapter extends Activity {
    @BindView(R.id.list_view)
    ListView mListView;
    private List<Map<String, Object>> mDatas;
    private SimpleAdapter mAdapter;

    public static void jump(Context context) {
        Intent intent = new Intent(context, TestSimpleAdapter.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_arrayadapter);
        ButterKnife.bind(this);
        initData();
    }

    /**
     * SimpleAdapter参数说明：
     * 第一个参数：上下文对象
     * 第二个参数：数据源是含有Map的一个集合
     * 第三个参数：每一个item的布局文件
     * 第四个参数：new String[]{}数组，数组的里面的每一项要与第二个参数中的存入map集合的的key值一样，一一对应
     * 第五个参数：new int[]{}数组，数组里面的第三个参数中的item里面的控件id。
     */
    private void initData() {
        mDatas = new ArrayList<>();
        Map<String,Object> map= new HashMap<>();
        map.put("title","新闻标题");
        map.put("content","新闻内容");
        map.put("pic",R.mipmap.ic_launcher);
        mDatas.add(map);
        map= new HashMap<>();
        map.put("title","花边新闻");
        map.put("content","花边新闻内容提示");
        map.put("pic",R.drawable.user);
        mDatas.add(map);
        mAdapter = new SimpleAdapter(this, mDatas, R.layout.item_view, new String[]{"title","content","pic"}, new int[]{R.id.text1,R.id.text2,R.id.image1});
        mListView.setAdapter(mAdapter);
    }
}
