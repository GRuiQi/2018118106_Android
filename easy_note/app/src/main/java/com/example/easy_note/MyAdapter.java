package com.example.easy_note;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    private Context context;  //承接上下文
    private Cursor cursor; //数据库查询的结果
    private LinearLayout layout; //视图对象

    public MyAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return cursor.getPosition();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        layout = (LinearLayout) inflater.inflate(R.layout.cell, null);
        TextView contentTv = (TextView) layout.findViewById(R.id.list_content_cell);
        TextView timeTv = (TextView) layout.findViewById(R.id.list_time_cell);

        //cursor需要自己来查询
        cursor.moveToPosition(position);
        String content = cursor.getString(cursor.getColumnIndex(NotesDB.CONTENT));
        String time = cursor.getString(cursor.getColumnIndex(NotesDB.TIME));


        contentTv.setText(content);
        timeTv.setText(time);


        return layout;
    }
}