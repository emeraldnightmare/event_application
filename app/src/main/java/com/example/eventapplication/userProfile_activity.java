package com.example.eventapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userProfile_activity extends AppCompatActivity {

    ImageView backbtn;
    TextView Phonenumber , Email;
    Button logoutbtn;
    DatabaseReference df;
    String email = "";
    String phone = "";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        Phonenumber = findViewById(R.id.phone);
        Email = findViewById(R.id.email);


//        df = FirebaseDatabase.getInstance().getReference().child("username");
//        getprofiledata();

        backbtn = findViewById(R.id.back_pressed);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userProfile_activity.super.onBackPressed();
            }
        });


        logoutbtn = findViewById(R.id.btnlogout);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),login_activity.class));
                finish();
            }
        });
    }

//    private void getprofiledata() {
//
//        df.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for(DataSnapshot data:snapshot.getChildren()){
//                    String key = data.getKey();
//                    if(key.equals("email")){
//                        email = data.getValue().toString();
//                    }else if(key.equals("phone")){
//                        phone = data.getValue().toString();
//                    }else{
//
//                    }
//                    Phonenumber.setText(phone);
//                    Email.setText(email);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}