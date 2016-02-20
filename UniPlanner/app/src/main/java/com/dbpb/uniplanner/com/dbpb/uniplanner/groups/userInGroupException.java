package com.dbpb.uniplanner.com.dbpb.uniplanner.groups;

public class userInGroupException extends Exception {

    @Override
    public String getMessage(){
        return "userInGroupException message (" + super.getMessage() + ")";
    }

}
