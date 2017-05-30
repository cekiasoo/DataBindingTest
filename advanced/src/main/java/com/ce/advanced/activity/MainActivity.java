package com.ce.advanced.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ce.advanced.R;
import com.ce.advanced.bean.User;
import com.ce.advanced.bean.User2;
import com.ce.advanced.databinding.ActivityMainBinding;
import com.ce.advanced.event.EventHandlers;
import com.ce.advanced.event.Presenter;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //使用DataBindingUtil的setContentView设置布局文件
        ActivityMainBinding _ViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User _User = new User("CE", "123456");
//        绑定数据
        _ViewDataBinding.setUser(_User);
        //设置 EventHandlers
        _ViewDataBinding.setEvent(new EventHandlers());
        //设置 Presenter
        _ViewDataBinding.setPresenter(new Presenter());

        _ViewDataBinding.setUser2(new User2("CE", "123456"));
    }

}
