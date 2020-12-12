package com.example.easy_note;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 *创建数据库
 *如何查看虚拟机里的文件 View - ToolWindows - Device File Explorer
 * data - data - 项目名 - database
 */
public class NotesDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "notes";
    public static final String CONTENT = "content";
    public static final String ID = "_id";
    public static final String TIME = "time";

    public NotesDB(Context context){
        super(context,"notes",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL = "create table if not exists " + TABLE_NAME + "(" +
                ID + " integer primary key autoincrement," +
                CONTENT + " text," +
                TIME + " text" +
                ")";
        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
