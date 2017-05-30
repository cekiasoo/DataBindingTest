package com.ce.advanced.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ce.advanced.R;
import com.ce.advanced.bean.User2;
import com.ce.advanced.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */

public class UserAdapter extends BaseAdapter {
    private Context mContext;
    private List<User2> mData;

    public UserAdapter(Context pContext, List<User2> pData) {
        this.mContext = pContext;
        this.mData = pData != null ? pData : new ArrayList<User2>();
    }
    @Override
    public int getCount() {
        return mData.size();
    }
    @Override
    public User2 getItem(int position) {
        return mData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int _LayoutId = R.layout.list_item;
        ViewHolder _Holder= ViewHolder.getViewHolder(mContext, _LayoutId, convertView, parent);
        _Holder.mItemBinding.setUser(mData.get(position));
        return _Holder.mConvertView;
    }
    public void addItem(int pPostion, User2 pUser) {
        this.mData.add(pPostion, pUser);
        notifyDataSetChanged();
    }
    private static class ViewHolder{
        ListItemBinding mItemBinding;
        View mConvertView;
        private ViewHolder(Context pContext, ViewGroup parent, int pLayoutId) {
            mItemBinding = DataBindingUtil.inflate(LayoutInflater.from(pContext), pLayoutId, parent, false);
            this.mConvertView = mItemBinding.getRoot();
            this.mConvertView.setTag(this);
        }
        static ViewHolder getViewHolder(Context pContext, int pLayoutId, View convertView, ViewGroup parent) {
            if (convertView == null) {
                return new ViewHolder(pContext, parent, pLayoutId);
            }
            return (ViewHolder) convertView.getTag();
        }
    }
}
