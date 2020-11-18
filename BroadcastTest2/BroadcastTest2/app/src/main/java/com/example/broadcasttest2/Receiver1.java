package com.example.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Receiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        Log.e("Receiver1", name);
        Bundle b = new Bundle();
        b.putString("age","21");
        setResultExtras(b);
    }
}
