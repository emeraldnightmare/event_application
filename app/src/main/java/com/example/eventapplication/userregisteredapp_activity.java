package com.example.eventapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class userregisteredapp_activity extends AppCompatActivity {
    ImageView backbtn;
    ListView myList;
    List<registerhelperclass> eventList;
    DatabaseReference reference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregisteredapp);

        myList = findViewById(R.id.userAvailable);
        eventList = new ArrayList<>();

        backbtn = findViewById(R.id.back_pressed_user);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userregisteredapp_activity.super.onBackPressed();
            }
        });

        reference = FirebaseDatabase.getInstance().getReference("UsersCreated");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eventList.clear();
                for(DataSnapshot eventDatasnap : snapshot.getChildren()){
                    registerhelperclass events = eventDatasnap.getValue(registerhelperclass.class);
                    eventList.add(events);
                }
                userDataShowAdapter_activity userDataShowAdapter_activity = new userDataShowAdapter_activity(userregisteredapp_activity.this,eventList);

                myList.setAdapter(userDataShowAdapter_activity);
                myList.setClickable(true);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}