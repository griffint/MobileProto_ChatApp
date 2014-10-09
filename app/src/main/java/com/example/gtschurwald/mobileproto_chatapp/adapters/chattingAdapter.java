package com.example.gtschurwald.mobileproto_chatapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gtschurwald.mobileproto_chatapp.R;
import com.example.gtschurwald.mobileproto_chatapp.models.ChatMessage;
import com.example.gtschurwald.mobileproto_chatapp.content.ContentManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gtschurwald on 10/8/2014.
 * purpose of this is to populate the chats into a given chatroom
 */
public class ChattingAdapter extends ArrayAdapter {
    private List<ChatMessage> chats = new ArrayList<ChatMessage>();
    private int resource;
    //context is an interface to lots of information about the app as a whole
    //still tyring to figure out exactly how it works
    private Context context;

    public ChattingAdapter(Context context, List<ChatMessage> chats, int resource) {
        super(context, R.layout.chatroom_item);
        this.context = context;
        this.resource = resource;

        //addChats is defined below
        addChats(chats);
    }

    //this class sets the data variables for a given chat item up
    private class ChatHolder {
        TextView name, body, time;
        ImageView picture;
        View background;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        ChatHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(resource, parent, false);
        holder = new ChatHolder();

        //TextViews
        holder.name = (TextView) view.findViewById(R.id.item_profile_name);
        holder.body = (TextView) view.findViewById(R.id.item_chat_body);
        holder.time = (TextView) view.findViewById(R.id.item_chat_time);

        //ImageViews
        holder.background = view.findViewById(R.id.item_profile_background);
        holder.picture = (ImageView) view.findViewById(R.id.item_profile_picture);
        fillViews(holder, chats.get(position));
        return view;
    }

    @Override
    public int getCount(){
        return this.chats.size();
    }

    private void fillViews(ChatHolder holder, ChatMessage chat){
        holder.name.setText(chat.sender);
        holder.body.setText(chat.body);
        holder.time.setText(formatTime(chat.time));

        holder.background.setBackgroundResource(ContentManager.userColors.get(chat.sender));
        //holder.picture.setImageDrawable(getProfileDrawable(chat.userId));
    }

    private String formatTime(long time){
        if (DateUtils.isToday(time)){
            return new SimpleDateFormat("hh:mm:ss a").format(new Date(time));
        }
        return new SimpleDateFormat("MM/DD, hh:mm:ss a").format(new Date(time));
    }

    private Drawable getProfileDrawable(String id){
        return null;
    }

    public void addChats(List<ChatMessage> newChats){
        this.chats.addAll(newChats);
        notifyDataSetChanged();
    }

    public void addChat(ChatMessage chat){
        this.chats.add(chat);
        notifyDataSetChanged();
    }
}
