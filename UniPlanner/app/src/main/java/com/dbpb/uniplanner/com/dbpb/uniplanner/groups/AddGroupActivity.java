package com.dbpb.uniplanner.com.dbpb.uniplanner.groups;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.dbpb.uniplanner.R;

public class AddGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //Main only updates when the groupManager has been visited
    public void submitAddGroup(View view) {
        EditText editText = (EditText) findViewById(R.id.add_group_submit);
        String message = editText.getText().toString();
        GroupManager.addGroup(message);
        finish();
    }

}
