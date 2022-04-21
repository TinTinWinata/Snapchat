package com.example.snapchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snapchat.database.Message;
import com.example.snapchat.models.Friend;

public class ChatDetailActivity extends AppCompatActivity {

    Message message;
    TextView txtName;
    Friend currFriend;
    Button btnSend;
    EditText inpMsg;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        getFriend();
        setToolbar();
        init();
        setRecycleView();


        btnSend.setOnClickListener(x -> {
            String msg = inpMsg.getText().toString();

            sendSMS(msg);
            saveToChatList(msg);
        });

    }

    public void setRecycleView()
    {
//        rv = findViewById(R.id.rvChat);
//        rv.setLayoutManager(new LinearLayoutManager(getContext(),
//                LinearLayoutManager.VERTICAL, false));


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void init()
    {
        txtName = findViewById(R.id.txtToolBarName);
        btnSend = findViewById(R.id.btnSend);
        inpMsg  = findViewById(R.id.inpMsg);
        txtName.setText(currFriend.getName());
        message = new Message();
    }

    public void saveToChatList(String msg)
    {
        currFriend.addChatList(msg);
    }


    public void sendSMS(String msg)
    {
        boolean succeedSend = message.sendMessage(this, currFriend.getPhoneNumber(), msg);

        if(succeedSend)
            Toast.makeText(this, "Message Sended", Toast.LENGTH_SHORT).show();
        else
        {
            requestSMSPermission();
            Toast.makeText(this, "Failed to send Message", Toast.LENGTH_SHORT).show();
        }

        inpMsg.setText("");
    }

    public void requestSMSPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
    }

    public void setToolbar()
    {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }



    public void getFriend(){
        currFriend = (Friend)getIntent().getSerializableExtra("friend");
    }



    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}
