package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class admindashboard_activity extends AppCompatActivity {

    GridLayout mainGrid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);
        mainGrid1 = findViewById(R.id.mainGrid1);
        setSingleEvent(mainGrid1);
    }

    private void setSingleEvent(GridLayout mainGrid1) {
        for(int i=0;i<mainGrid1.getChildCount();i++) {
            CardView cardView = (CardView) mainGrid1.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalI == 0) {
                        Intent intent = new Intent(getApplicationContext(), createEvent_activity.class);
                        startActivity(intent);

                    } else if (finalI == 1) {
//                        Intent intent = new Intent(getApplicationContext(), allEvents_created_activity.class);
//                        startActivity(intent);
                    } else if (finalI == 2) {
                        Intent intent = new Intent(getApplicationContext(), allEvents_created_activity.class);
                        startActivity(intent);
                    } else if (finalI == 3) {
//                        Intent intent = new Intent(getApplicationContext(), allEvents_created_activity.class);
//                        startActivity(intent);
                    } else if (finalI == 4) {
                        Intent intent = new Intent(getApplicationContext(), userregisteredapp_activity.class);
                        startActivity(intent);
                    }else if (finalI == 5) {
                        Intent intent = new Intent(getApplicationContext(), adminprofile_activity.class);
                        startActivity(intent);
                    } else {
//                        Toast.makeText(Admin.this, "Sorry", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}