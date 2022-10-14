package com.example.eventapplication;

public class eventCreationhelperclass {
    String Eventname , Description, location, Organizername, Timimg, Date,day;

    public eventCreationhelperclass() {
    }

    public eventCreationhelperclass(String eventname, String description, String location, String organizername, String timimg, String date, String day) {
        Eventname = eventname;
        Description = description;
        this.location = location;
        Organizername = organizername;
        Timimg = timimg;
        Date = date;
        this.day = day;
    }

    public String getEventname() {
        return Eventname;
    }

    public void setEventname(String eventname) {
        Eventname = eventname;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizername() {
        return Organizername;
    }

    public void setOrganizername(String organizername) {
        Organizername = organizername;
    }

    public String getTimimg() {
        return Timimg;
    }

    public void setTimimg(String timimg) {
        Timimg = timimg;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
