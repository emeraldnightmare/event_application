package com.example.eventapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class allEvents_created_activity extends AppCompatActivity {


    ImageView backbtn;
    ListView myList;
    List<eventCreationhelperclass> eventList;
    DatabaseReference reference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_events_created);

        myList = findViewById(R.id.myListView);
        eventList = new ArrayList<>();

        backbtn = findViewById(R.id.back_pressed);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allEvents_created_activity.super.onBackPressed();
            }
        });

        reference = FirebaseDatabase.getInstance().getReference("EventsCreated");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eventList.clear();
                for(DataSnapshot eventDatasnap : snapshot.getChildren()){
                    eventCreationhelperclass events = eventDatasnap.getValue(eventCreationhelperclass.class);
                    eventList.add(events);
                }
                adminalleventadapterclass adminalleventadapterclass = new adminalleventadapterclass(allEvents_created_activity.this,eventList);
                myList.setAdapter(adminalleventadapterclass);
                myList.setClickable(true);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}