package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class createEvent_activity extends AppCompatActivity {

    EditText Eventname , Description, Organizername, Location, Timimg, Day ,Date;
    Boolean valid = true;
    Button btnRegister;
    DatabaseReference df;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        Eventname = findViewById(R.id.FullName);
        Description = findViewById(R.id.Description);
        Location = findViewById(R.id.location);
        Day = findViewById(R.id.day);
//        Imageurl = findViewById(R.id.imageurl);
        Organizername = findViewById(R.id.organizername);
        Timimg = findViewById(R.id.timimg);
//        uploadimage = findViewById(R.id.btnuploadimage);
        Date = findViewById(R.id.date);
        btnRegister = findViewById(R.id.btnRegister);
        df = FirebaseDatabase.getInstance().getReference().child("EventsCreated");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkField(Eventname);
                checkField(Description);
                checkField(Location);
                checkField(Day);
                checkField(Organizername);
                checkField(Timimg);
                checkField(Date);

                if(valid){
                    insertEventdata();
                    startActivity(new Intent(getApplicationContext(),admindashboard_activity.class));
                    finish();
                }
                else{
                    Toast.makeText(createEvent_activity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void insertEventdata() {

        String eventname = Eventname.getText().toString();
        String description = Description.getText().toString();
        String location = Location.getText().toString();

        String organizername = Organizername.getText().toString();
        String timimg = Timimg.getText().toString();
        String date = Date.getText().toString();
        String day = Day.getText().toString();

        eventCreationhelperclass help = new eventCreationhelperclass(eventname,description,location,organizername,timimg,date,day);
        df.child(organizername).setValue(help);
        Toast.makeText(this, "event created ", Toast.LENGTH_SHORT).show();


    }

    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }
}