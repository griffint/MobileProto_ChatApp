package com.example.gtschurwald.mobileproto_chatapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.ArrayList;


/**
 * Created by gtschurwald on 9/25/2014.
 */
public class chatActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        // Below sets up my ArrayAdapter to populate the list of chats going on
        ListView mainListView;
        ArrayAdapter mArrayAdapter;
        ArrayList mNameList = new ArrayList();

        // Access the ListView
        mainListView = (ListView) findViewById(R.id.usersListView);

        // Create an ArrayAdapter for the ListView
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);

        // Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mArrayAdapter);

        //Setting up the Firebase here
        Firebase myFirebaseRef = new Firebase("https://mobileproto2014.firebaseio.com/chatroom/%5b%5bCHATROOM_ID");

    }

    //Now I need code to populate the users from firebase

    //This
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chat_activity_menu, menu);
        return true;
    }

    //this bit does stuff when action bar items are selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.add_user:
                Toast.makeText(this, "Wanna add a user dawg?", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.action_settings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }

        return true;
    }


}

