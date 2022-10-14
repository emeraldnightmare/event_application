package com.example.eventapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class userDataShowAdapter_activity extends ArrayAdapter {


    Activity mContext;//binding class
    List<registerhelperclass> eventList;



    public userDataShowAdapter_activity(Activity mContext , List<registerhelperclass> eventList) {
        super(mContext, R.layout.activity_all_events_created,eventList);
        this.mContext = mContext;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();

        View eventListItem = inflater.inflate(R.layout.userdatashow,null,true);

        TextView userName = eventListItem.findViewById(R.id.userName);
        TextView userEmail = eventListItem.findViewById(R.id.userEmail);
        TextView userPhoneno = eventListItem.findViewById(R.id.userPhone);

        registerhelperclass registerhelperclass = eventList.get(position);

        userName.setText(registerhelperclass.getUsername());
        userEmail.setText(registerhelperclass.getEmail());
        userPhoneno.setText(registerhelperclass.getPhone());





//        Eventname.setText(eventCreationhelperclass.getEventname());
//        Organizer.setText(eventCreationhelperclass.getOrganizername());
//        Location.setText(eventCreationhelperclass.getLocation());




        return eventListItem;
    }


}
