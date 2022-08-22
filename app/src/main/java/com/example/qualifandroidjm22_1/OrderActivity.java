package com.example.qualifandroidjm22_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    Button toOrderBtn, toMainBackBtn1;
    TextView foodRest, foodName;
//    Spinner foodQty;
    final int SEND_SMS_PERM_REQ_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        foodRest = findViewById(R.id.foodRest);
        foodName = findViewById(R.id.foodName);
        toOrderBtn = findViewById(R.id.toOrderBtn);
        toOrderBtn.setEnabled(false);
        if (checkPerm(Manifest.permission.SEND_SMS)) {
            toOrderBtn.setEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS}, SEND_SMS_PERM_REQ_CODE);
        }
        toOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(OrderActivity.this, MessagingActivity.class);
//                startActivity(intent);
            }
        });

        toMainBackBtn1 = findViewById(R.id.toMainBackBtn);
        toMainBackBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Fragment fragment = new MapFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();


    }

    public void onSend(View view) {
        String foodRestStr = foodRest.getText().toString();
        String foodNameStr = foodName.getText().toString();
        if (foodRestStr == null || foodNameStr == null) return;
        if (checkPerm(Manifest.permission.SEND_SMS)) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("089525866585", null, foodRestStr+foodNameStr, null, null);
        }
    }

    public boolean checkPerm(String perms) {
        int check = ContextCompat.checkSelfPermission(this, perms);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
}