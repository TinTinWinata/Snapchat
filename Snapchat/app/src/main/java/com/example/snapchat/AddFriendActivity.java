package com.example.snapchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.snapchat.database.DBOpenHelper;

public class AddFriendActivity extends AppCompatActivity {

    Button btnAddFriend;
    EditText inpSearchFriend;
    EditText inpPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        btnAddFriend = findViewById(R.id.btnAddFriend);
        inpSearchFriend = findViewById(R.id.inpSearchFriend);
        inpPhoneNumber = findViewById(R.id.inpPhoneNumber);

        btnAddFriend.setOnClickListener(x -> {
            String friendName = inpSearchFriend.getText().toString();
            Integer friendTime = randomTime();
            String friendNumber = inpPhoneNumber.getText().toString();

            SQLiteDatabase db = DBOpenHelper.getInstance(this).getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(DBOpenHelper.NAME, friendName);
            cv.put(DBOpenHelper.TIME, friendTime + "");
            cv.put(DBOpenHelper.NUMBER, friendNumber);
            db.insert(DBOpenHelper.FRIENDS, null, cv);

            Intent newIntent = new Intent(this, MainActivity.class);
            startActivity(newIntent);
            finish();
        });

    }

    private int randomTime()
    {
        int max = 90;
        int min = 10;
        int number = -1;
        number = (int) Math.round(Math.random() * (max - min) + min) ;
        return number;
    }
}