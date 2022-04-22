package com.example.snapchat.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Friend implements Serializable {
    private int id;
    private String name;
    private int time;
    private String phoneNumber;
    private ArrayList<String> chatList;

    public Friend(int id, String name, int time, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.phoneNumber = phoneNumber;
        chatList = new ArrayList<String>();
    }

    public void addChatList(String str)
    {
        chatList.add(str);
    }

    public ArrayList<String> getChatList()
    {
        return chatList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
