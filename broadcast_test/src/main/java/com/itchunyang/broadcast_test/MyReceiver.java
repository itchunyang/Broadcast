package com.itchunyang.broadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by luchunyang on 2016/11/7.
 */

public class MyReceiver extends BroadcastReceiver {

    public static final String TAG = MyReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: " + intent.getAction());

        if(isOrderedBroadcast()){

            Bundle bundle = new Bundle();
            bundle.putString("flag","abc");
            setResult(100,"ok",bundle);

//            Log.i(TAG, "onReceive: 提前终止广播");
//            abortBroadcast();
        }
    }
}
