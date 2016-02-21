package com.dbpb.uniplanner;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.Group;
import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.User;
import com.dbpb.uniplanner.com.dbpb.uniplanner.groups.userInGroupException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Group> groups = new LinkedList<>();

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
        for(Group group: groups){
            Button button = new Button(getApplicationContext());
            button.setText(group.getGroupName());
            groupList.addView(button);
        }
    }


    /*
    private Bitmap getBitmapFromURL(String src){
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap pp = BitmapFactory.decodeStream(input);
            return pp;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
*/

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
}
