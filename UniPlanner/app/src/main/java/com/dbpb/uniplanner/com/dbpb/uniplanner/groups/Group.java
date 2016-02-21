package com.dbpb.uniplanner.com.dbpb.uniplanner.groups;

import java.util.HashMap;
import java.util.LinkedList;

public class Group{

    private LinkedList<User> group = new LinkedList<>();
    private String groupName;

    public Group(String groupName){
        this.groupName = groupName;
    }

    public LinkedList<User> getGroup(){
        return group;
    }

    public void addUser(User user) throws userInGroupException {
        if(!group.contains(user)) {
            group.add(user);
        } else {
            throw new userInGroupException();
        }
    }

    public void removeUser(User user){
        group.remove(user);
    }

    public String getGroupName(){

        return groupName;
    }

    public void changeGroupName(String groupName){
        this.groupName = groupName;
    }

}
