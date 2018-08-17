package com.guc.myadptertest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import com.donkingliang.groupedadapter.holder.BaseViewHolder;
import com.guc.myadptertest.R;
import com.guc.myadptertest.adapter.AdapterRcv;
import com.guc.myadptertest.adapter.GroupAdapter;
import com.guc.myadptertest.adapter.HeaderAndFooterWrapper;
import com.guc.myadptertest.bean.BeanRemind;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guc on 2018/8/10.
 * 描述：可分租的RecycleView
 */
public class TestGroupRecycleView extends AppCompatActivity {
    @BindView(R.id.rcv)
    RecyclerView mRcv;

    private GroupAdapter mAdapter;
    private List<BeanRemind> mDatasParents;
    private List<BeanRemind> mDatasChildsss;
    private List<List<BeanRemind>> mDatasChilds;

    public static void jump(Context context) {
        Intent intent = new Intent(context, TestGroupRecycleView.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_recycleview);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mRcv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mDatasParents = new ArrayList<>();
        mDatasParents.add(new BeanRemind());
        mDatasParents.add(new BeanRemind());
        mDatasParents.add(new BeanRemind());
        mDatasParents.add(new BeanRemind());
        mDatasParents.add(new BeanRemind());

        mDatasChilds = new ArrayList<>();
        mDatasChildsss = new ArrayList<>();
        mDatasChildsss.add(new BeanRemind());
        mDatasChilds.add(mDatasChildsss);

        mDatasChildsss = new ArrayList<>();
        mDatasChildsss.add(new BeanRemind());
        mDatasChildsss.add(new BeanRemind());
        mDatasChildsss.add(new BeanRemind());
        mDatasChilds.add(mDatasChildsss);

        mDatasChildsss = new ArrayList<>();
        mDatasChildsss.add(new BeanRemind());
        mDatasChildsss.add(new BeanRemind());
        mDatasChilds.add(mDatasChildsss);

        mDatasChildsss = new ArrayList<>();
        mDatasChildsss.add(new BeanRemind());
        mDatasChildsss.add(new BeanRemind());
        mDatasChildsss.add(new BeanRemind());
        mDatasChildsss.add(new BeanRemind());
        mDatasChilds.add(mDatasChildsss);

        mDatasChildsss = new ArrayList<>();
        mDatasChildsss.add(new BeanRemind());
        mDatasChilds.add(mDatasChildsss);
        mAdapter = new GroupAdapter(this,mDatasParents,mDatasChilds);
        mRcv.setAdapter(mAdapter);
        mAdapter.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition, int childPosition) {
                Toast.makeText(TestGroupRecycleView.this,String.format("您点击了地%d组，第%d个",groupPosition+1,childPosition+1),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
