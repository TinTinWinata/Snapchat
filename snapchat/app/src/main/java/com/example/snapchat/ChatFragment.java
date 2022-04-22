package com.example.snapchat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snapchat.adapter.FriendAdapter;
import com.example.snapchat.utility.DBOpenHelper;
import com.example.snapchat.models.Friend;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ChatFragment extends Fragment implements FriendAdapter.FriendClickListener{

    public static ArrayList<Friend> friendList = new ArrayList<>();
    RecyclerView recycleView;
    FriendAdapter friendAdapter;
    FloatingActionButton fabBtn;


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_chat, container,  false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getProductDataFromDB();
        recycleView = view.findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        friendAdapter = new FriendAdapter(friendList, this);
        recycleView.setAdapter(friendAdapter);

        fabBtn = (FloatingActionButton) getView().findViewById(R.id.fabBtnAdd);
        fabBtn.setOnClickListener(x -> {
            Intent newIntent = new Intent(this.getContext() , AddFriendActivity.class);
            startActivity(newIntent);
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        getProductDataFromDB();
        friendAdapter.notifyDataSetChanged();
        recycleView.setAdapter(friendAdapter);
    }

    @Override
    public void onFriendClicked(int position) {
        Intent intent  = new Intent(this.getContext(), ChatDetailActivity.class);
        intent.putExtra("friend", friendList.get(position));
        startActivity(intent);
    }

    void getProductDataFromDB()
    {
        friendList.clear();
        SQLiteDatabase db = DBOpenHelper.getInstance(this.getContext()).getReadableDatabase();
        Cursor cursor = db.query(
                DBOpenHelper.FRIENDS,
                new String[]{
                        DBOpenHelper.ID,
                        DBOpenHelper.NAME,
                        DBOpenHelper.TIME,
                        DBOpenHelper.NUMBER
                },
                null,
                null,
                null,
                null,
                null
        );
        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do {
            friendList.add(new Friend(
                    cursor.getInt(cursor.getColumnIndexOrThrow(DBOpenHelper.ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DBOpenHelper.NAME)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DBOpenHelper.TIME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DBOpenHelper.NUMBER))
            ));
            }while(cursor.moveToNext());
        }
    }

}