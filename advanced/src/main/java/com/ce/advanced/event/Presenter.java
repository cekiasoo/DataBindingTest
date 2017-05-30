package com.ce.advanced.event;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ce.advanced.activity.UserActivity;
import com.ce.advanced.bean.User;
import com.ce.advanced.bean.User2;

/**
 * Created by Administrator on 2017/5/28.
 */

public class Presenter {
    public void onLogin(User pUser) {
        Log.v("Presenter", "UserName = " + pUser.getUserName() + ", Password = " + pUser.getPassword());
    }

    public void onLogin(View pView, User pUser) {
        Toast.makeText(pView.getContext(), pUser.getUserName() + " " + pUser.getPassword(), Toast.LENGTH_SHORT).show();
    }

    public void onLogin() {
        Log.v("Presenter", "onLogin");
    }

    public void onLogin(View pView, User2 pUser) {
//        Toast.makeText(pView.getContext(), "User2 " + pUser.userName.get() + " " + pUser.password.get(), Toast.LENGTH_SHORT).show();
        if ("CE".equals(pUser.userName.get()) && "123456".equals(pUser.password.get())) {
            onSuccess(pView.getContext());
        } else {
            onFail(pView.getContext());
        }
    }
    private void onSuccess(Context pContext) {
        Toast.makeText(pContext, "Success", Toast.LENGTH_SHORT).show();
        Intent _Intent = new Intent(pContext, UserActivity.class);
        pContext.startActivity(_Intent);
    }

    private void onFail(Context pContext) {
        Toast.makeText(pContext, "Fail", Toast.LENGTH_SHORT).show();
    }

    public final TextWatcher OnUserNameChange = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.v("Presenter", "beforeTextChanged = " + s);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.v("Presenter", "onTextChanged = " + s);
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.v("Presenter", "afterTextChanged = " + s);
        }
    };
}
