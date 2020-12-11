package com.example.easy_note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button textbtn, imgbtn,videobtn;
    private ListView lv;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        //view
        lv = (ListView)findViewById(R.id.listView_main);
        textbtn = (Button) findViewById(R.id.text_button_main);
        imgbtn = (Button) findViewById(R.id.img_button_main);
        videobtn = (Button) findViewById(R.id.video_button_main);
        textbtn.setOnClickListener(this);
        imgbtn.setOnClickListener(this);
        videobtn.setOnClickListener(this);
    }

    public void onClick(View v){
        i = new Intent(this,AddContent.class);
        switch(v.getId()) {
            case R.id.text_button_main:
                i.putExtra("flag",1);
                startActivity(i);
                break;

            case R.id.img_button_main:
                i.putExtra("flag",2);
                startActivity(i);
                break;

            case R.id.video_button_main:
                i.putExtra("flag",3);
                startActivity(i);
                break;
        }
    }

}
