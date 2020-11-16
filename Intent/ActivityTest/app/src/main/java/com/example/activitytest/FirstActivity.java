package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this,
//                        "You clicked Button 1",Toast.LENGTH_SHORT).show();
               // Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                Intent intent = new Intent("com.example.activitytest.MY_START");
                startActivity(intent);

            }
        });
    }
}
