package com.example.eventapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class adminalleventadapterclass extends ArrayAdapter {

    Activity mContext;//binding class
    List<eventCreationhelperclass> eventList;



    public adminalleventadapterclass(Activity mContext , List<eventCreationhelperclass> eventList) {
        super(mContext, R.layout.activity_all_events_created,eventList);
        this.mContext = mContext;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();

        View eventListItem = inflater.inflate(R.layout.admineventlist_view,null,true);

        TextView Eventname = eventListItem.findViewById(R.id.eventName);
        TextView Organizer = eventListItem.findViewById(R.id.eventOrganizer);
        TextView Location = eventListItem.findViewById(R.id.eventlocation);
        TextView Day = eventListItem.findViewById(R.id.eventDay);
        TextView Date = eventListItem.findViewById(R.id.eventDate);
        TextView Time = eventListItem.findViewById(R.id.eventTime);

        eventCreationhelperclass eventCreationhelperclass = eventList.get(position);

        Eventname.setText(eventCreationhelperclass.getEventname());
        Organizer.setText(eventCreationhelperclass.getOrganizername());
        Location.setText(eventCreationhelperclass.getLocation());
        Day.setText(eventCreationhelperclass.getDay());
        Date.setText(eventCreationhelperclass.getDate());
        Time.setText(eventCreationhelperclass.getTimimg());


        return eventListItem;
    }
}
