package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class oneventClick_activity extends AppCompatActivity {

    Button registerforevent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onevent_click);
    registerforevent  = findViewById(R.id.regButton);
    registerforevent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),regEvent_activity.class));
        }
    });
    }
}