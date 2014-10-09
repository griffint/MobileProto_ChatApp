package com.example.gtschurwald.mobileproto_chatapp.activities;

/**
 * Created by gtschurwald on 10/6/2014.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.gtschurwald.mobileproto_chatapp.R;
import com.example.gtschurwald.mobileproto_chatapp.content.contentManager;
import com.example.gtschurwald.mobileproto_chatapp.fragments.chatFragment;
import com.example.gtschurwald.mobileproto_chatapp.fragments.homePageFragment;
import com.example.gtschurwald.mobileproto_chatapp.theListeners.onClickListeners;
import com.firebase.client.Firebase;

import java.util.HashMap;


public class mainActivity extends Activity{

    //hashmap for saving the chatfragments in
    HashMap<String, chatFragment> channelFragments = new HashMap<String, chatFragment>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //stuff to set up firebase
        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://<your-firebase>.firebaseio.com/");

        setContentView(R.layout.main_activity); //Set view to main_activity, which has a frame layout
        //Initialize content - channels/users/etc
        contentManager.init();

        if (savedInstanceState == null) {
            //Setup colors
            contentManager.addNewUser(contentManager.username);
            if (contentManager.username.equals("default")) {
                Toast.makeText(this, "You are signed in as default! Click the user icon to change your name!", Toast.LENGTH_SHORT).show();
            }
            //Setup Home Page
            initialUISetup();
        }
    }

    public void initialUISetup(){
        //Load and show the homepageFragment
        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new homePageFragment()).commit();
    }
    public void goToChannelFragment()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.menu_change_username:
                onClickListeners.changeUsernameListener(this);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
//end of the activity class
}
