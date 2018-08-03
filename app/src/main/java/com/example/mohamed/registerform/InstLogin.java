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

public class InstLogin extends AppCompatActivity {

    SQLiteOpenHelper openHelper2;
    SQLiteDatabase db2;
    EditText _txtEmail2,_txtPass2;
    Cursor cursor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst_login);

        _txtEmail2 = (EditText) findViewById(R.id.txtemail2);
        _txtPass2 = (EditText) findViewById(R.id.txtpass2);
        openHelper2 = new DatabaseHelper(this);
        db2 = openHelper2.getReadableDatabase();
    }

    public void loginMe2(View view) {

        String email2 = _txtEmail2.getText().toString();
        String pass2 = _txtPass2.getText().toString();
        cursor2 = db2.rawQuery("SELECT *FROM " + DatabaseHelper.INST_TABLE + " WHERE " + DatabaseHelper.Col_email + "=? AND " + DatabaseHelper.Col_pass + "=?" , new String[]{email2, pass2});
        if (cursor2 != null) {
            if (cursor2.getCount() > 0) {
                Intent i = new Intent(InstLogin.this,Ins.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Please enter valid Email or Pasword", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void reg2(View view) {
        Intent i = new Intent(InstLogin.this,InstRegister.class);
        startActivity(i);
    }
}
