package com.ce.advanced.recycler;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ce.advanced.R;
import com.ce.advanced.bean.User2;
import com.ce.advanced.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/30.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context mContext;
    private List<User2> mData;

    public UserAdapter(Context pContext, List<User2> pData) {
        this.mContext = pContext;
        this.mData = pData != null ? pData : new ArrayList<User2>();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int _LayoutId = R.layout.list_item;
        return MyViewHolder.getViewHolder(mContext, _LayoutId, parent);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mItemBinding.setUser(mData.get(position));
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }
    public void addItem(int pPostion, User2 pUser) {
        mData.add(pPostion, pUser);
        notifyItemInserted(pPostion);
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding mItemBinding;
        private MyViewHolder(ListItemBinding pItemBinding) {
            super(pItemBinding.getRoot());
            this.mItemBinding = pItemBinding;
        }
        static MyViewHolder getViewHolder(Context pContext, int pLayoutId, ViewGroup parent) {
            ListItemBinding _ItemBinding = DataBindingUtil.inflate(LayoutInflater.from(pContext), pLayoutId, parent, false);
            return new MyViewHolder(_ItemBinding);
        }
    }
}
