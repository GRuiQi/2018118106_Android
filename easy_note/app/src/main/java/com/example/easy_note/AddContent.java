package com.example.easy_note;



import android.app.Activity;
import android.os.Bundle;

public class AddContent extends Activity {

    private String val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        val = getIntent().getStringExtra("flag");
    }
}
