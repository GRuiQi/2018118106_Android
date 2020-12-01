package com.example.servicedemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Button btnStartService,btnStopService,btnBindService,btnUnbindService,startIntentService;
    private MyService.DownloadBinder downloadBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStopService = (Button) findViewById(R.id.btnStopService);
        btnBindService = (Button) findViewById(R.id.btnBindService);
        btnUnbindService = (Button) findViewById(R.id.btnUnbindService);
        startIntentService = (Button) findViewById(R.id.start_intent_service);


        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
        btnUnbindService.setOnClickListener(this);
        startIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnStartService:
                Intent startIntent = new Intent(this,MyService.class);
                startService(startIntent);
                break;

            case R.id.btnStopService:
                Intent stopIntent = new Intent(this,MyService.class);
                stopService(stopIntent);
                break;

            case R.id.btnBindService:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent,this, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btnUnbindService:
                unbindService(this);
                break;

            case R.id.start_intent_service:
                // 打印主线程的id
                Log.d("MainActivity", "Thread id is " + Thread.currentThread(). getId());
                Intent intentService = new Intent(this, MyIntentService.class);
                startService(intentService);
                break;
            default:
                break;
        }
    }

    /**
     * Service成功绑定时执行该方法
     * @param name
     * @param service
     */
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

        downloadBinder = (MyService.DownloadBinder)service;
        downloadBinder.startDownload();
        downloadBinder.getProgress();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
