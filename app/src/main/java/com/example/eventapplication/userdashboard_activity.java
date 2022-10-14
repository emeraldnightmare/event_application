package com.example.eventapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class userdashboard_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //drawer icon
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuicon;

//    //event details
//    Button eventDetails;
//
    //listview
    ListView myList;
    List<eventCreationhelperclass> eventList;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdashboard);
        //drawer icon values to call
        menuicon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_layout);
//        eventDetails = findViewById(R.id.Details);
        navigationDrawer();
        //listview
        myList = findViewById(R.id.eventcreatedlist);
        eventList = new ArrayList<>();


        reference = FirebaseDatabase.getInstance().getReference("EventsCreated");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eventList.clear();
                for(DataSnapshot eventDatasnap : snapshot.getChildren()){
                    eventCreationhelperclass events = eventDatasnap.getValue(eventCreationhelperclass.class);
                    eventList.add(events);
                }
               usereventshowadapter_activity adminalleventadapterclass = new usereventshowadapter_activity(userdashboard_activity.this,eventList);
                myList.setAdapter(adminalleventadapterclass);
                myList.setClickable(true);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

























        //event details form
//        eventDetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(getApplicationContext(),oneventClick_activity.class);
//                startActivity(intent);
//            }
//        });




    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();



        if(id == R.id.nav_profile)
        {
            startActivity(new Intent(getApplicationContext(), userProfile_activity.class));

        }
        else if(id == R.id.nav_logout){
            startActivity(new Intent(getApplicationContext(),login_activity.class));
            FirebaseAuth.getInstance().signOut();
            finish();


        }


        return true;
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        menuicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }
}