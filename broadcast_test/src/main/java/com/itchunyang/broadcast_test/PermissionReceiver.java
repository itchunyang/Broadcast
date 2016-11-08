package com.itchunyang.broadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by luchunyang on 2016/11/8.
 */

public class PermissionReceiver extends BroadcastReceiver {
    public static final String TAG = PermissionReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: "+intent.getAction());
    }
}
