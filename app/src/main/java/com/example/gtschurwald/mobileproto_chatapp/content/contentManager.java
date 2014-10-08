package com.example.gtschurwald.mobileproto_chatapp.content;

import com.example.gtschurwald.mobileproto_chatapp.models.chatrooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gtschurwald on 10/8/2014.
 */
public class contentManager {
    //User Logistics
    public static String username = "default";
    public static String userId = "0001";

    //While Profile Pictures are not implemented
    public static HashMap<String, Integer> userColors = new HashMap<String, Integer>();
    public static List<Integer> colors = Arrays.asList(android.R.color.darker_gray,
            android.R.color.holo_blue_light,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_purple,
            android.R.color.holo_red_light,
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_dark,
            android.R.color.holo_red_dark,
            android.R.color.holo_blue_dark);

    public static void init(){
        //Initialize Content Manager
    }

    //Get Channels for specific user
    public static List<Channel> getChannelsForUser(String userID){
        List<Channel> hardcoded = new ArrayList<Channel>();
        hardcoded.add(new Channel("0001000", "Hardcoded Channel"));
        return hardcoded;
    }

    //Add a new user
    public static int addNewUser(String username){
        userColors.put(username, colors.get(userColors.size() % colors.size()));
        return userColors.get(username);
    }

    //Get own color
    public static int getSelfUserColor(){
        return getUserColor(userId);
    }
    //Get user's color
    public static int getUserColor(String id){
        return userColors.containsKey(id)?userColors.get(id):addNewUser(id);
    }
}
