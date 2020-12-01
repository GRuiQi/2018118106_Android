package com.example.servicedemo2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String  TAG = "TAG";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG,"onCreate");
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestory");
        super.onDestroy();
    }
}
