package com.example.snapchat.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snapchat.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder>{


    private ArrayList<String> chatList;

    public ChatAdapter(ArrayList<String> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_layout,
                parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvChat.setText(chatList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d("Size", chatList.size() + "");
        return chatList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvChat;
        CardView cvChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChat = itemView.findViewById(R.id.tvChatLayoutName);
            cvChat = itemView.findViewById(R.id.cvChat);
        }
    }

}
