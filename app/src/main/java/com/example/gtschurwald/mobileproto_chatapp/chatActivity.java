package com.example.gtschurwald.mobileproto_chatapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.firebase.client.Firebase;
import java.util.ArrayList;
import android:s


/**
 * Created by gtschurwald on 9/25/2014.
 */
public class chatActivity extends FragmentActivity {

    //Setting up the Firebase here
    Firebase myFirebaseRef = new Firebase("https://mobileproto2014.firebaseio.com/chatroom/%5b%5bCHATROOM_ID");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            chatRoomList firstFragment = new chatRoomList();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

        /* This stuff should be in the chatRoomList fragment, not here
        // Access the ListView
        mainListView = (ListView) findViewById(R.id.usersListView);

        // Create an ArrayAdapter for the ListView
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);

        mArrayAdapter.add("Chatroom 1");
        mArrayAdapter.notifyDataSetChanged();

        // Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mArrayAdapter);
        */
    }



    //This just makes the menu buttons appear
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
                Toast.makeText(this, "Wanna add a user?", Toast.LENGTH_SHORT)
                        .show();

                //------------------------------------------------------------
                //This stuff creates an AlertDialog to enter a username
                AlertDialog.Builder alert = new AlertDialog.Builder(this);

                alert.setTitle("Add new user");
                alert.setMessage("Type in your name here ");

                // Set an EditText view to get user input
                final EditText input = new EditText(this);
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // This creates a new user to add to firebase
                        String value = input.getText().toString();

                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                        return;
                    }
                });

                alert.show();

                //------------------------------------------------------------------
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

