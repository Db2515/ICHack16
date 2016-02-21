package com.dbpb.uniplanner.com.dbpb.uniplanner.groups;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dbpb.uniplanner.MainActivity;
import com.dbpb.uniplanner.R;

import java.util.LinkedList;

public class GroupManager extends AppCompatActivity {

    private Group group = new Group("");
    private static String groupName;
    private LinkedList<Group> groups;
    public static final String EXTRA_MESSAGE = "com.dbpb.uniplanner.groups.GroupManager.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        groupName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        groups = MainActivity.getGroups();
        for(Group g: groups){
            if(g.getGroupName().equals(groupName)){
                group = g;
                break;
            }
        }


    }

    @Override
    protected void onResume(){
        super.onResume();
        groupName = group.getGroupName();
        TextView header = (TextView) findViewById(R.id.group_manager_header);
        header.setText(groupName);
        header.setTextSize(16);
        LinearLayout layout = (LinearLayout) findViewById(R.id.group_manager_list);
        layout.removeAllViews();
        for (User user : group.getGroup()){
            TextView username = new TextView(getApplicationContext());
            username.setText(user.getUsername());
            username.setTextColor(Color.BLACK);
            layout.addView(username);
        }
    }

    public void addUser(View view){
        Intent intent = new Intent(this, AddUserActivity.class);
        intent.putExtra(EXTRA_MESSAGE, groupName);
        startActivity(intent);
    }

    public void removeUser(View view){
        Intent intent = new Intent(this, RemoveUserActivity.class);
        intent.putExtra(EXTRA_MESSAGE, groupName);
        startActivity(intent);
    }

    /*
    public void changeGroupName(View view){
        Intent intent = new Intent(this, ChangeGroupNameActivity.class);
        intent.putExtra(EXTRA_MESSAGE, groupName);
        startActivity(intent);
    }
*/
}
