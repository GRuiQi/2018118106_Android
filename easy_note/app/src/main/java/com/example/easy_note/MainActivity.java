package com.example.easy_note;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button textbtn;
    private ListView lv;
    private Intent i;
    private Cursor cursor;
    private MyAdapter adapter;
    private NotesDB notesDB;
    private SQLiteDatabase dbReader;  //数据库读取权限

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
        textbtn.setOnClickListener(this);
        notesDB = new NotesDB(this);
        dbReader = notesDB.getReadableDatabase();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                Intent i = new Intent(MainActivity.this,SelectAct.class);
                i.putExtra(NotesDB.ID,cursor.getInt(cursor.getColumnIndex(NotesDB.ID)));
                i.putExtra(NotesDB.CONTENT,cursor.getString(cursor.getColumnIndex(NotesDB.CONTENT)));
                i.putExtra(NotesDB.TIME,cursor.getString(cursor.getColumnIndex(NotesDB.TIME)));
                startActivity(i);
            }
        });
    }

    public void onClick(View v){
        i = new Intent(this,AddContent.class);
        startActivity(i);

    }
    public void selectDB(){

        cursor = dbReader.query(NotesDB.TABLE_NAME,null,null,null,
                null,null,null);
        adapter = new MyAdapter(this,cursor);
        lv.setAdapter(adapter);
    }

    protected void onResume(){
        super.onResume();
        selectDB();
    }
}
