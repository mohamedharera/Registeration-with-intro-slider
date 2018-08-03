package com.example.mohamed.registerform;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText _txtEmail,_txtPass;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _txtEmail = (EditText) findViewById(R.id.txtemail);
        _txtPass = (EditText) findViewById(R.id.txtpass);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
    }


    public void loginMe(View view) {

        String email = _txtEmail.getText().toString();
        String pass = _txtPass.getText().toString();


            cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.Table_Name + " WHERE " + DatabaseHelper.Col_5 + "=? AND " + DatabaseHelper.Col_4 + "=?" , new String[]{email, pass});
        if (cursor != null) {
                if (cursor.getCount() > 0) {
                    Intent i = new Intent(Login.this, Stu.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter valid Email or Pasword", Toast.LENGTH_LONG).show();
            }
         }
     }

    public void reg(View view) {
        Intent i = new Intent(Login.this,RegisterActivity.class);
        startActivity(i);
    }
}
