package com.example.gtschurwald.mobileproto_chatapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by gtschurwald on 9/25/2014.
 */
public class ListUsersActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
       // setConversationsList();
    }
}
/*
    private void setConversationsList() {
        currentUserId = //need sqllite or firebase code here
        names = new ArrayList<String>();

        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereNotEqualTo("objectId", currentUserId);

        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int i, long l) {
                Toast.makeText(getApplicationContext(),
                        "You clicked on user: " + i,
                        Toast.LENGTH_SHORT).show();
                //Look up user id and open conversation
                openConversation(names, i)      //function to activate MessagingActivity
            }
        });
    }
    public void openConversation(ArrayList
} */

