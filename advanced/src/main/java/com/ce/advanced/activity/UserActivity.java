package com.ce.advanced.activity;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ce.advanced.R;
import com.ce.advanced.fragment.UsersFragment;

public class UserActivity extends AppCompatActivity implements UsersFragment.OnFragmentInteractionListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_user);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_user, UsersFragment.newInstance(null, null))
                .commitAllowingStateLoss();
    }
    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
