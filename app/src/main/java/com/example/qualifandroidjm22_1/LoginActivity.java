package com.example.qualifandroidjm22_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private EditText etuname, etpass;
    private String uname, pass;
    private UserData tempUser;
    public static UserData currUser;
    DBControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        control = new DBControl(this);

        btnLogin = findViewById(R.id.toMainPageBtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.println(Log.INFO, "DEBUG", "LOGIN CLICKED");
                init();
                if(val()==true) {
                    Log.println(Log.INFO, "DEBUG", "VAL IS TRUE");
                    tempUser = control.login(uname, pass);
                    if(tempUser!=null) {
                        Log.println(Log.INFO, "DEBUG", "TEMP IS NOT NULL");
                        currUser = tempUser;
                        set();
                        finish();
                    } else Log.println(Log.INFO, "DEBUG", "TEMP IS NULL");
                } else Log.println(Log.INFO, "DEBUG", "VAL IS FALSE");
//                init();
//                set();
            }
        });
        
        btnRegister = findViewById(R.id.toRegisterPageBtn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        btnLogin = findViewById(R.id.toMainPageBtn);
        etuname = findViewById(R.id.uname);
        etpass = findViewById(R.id.pass);
        uname = etuname.getText().toString();
        pass = etpass.getText().toString();
    }

    public void set() {
//        uname = etuname.getText().toString();
//        pass = etpass.getText().toString();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//        intent.putExtra("uname", uname);
//        intent.putExtra("pass", pass);
        startActivity(intent);
    }

    public boolean val() {
//        String uname = etuname.getText().toString();
//        String pass = etpass.getText().toString();
        if (uname.isEmpty()|| pass.isEmpty()) return false;
        return true;
    }
}