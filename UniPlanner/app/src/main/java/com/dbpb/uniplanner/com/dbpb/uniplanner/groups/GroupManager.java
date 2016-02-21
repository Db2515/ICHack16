package com.dbpb.uniplanner.com.dbpb.uniplanner.groups;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.dbpb.uniplanner.MainActivity;
import com.dbpb.uniplanner.R;

import java.util.LinkedList;

public class GroupManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String groupname = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView header = (TextView) findViewById(R.id.group_manager_header);
        header.setText(groupname);
        LinkedList<Group> groups = MainActivity.getGroups();
        Group group = new Group("");
        for(Group g: groups){
            if(g.getGroupName().equals(groupname)){
                group = g;
                break;
            }
        }
        for (User user : group.getGroup()) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.group_manager_list);
            TextView username = new TextView(getApplicationContext());
            username.setText(user.getUsername());
            layout.addView(username);
        }
    }

}
