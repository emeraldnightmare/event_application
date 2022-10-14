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

public class regEvent_activity extends AppCompatActivity {

    EditText regName , regEmail, regDepartment, regphone;

    Button btnRegister;
    DatabaseReference df;
    Boolean valid = true;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_event);

        regName = findViewById(R.id.regUser);
        regEmail = findViewById(R.id.regemail);
        regDepartment = findViewById(R.id.regDepartment);
        regphone = findViewById(R.id.regphone);

        df = FirebaseDatabase.getInstance().getReference().child("EventUserRegistered");
        btnRegister = findViewById(R.id.eventreg);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(regName);
                checkField(regEmail);
                checkField(regDepartment);
                checkField(regphone);

                if(valid){
                    eventregister();
                }

            }
        });




    }

    private void eventregister() {

        String User = regName.getText().toString();
        String email = regEmail.getText().toString();
        String department = regDepartment.getText().toString();
        String phone = regphone.getText().toString();

        regeventhelperclass user = new regeventhelperclass(User,email,department,phone);

        df.child(User).setValue(user);
        Toast.makeText(this, "Event registered", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),userdashboard_activity.class));
        finish();
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