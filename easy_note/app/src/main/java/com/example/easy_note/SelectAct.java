package com.example.easy_note;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SelectAct extends Activity implements View.OnClickListener {

    private Button s_delete,s_back;
    private TextView s_tv;
    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;


    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        //System.out.println(getIntent().getIntExtra(NotesDB.ID,0));
        s_delete = findViewById(R.id.delete_select);
        s_back = findViewById(R.id.back_select);

        s_tv = findViewById(R.id.textView_select);

        notesDB = new NotesDB(this);
        dbWriter = notesDB.getWritableDatabase();
        s_back.setOnClickListener(this);
        s_delete.setOnClickListener(this);

        s_tv.setText(getIntent().getStringExtra(NotesDB.CONTENT));
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.delete_select:
                deleteData();
                finish();
                break;
            case R.id.back_select:
                finish();

        }
    }

    private void deleteData(){
        dbWriter.delete(NotesDB.TABLE_NAME, NotesDB.ID + "=" +
                getIntent().getIntExtra(NotesDB.ID, 0), null);
    }
}


