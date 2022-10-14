package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class splash_activity extends AppCompatActivity {


    ImageView imageView;
    AnimationDrawable animationDrawable;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        getSupportActionBar().hide();
        imageView = findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.startupimage);
        animationDrawable = (AnimationDrawable) imageView.getBackground();

        // now start animation as well as activity started....

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),login_activity.class);
                startActivity(intent);
                finish();
            }
        },4000);



    }

    @Override
    protected void onStart() {
        super.onStart();
        animationDrawable.start();
    }
}