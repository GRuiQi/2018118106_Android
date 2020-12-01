package com.example.servicedemo2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String  TAG = "MyService";

    private int i;

    class MyBinder extends Binder{
        public int getProcess(){
            return i;
        }
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG,"onBind");
        return new MyBinder();
    }



    @Override
    public void onCreate() {
        Log.d(TAG,"onCreate");
        super.onCreate();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                //Log.d(TAG,"处理具体的逻辑");

            }
        }).start();*/
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    for (i = 1; i <= 100; i++) {
                        sleep(1000);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestory");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"onUnbind");
        return super.onUnbind(intent);
    }



}
