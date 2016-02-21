package com.dbpb.uniplanner.com.dbpb.uniplanner.groups;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.dbpb.uniplanner.MainActivity;
import com.dbpb.uniplanner.R;

import java.util.LinkedList;

public class RemoveUserActivity extends AppCompatActivity {

    Group group = new Group("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String groupname = intent.getStringExtra(GroupManager.EXTRA_MESSAGE);
        LinkedList<Group> groups = MainActivity.getGroups();
        for(Group g: groups){
            if(g.getGroupName().equals(groupname)){
                group = g;
                break;
            }
        }
    }

    public void submitRemoveUser(View view) {
        EditText editText = (EditText) findViewById(R.id.add_user_submit);
        String message = editText.getText().toString();
        User user = new User(message);
        group.removeUser(user);
        finish();
    }

}
