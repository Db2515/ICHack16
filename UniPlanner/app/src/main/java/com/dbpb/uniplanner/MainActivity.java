package com.dbpb.uniplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.AddGroupActivity;
import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.Group;
import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.GroupManager;
import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.RemoveGroupActivity;
import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.User;
import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.userInGroupException;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.dbpb.uniplanner.MESSAGE";
    private static LinkedList<Group> groups = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Group group = new Group("The Boulby Bucket");
        try{
            group.addUser(new User("Daniel"));
            group.addUser(new User("Philip"));
        } catch (userInGroupException e){
            e.printStackTrace();
        }
        groups.add(group);
        groups.add(new Group("Group 2"));
    }

    @Override
    protected void onResume(){
        super.onResume();
        LinearLayout groupList = (LinearLayout) findViewById(R.id.group_list);
        groupList.removeAllViews();
        for(Group group: groups){
            Button button = new Button(getApplicationContext());
            button.setText(group.getGroupName());
            button.setOnClickListener(clickListener);
            groupList.addView(button);
        }

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), GroupManager.class);
            Button b = (Button) v;
            String groupname = b.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, groupname);
            startActivity(intent);
        }
    };

    public static LinkedList<Group> getGroups(){
        return groups;
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addGroup(View view){
        Intent intent = new Intent(this, AddGroupActivity.class);
        startActivity(intent);
    }

    public void removeGroup(View view){
        Intent intent = new Intent(this, RemoveGroupActivity.class);
        startActivity(intent);
    }
}
