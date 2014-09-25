package com.example.gtschurwald.mobileproto_chatapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by gtschurwald on 9/22/2014.
 */

/**
 * This is the first fragment that appears by default
 * it will have a button to navigate to the chat fragment
 * Good practice in switching fragments!!
 */
public class WelcomeFragment extends Fragment {
    //class is called PlaceholderFragment, although layout is a different name
    public WelcomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the fragment view so it fills screen
        View rootView = inflater.inflate(R.layout.fragment_home_screen, container, false);


        Button button = (Button) rootView.findViewById(R.id.chatButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //do stuffs
               // buttonClicked(v);
            }
        });

        return rootView;
    }

}
