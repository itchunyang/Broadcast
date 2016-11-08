package com.itchunyang.broadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by luchunyang on 2016/11/8.
 * 限制发送者
 * 在AndroidManifest.xml文件中，对要设置权限的Broadcast Receiver设置上android:permission属性，该属性值可以任意指定一个字符串。
 * 在AndroidManifest.xml文件中，与同级的位置，对外声明前面使用的标签，表示这个应用发布了一个叫做android.permission.camera的权限
 *
 * 发送者B要发送相应的广播，就要
 * 在B的AndroidManifest.xml中加入权限的使用，<uses-permission android:name="android.permission.camera"/>
 */

public class RequestPermissionReceiver extends BroadcastReceiver {
    
    public static final String TAG = RequestPermissionReceiver.class.getSimpleName();
    
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: ");
    }
}
