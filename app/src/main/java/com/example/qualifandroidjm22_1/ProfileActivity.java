package com.example.qualifandroidjm22_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private Button toMainBackBtn;
    private TextView viewUname, viewMail, viewPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        viewUname = findViewById(R.id.viewUname);
        viewUname.setText(LoginActivity.currUser.getUname());
        viewMail = findViewById(R.id.viewMail);
        viewMail.setText(LoginActivity.currUser.getMail());
        viewPhone = findViewById(R.id.viewPhone);
        viewPhone.setText(LoginActivity.currUser.getPhone());

        toMainBackBtn = findViewById(R.id.toMainBackBtn);
        toMainBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}