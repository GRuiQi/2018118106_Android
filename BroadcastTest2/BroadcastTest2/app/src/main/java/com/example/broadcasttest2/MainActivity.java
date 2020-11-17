package com.example.broadcasttest2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



        Receiver1 receiver1;
        Receiver2 receiver2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //动态注册接收者1，接收优先级1

            IntentFilter intentFilter1 = new IntentFilter("com.example.leidong.action.OrderedBroadcast");
            receiver1 = new Receiver1();
            intentFilter1.setPriority(1);
            registerReceiver(receiver1, intentFilter1);

            //动态注册接收者2，接收优先级0
            IntentFilter intentFilter2 = new IntentFilter("com.example.leidong.action.OrderedBroadcast");
            receiver2 = new Receiver2();
            intentFilter1.setPriority(0);
            registerReceiver(receiver2, intentFilter2);
            //发送有序广播
            Intent intent = new Intent("com.example.leidong.action.OrderedBroadcast");
            intent.putExtra("name", "ASUS...");
            sendOrderedBroadcast(intent, null);
        }

        @Override
        protected void onDestroy() {
            //广播注销
            unregisterReceiver(receiver1);
            unregisterReceiver(receiver2);
            super.onDestroy();
        }








}
