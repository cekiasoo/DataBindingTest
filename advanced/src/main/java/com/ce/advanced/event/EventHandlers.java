package com.ce.advanced.event;

import android.view.View;
import android.widget.Toast;

public class EventHandlers {

    public void onLogin(View pView) {
        Toast.makeText(pView.getContext(), "on Login Click", Toast.LENGTH_SHORT).show();
    }

}
