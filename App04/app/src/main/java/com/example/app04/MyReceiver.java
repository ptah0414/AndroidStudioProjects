package com.example.app04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        Toast toast = Toast.makeText(context, "Something happens.", Toast.LENGTH_LONG);
        toast.show();
    }
}
