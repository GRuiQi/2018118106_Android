package com.example.startupmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Log.d("SecondActivity",this.toString());
        Log.d("SecondActivity","Tast id is"+getTaskId());
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               /* Intent intent = new Intent(FirstActivity.this,
                        FirstActivity.class);*/
                /*Intent intent = new Intent(SecondActivity.this,
                        FirstActivity.class);*/
                Intent intent = new Intent(SecondActivity.this,
                        ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

   /* @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }*/
}
