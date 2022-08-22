package com.example.qualifandroidjm22_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Vector;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister, btnLogin;
    private EditText etuname, etpass, etmail, etphone;
    private String uname, pass, mail, phone;
    public Vector<UserData> users;
    DBControl control;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        control = new DBControl(this);
        users = new Vector<>();
        btnRegister = findViewById(R.id.toMainPageBtn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.println(Log.INFO, "DEBUG", "REGISTER CLICKED");
                init(); set();
                if (val()==true) {
                    Log.println(Log.INFO, "DEBUG", "REGISTER VAL IS TRUE");
                    if (control.unameExists(uname)==false) {
                        Log.println(Log.INFO, "DEBUG", "UNAME EXISTS IS FALSE");
//                        LoginActivity.currUser = new UserData(null, uname, mail, phone, pass);
                        if (users.isEmpty()) users.add(new UserData(1, uname, mail, phone, pass));
                        else users.add(new UserData(users.size(), uname, mail, phone, pass));
                        control.insert(users.get(users.size()-1));
                        LoginActivity.currUser = users.get(users.size()-1);
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        Log.println(Log.INFO, "DEBUG", "not exist");
                        startActivity(intent);
                    } else Log.println(Log.INFO, "DEBUG", "UNAME EXISTS IS TRUE");
                } else Log.println(Log.INFO, "DEBUG", "REGISTER VAL IS FALSE");
            }
        });

        btnRegister = findViewById(R.id.toLoginPageBtn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        btnLogin = findViewById(R.id.toMainPageBtn);
        etuname = findViewById(R.id.uname);
        etpass = findViewById(R.id.pass);
        etmail = findViewById(R.id.mail);
        etphone = findViewById(R.id.phone);
    }

    public void set() {
        uname = etuname.getText().toString();
        pass = etpass.getText().toString();
        mail = etmail.getText().toString();
        phone = etphone.getText().toString();
    }

    public boolean val(){
        if (uname.isEmpty()||pass.isEmpty()||mail.isEmpty()||phone.isEmpty()) return false;
        return true;
    }
}