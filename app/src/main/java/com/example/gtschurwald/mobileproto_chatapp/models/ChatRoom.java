package com.example.gtschurwald.mobileproto_chatapp.models;

import java.io.Serializable;

/**
 * Created by gtschurwald on 10/8/2014.
 */
public class ChatRoom implements Comparable, Serializable {
    private String id, name;
    private ChatMessage lastChat;
    private long lastUpdated, timeCreated;

    public ChatRoom(String id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Getters
     */
    public ChatMessage getLastChat() {
        return lastChat;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Setters
     */
    public void setId(String id) {
        this.id = id;
    }

    public void setLastChat(ChatMessage lastChat) {
        this.lastChat = lastChat;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }



    @Override
    public int compareTo(Object o) {
        return ((ChatRoom)o).getLastUpdated() < getLastUpdated()?1:0;
    }
}
