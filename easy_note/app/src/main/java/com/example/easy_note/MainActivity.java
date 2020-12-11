package com.example.easy_note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesDB = new NotesDB(this);
        dbWriter = notesDB.getWritableDatabase();
        addDB();
    }
    public void addDB(){
        ContentValues cv = new ContentValues();
        cv.put(NotesDB.CONTENT,"hello");
        cv.put(NotesDB.TIME,getTime());
        dbWriter.insert(NotesDB.TABLE_NAME, null, cv);

    }

    public String getTime(){
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy年MM月dd日 HH:mm:ss"
        );
        Date curDate = new Date();
        String str = format.format(curDate);
        return str;
    }
}
