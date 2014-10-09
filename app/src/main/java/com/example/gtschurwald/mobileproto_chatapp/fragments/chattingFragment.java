package com.example.gtschurwald.mobileproto_chatapp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.gtschurwald.mobileproto_chatapp.adapters.ChattingAdapter;
import com.example.gtschurwald.mobileproto_chatapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gtschurwald on 10/6/2014.
 * this fragment controls the ChatRoom in a chatroom
 */
public class chattingFragment extends Fragment {
    //List of chats
    ChattingAdapter chatAdapter;

    //Context from activity
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chatting_fragment, container);
        getChats();
        view = setupViews(view); //Sets up views in this content view.
        return view;
    }

    private View setupViews(View v){
        ListView chatList = (ListView) v.findViewById(R.id.main_chat_list);
        chatList.setAdapter(chatAdapter);

        final EditText input = (EditText) v.findViewById(R.id.main_chat_input);
        input.clearFocus();

        Button sendButton = (Button) v.findViewById(R.id.main_chat_button);
        sendButton.setBackgroundResource(ContentManager.userColors.get(ContentManager.username));
        sendButton.setOnClickListener(OnClickListeners.sendButtonListener(getActivity(), chatAdapter));
        return v;
    }

    private void getChats(){
        //Use content provider in the future
        List<Chat> newChats = new ArrayList<Chat>();
        if (chatAdapter == null)
            chatAdapter = new ChatAdapter(context, new ArrayList<Chat>(), R.layout.chatitem_main);
        chatAdapter.addChats(newChats);
    }
}

