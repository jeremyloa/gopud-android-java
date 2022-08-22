package com.example.qualifandroidjm22_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button toOrderPageBtn, toProfileBtn, toLoginBackBtn;
    private TextView unamePlaceholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unamePlaceholder = findViewById(R.id.unamePlaceholder);
        unamePlaceholder.setText(LoginActivity.currUser.getUname());

        toOrderPageBtn = findViewById(R.id.toOrderPageBtn);

        toOrderPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        toProfileBtn = findViewById(R.id.toProfileBtn);
        toProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        toLoginBackBtn = findViewById(R.id.toLoginBackBtn);
        toLoginBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.currUser = null;
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}