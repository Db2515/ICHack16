package com.dbpb.uniplanner.com.dbpb.uniplanner.events;

import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.User;

import java.util.Date;
import java.util.LinkedList;

public class Event {

    private String name;
    private Date date;
    private String description;
    private LinkedList<User> atendees;

    public Event(String name, Date date, String description, LinkedList<User> atendees){
        this.name = name;
        this.date = date;
        this.description = description;
        this.atendees = atendees;
    }

    public void addAtendee(User user){
        if(!atendees.contains(user)){
            atendees.add(user);
        }
    }

    public void removeAtendee(User user){
        atendees.remove(user);
    }
}
