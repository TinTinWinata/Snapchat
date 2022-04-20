package com.example.snapchat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snapchat.adapter.FriendAdapter;
import com.example.snapchat.models.Friend;

import java.util.ArrayList;

public class ChatFragment extends Fragment implements FriendAdapter.ProductClickListener{

    public static ArrayList<Friend> friendList = new ArrayList<>();
    RecyclerView recycleView;
    FriendAdapter friendAdapter;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


    }

    private void insertDummyData()
    {
        friendList.add(new Friend(1, "Justine", 30));
        friendList.add(new Friend(2, "Vito Caris", 41));
        friendList.add(new Friend(3, "Hady Gustianto", 23));
        friendList.add(new Friend(4, "Jason", 43));
        friendList.add(new Friend(5, "Renaldi Addison", 19));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_chat, null);
//        insertDummyData();
//
//        Log.d("Error", "Size :  " + friendList.size());
//
//        recycleView = (RecyclerView) root.findViewById(R.id.recycleView);
//        recycleView.setLayoutManager(new LinearLayoutManager(getContext(),
//                LinearLayoutManager.VERTICAL, false));
//        friendAdapter = new FriendAdapter(friendList, this);
//        recycleView.setAdapter(friendAdapter);

        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        insertDummyData();
        recycleView = view.findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        friendAdapter = new FriendAdapter(friendList, this);
        recycleView.setAdapter(friendAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        friendAdapter.notifyDataSetChanged();
        recycleView.setAdapter(friendAdapter);
    }

    @Override
    public void onProductClicked(int position) {

    }
}