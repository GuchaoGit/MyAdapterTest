package com.guc.myadptertest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.guc.myadptertest.R;
import com.guc.myadptertest.bean.BeanRemind;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guc on 2018/7/30.
 * 描述：
 */
public class AdapterSwipeCardView extends BaseAdapter {
    ArrayList<BeanRemind> objs;
    private Context mContext;

    public AdapterSwipeCardView(Context context) {
        objs = new ArrayList<>();
        this.mContext = context;
    }

    public void addAll(Collection<BeanRemind> collection) {
        if (isEmpty()) {
            objs.addAll(collection);
            notifyDataSetChanged();
        } else {
            objs.addAll(collection);
        }
    }

    public void add(BeanRemind obj) {
        if (isEmpty()) {
            objs.add(obj);
            notifyDataSetChanged();
        } else {
            objs.add(obj);
        }
    }

    public void clear() {
        objs.clear();
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return objs.isEmpty();
    }

    public void remove(int index) {
        if (index > -1 && index < objs.size()) {
            objs.remove(index);
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return objs.size();
    }

    @Override
    public BeanRemind getItem(int position) {
        if (objs == null || objs.size() == 0) return null;
        return objs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // TODO: getView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        BeanRemind bean = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    public class ViewHolder {
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_desc)
        TextView mTvDesc;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.card_view_root)
        CardView mCardViewRoot;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
