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

public class usereventshowadapter_activity  extends ArrayAdapter {


    Activity mContext;//binding class
    List<eventCreationhelperclass> eventList;



    public usereventshowadapter_activity(Activity mContext , List<eventCreationhelperclass> eventList) {
        super(mContext, R.layout.activity_all_events_created,eventList);
        this.mContext = mContext;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();

        View eventListItem = inflater.inflate(R.layout.usereventview_activity,null,true);

        TextView Eventname = eventListItem.findViewById(R.id.userEventTitle);
        TextView Organizer = eventListItem.findViewById(R.id.userOrganized);
        TextView Location = eventListItem.findViewById(R.id.userLocation);
        TextView Day = eventListItem.findViewById(R.id.UserDay);
        TextView Date = eventListItem.findViewById(R.id.userDate);


        eventCreationhelperclass eventCreationhelperclass = eventList.get(position);

        Eventname.setText(eventCreationhelperclass.getEventname());
        Organizer.setText(eventCreationhelperclass.getOrganizername());
        Location.setText(eventCreationhelperclass.getLocation());
        Day.setText(eventCreationhelperclass.getDay());
        Date.setText(eventCreationhelperclass.getDate());



        return eventListItem;
    }
}