package com.example.mohamed.registerform;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InstRegister extends AppCompatActivity {

    SQLiteOpenHelper openHelper2;
    SQLiteDatabase db2;
    EditText _txtName2,_txtLast2,_txtEmail2,_txtPhone2,_txtPass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst_register);

        openHelper2 = new DatabaseHelper(this);
        _txtName2 = (EditText) findViewById(R.id.txtName2);
        _txtEmail2 = (EditText) findViewById(R.id.txtemail2);
        _txtLast2 = (EditText) findViewById(R.id.txtLast2);
        _txtPass2 = (EditText) findViewById(R.id.txtpass2);
        _txtPhone2 = (EditText) findViewById(R.id.txtPhone2);
    }

    public void insertData(String fname2,String lname2,String pass2 ,String email2,String phone2){
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(DatabaseHelper.Col_name,fname2);
        contentValues2.put(DatabaseHelper.Col_last,lname2);
        contentValues2.put(DatabaseHelper.Col_pass,pass2);
        contentValues2.put(DatabaseHelper.Col_email,email2);
        contentValues2.put(DatabaseHelper.Col_phone,phone2);


        long id2 = db2.insert(DatabaseHelper.INST_TABLE,null,contentValues2);
    }

    public void login2(View view) {
        Intent intent = new Intent(InstRegister.this,InstLogin.class);
        startActivity(intent);
    }

    public void register2(View view) {

        db2 = openHelper2.getWritableDatabase();
        String fname2 = _txtName2.getText().toString();
        String lname2 = _txtLast2.getText().toString();
        String pass2 = _txtPass2.getText().toString();
        String email2 = _txtEmail2.getText().toString();
        String phone2 = _txtPhone2.getText().toString();
        insertData(fname2,lname2,pass2,email2,phone2);

        Toast.makeText(getApplicationContext(), "Registeration successfully", Toast.LENGTH_SHORT).show();
    }
}
