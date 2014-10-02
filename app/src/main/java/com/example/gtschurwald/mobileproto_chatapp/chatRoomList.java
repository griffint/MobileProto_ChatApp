package com.example.gtschurwald.mobileproto_chatapp;

/**
 * Created by gtschurwald on 10/2/2014.
 */

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class chatRoomList extends Fragment {

    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.chat_activity);
        // Access the ListView
        mainListView = (ListView) findViewById(R.id.usersListView);

        // Create an ArrayAdapter for the ListView
        StableArrayAdapter adapter = new StableArrayAdapter(this.getActivity(), R.layout.row , list);

        mArrayAdapter.add("Chatroom 1");
        mAr
    }rayAdapter.notifyDataSetChanged();

        // Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mArrayAdapter);

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.chat_home_fragment, container, false);

    }

}
