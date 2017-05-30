package com.ce.databindingtest.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ce.databindingtest.R;
import com.ce.databindingtest.bean.User;
import com.ce.databindingtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //使用DataBindingUtil的setContentView设置布局文件
        ActivityMainBinding _ViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User _User = new User("CE", "123456");
//        绑定数据
        _ViewDataBinding.setUser(_User);
    }
}
