package com.dbpb.uniplanner.com.dbpb.uniplanner.groups;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.dbpb.uniplanner.R;

public class RemoveGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_group);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void submitRemoveGroup(View view) {
        EditText editText = (EditText) findViewById(R.id.remove_group_submit);
        String message = editText.getText().toString();
        GroupManager.removeGroup(message);
        finish();
    }

}
