package com.itchunyang.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registerOrdinary(View view) {
        //main线程
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i(TAG, "onReceive: "+intent.getAction() +" thread="+Thread.currentThread().getName());
            }
        };

        IntentFilter intentFilter = new IntentFilter("android.broadcast.ordinary");
        registerReceiver(receiver,intentFilter);
    }

    //普通广播 接收顺序未知。setPriority无效的.
    public void sendOrdinary(View view) {
        Intent intent = new Intent("android.broadcast.ordinary");
        sendBroadcast(intent);
    }


    //广播的级别有级别之分，级别数值是在 -1000 到 1000 之间 , 值越大 , 优先级越高；
    public void registerOrdered(View view) {
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i(TAG, "onReceive: "+intent.getAction() + " ResultCode="+ getResultCode()+" ResultData=" + getResultData()+" ResultExtras="+getResultExtras(false).getString("flag"));
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.broadcast.ordered");
        intentFilter.setPriority(500);
        registerReceiver(receiver,intentFilter);
    }

    public void sendOrdered(View view) {
        Intent intent = new Intent("android.broadcast.ordered");
        sendOrderedBroadcast(intent,null);
    }

    //Android的广播用例，总体来说安全性都不太好，因此只适用于安全性较低的数据传递
    public void localBroadcast(View view) {
        //局部通知管理
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(this);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.i(TAG, "onReceive: "+intent.getAction());
            }
        };

        manager.registerReceiver(receiver,new IntentFilter("android.broadcast.local"));

        manager.sendBroadcast(new Intent("android.broadcast.local"));
    }

    /**
     * xml 里面对外声明使用权限，
     * <permission android:name="android.permission.photo" android:protectionLevel="normal"/>
     * 表示这个应用发布了一个叫做android.permission.photo的权限。然后发送广播时可以要求接受者具有此权限
     *
     * 当接收者要接收这种广播的时候，在xml里使用<uses-permission android:name="android.permission.photo"/>
     */
    public void permission(View view) {
        Intent intent = new Intent("android.broadcast.permission");
        sendBroadcast(intent,"android.permission.photo");//要求接受者具备android.permission.photo权限
    }

    public void permission1(View view) {
        Intent intent = new Intent("android.broadcast.permission_1");
        sendBroadcast(intent);
    }
}
