package com.example.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Activity与layout进行关联*/
        setContentView(R.layout.activity_test);
    }
}
