package com.example.easy_note;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SelectAct extends Activity implements View.OnClickListener {

    private Button s_delete,s_back,s_edit;
    private TextView s_tv;
    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;
    private AlertDialog.Builder dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        //System.out.println(getIntent().getIntExtra(NotesDB.ID,0));
        s_delete = findViewById(R.id.delete_select);
        s_back = findViewById(R.id.back_select);
        s_edit = findViewById(R.id.edit_select);
        s_tv = findViewById(R.id.textView_select);

        notesDB = new NotesDB(this);
        dbWriter = notesDB.getWritableDatabase();
        s_back.setOnClickListener(this);
        s_delete.setOnClickListener(this);
        s_edit.setOnClickListener(this);
        s_tv.setText(getIntent().getStringExtra(NotesDB.CONTENT));

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.delete_select:

                dialog = new AlertDialog.Builder(this);

                dialog.setTitle("提示");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteData();
                        finish();
                    }
                });
                dialog.setCancelable(false);
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.show();


                break;

            case R.id.edit_select:
                int edit_id = getIntent().getIntExtra(NotesDB.ID,0);
                String edit_content = getIntent().getStringExtra(NotesDB.CONTENT);

                Intent ii = new Intent(this,EditContent.class);
                ii.putExtra("edit_id",edit_id);
                ii.putExtra("edit_content",edit_content);
                startActivity(ii);
                finish();
                break;
            case R.id.back_select:
                finish();
                break;



        }
    }

    private void deleteData(){
        dbWriter.delete(NotesDB.TABLE_NAME, NotesDB.ID + "=" +
                getIntent().getIntExtra(NotesDB.ID, 0), null);
    }
}


