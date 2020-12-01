package com.example.servicedemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartService,btnStopService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStopService = (Button) findViewById(R.id.btnStopService);

        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
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
        }
    }
}
