package com.guc.myadptertest.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guc.myadptertest.R;

/**
 * Created by guc on 2018/7/30.
 * 描述：
 */
public class FragmentContent extends Fragment {
    private int mCurPage;
    public static FragmentContent newInstance(int page){
       FragmentContent fragmentContent = new FragmentContent();
       Bundle bundle = new Bundle();
       bundle.putInt("curPage",page);
       fragmentContent.setArguments(bundle);
       return fragmentContent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurPage = getArguments().getInt("curPage");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content,container,false);
        initView(view);
        return view;
    }

    private void initView(View rootView) {
        TextView tvContent = rootView.findViewById(R.id.tv_content);
        tvContent.setText(String.format("当前为第%d页",mCurPage));
    }
}
