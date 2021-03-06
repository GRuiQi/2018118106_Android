package com.example.easy_note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditContent extends AppCompatActivity implements View.OnClickListener {

    private Button savebtn,deletebtn;
    private EditText ettext;
    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_content);

        savebtn = (Button)findViewById(R.id.save_edit);
        deletebtn = (Button)findViewById(R.id.cancel_edit);
        ettext = (EditText)findViewById(R.id.ettext_edit);

        ettext.setText(getIntent().getStringExtra("edit_content"));

        savebtn.setOnClickListener(this);
        deletebtn.setOnClickListener(this);
        notesDB = new NotesDB(this);
        dbWriter = notesDB.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save_edit:
                updateDB();
                finish();
                Toast.makeText(this,"编辑成功",Toast.LENGTH_SHORT).show();

                break;
            case R.id.cancel_edit:
                finish();
                break;
        }
    }

    public void updateDB(){
        ContentValues values = new ContentValues();

        //String content = "最新修改时间:" + TimeUtil.getTime() + "\n"+ ettext.getText().toString();
        int id =  getIntent().getIntExtra("edit_id",0);
        values.put(NotesDB.CONTENT, ettext.getText().toString());

        dbWriter.update(NotesDB.TABLE_NAME, values,NotesDB.ID + "="+id, null);


    }


}
