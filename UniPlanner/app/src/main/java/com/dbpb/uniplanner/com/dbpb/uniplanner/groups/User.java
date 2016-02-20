package com.dbpb.uniplanner.com.dbpb.uniplanner.groups;

public class User {

    private String username;
    private String profilePictureAddress = "https://lh6.ggpht.com/3GquZbIDgiQc-wQlb9ui3Nt" +
                                           "j3CxuRLKwMUop6miqlv91Pod6AuPjSigl_jBT7d99ig=w300";

    public User(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setProfilePicture(String address){
       profilePictureAddress = address;
    }
}
