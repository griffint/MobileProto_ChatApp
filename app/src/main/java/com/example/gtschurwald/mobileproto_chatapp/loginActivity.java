package com.example.gtschurwald.mobileproto_chatapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class loginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //this is the start chat button on the home activity
        Button chatStartButton = (Button) findViewById(R.id.chatStartButton);
        chatStartButton.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view)
            {
                //start new activity
                //this is code to start new activities
                Intent intent = new Intent(getApplicationContext(), chatRoomsActivity.class);
                startActivity(intent);      //this intent starts the list activity when the button is pressed
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
