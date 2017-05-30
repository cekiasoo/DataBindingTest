package com.ce.advanced.event;

/**
 * Created by Administrator on 2017/5/30.
 */

public class UserFragmentPresenter {
    public interface OnUserAddListener {
        void onUserAdd();
    }
    private OnUserAddListener mOnUserAddListener;
    public void onUserAdd() {
        if (mOnUserAddListener != null) {
            mOnUserAddListener.onUserAdd();
        }
    }
    public void setOnUserAddListener(OnUserAddListener pOnUserAddListener) {
        this.mOnUserAddListener = pOnUserAddListener;
    }
}
