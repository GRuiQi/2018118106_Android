package com.example.easy_note;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContent extends Activity implements View.OnClickListener {

    private Button savebtn,deletebtn;
    private EditText ettext;
    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        //val = getIntent().getStringExtra("flag");
        savebtn = (Button)findViewById(R.id.save_add);
        deletebtn = (Button)findViewById(R.id.cancel_add);
        ettext = (EditText)findViewById(R.id.ettext_add);

        savebtn.setOnClickListener(this);
        deletebtn.setOnClickListener(this);
        notesDB = new NotesDB(this);
        dbWriter = notesDB.getWritableDatabase();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save_add:
                addDB();
                finish();
                Toast.makeText(this,"操作成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel_add:
                finish();
                break;
        }
    }


    public void addDB(){
        ContentValues values = new ContentValues();

        if(ettext.getText()!= null)
        values.put(NotesDB.CONTENT,"-----------------[创建时间:"+TimeUtil.getTime()+"]------------------\n"+ettext.getText().toString());
        //values.put(NotesDB.TIME, getTime());
        dbWriter.insert(NotesDB.TABLE_NAME, null, values);


    }


}
