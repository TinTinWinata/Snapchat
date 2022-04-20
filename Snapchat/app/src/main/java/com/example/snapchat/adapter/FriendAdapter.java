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
import com.example.snapchat.models.Friend;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder> {
    private ArrayList<Friend> friendList;
    private ProductClickListener listener;

    public FriendAdapter(ArrayList<Friend> friendList, ProductClickListener listener) {
        this.friendList = friendList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_layout,parent,false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(friendList.get(position).getName());
        holder.tvTime.setText(friendList.get(position).getTime() + " days");
    }

    @Override
    public int getItemCount() {
        Log.d("size", "Size of friend list : " + friendList.size());
        return friendList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvTime;
        CardView cvFriend;
        public MyViewHolder(@NonNull View itemView, ProductClickListener listener)
        {
         super(itemView);
         tvName = itemView.findViewById(R.id.tvName);
         tvTime = itemView.findViewById(R.id.tvTime);
         cvFriend = itemView.findViewById(R.id.cvFriend);

         cvFriend.setOnClickListener(x -> {
             listener.onProductClicked(getAdapterPosition());
         });
        }
    }
    public interface ProductClickListener{
        void onProductClicked(int position);
    }
}
