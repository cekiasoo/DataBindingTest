package com.ce.advanced.bean;

import android.databinding.ObservableField;

/**
 * Created by Administrator on 2017/5/29.
 */

public class User2 {
    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();

    public User2() {
    }

    public User2(String userName, String password) {
        this.userName.set(userName);
        this.password.set(password);
    }
}
