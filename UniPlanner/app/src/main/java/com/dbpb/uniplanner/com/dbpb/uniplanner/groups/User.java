package com.dbpb.uniplanner.com.dbpb.uniplanner.groups;

public class User {

    private String username;
    private String profilePictureAddress = "https://encrypted-tbn1.gstatic.com/images?" +
                            "q=tbn:ANd9GcRDNKAqL4vgRa0ttLUlkvwv7Rf4E0MTMaahdqqBATT50i6pprIrtg";

    public User(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setProfilePicture(String address){
       profilePictureAddress = address;
    }

    public String getProfilePictureAddress(){
        return profilePictureAddress;
    }
}
