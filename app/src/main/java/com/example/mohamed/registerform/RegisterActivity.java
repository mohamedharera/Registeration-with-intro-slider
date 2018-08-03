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

public class RegisterActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText _txtName,_txtLast,_txtEmail,_txtPhone,_txtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openHelper = new DatabaseHelper(this);

        _txtName = (EditText) findViewById(R.id.txtName);
        _txtEmail = (EditText) findViewById(R.id.txtemail);
        _txtLast = (EditText) findViewById(R.id.txtLast);
        _txtPass = (EditText) findViewById(R.id.txtpass);
        _txtPhone = (EditText) findViewById(R.id.txtPhone);


    }

    public void insertData(String fname,String lname,String pass ,String email,String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.Col_2,fname);
        contentValues.put(DatabaseHelper.Col_3,lname);
        contentValues.put(DatabaseHelper.Col_4,pass);
        contentValues.put(DatabaseHelper.Col_5,email);
        contentValues.put(DatabaseHelper.Col_6,phone);


        long id = db.insert(DatabaseHelper.Table_Name,null,contentValues);
    }

    public void login(View view) {
        Intent intent = new Intent(RegisterActivity.this,Login.class);
        startActivity(intent);
    }

    public void register(View view) {

        db = openHelper.getWritableDatabase();
        String fname = _txtName.getText().toString();
        String lname = _txtLast.getText().toString();
        String pass = _txtPass.getText().toString();
        String email = _txtEmail.getText().toString();
        String phone = _txtPhone.getText().toString();
        insertData(fname,lname,pass,email,phone);

        Toast.makeText(getApplicationContext(), "Registeration successfully", Toast.LENGTH_SHORT).show();
    }
}
