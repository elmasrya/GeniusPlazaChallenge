package com.example.geniusplazachallenge.ui_layer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.geniusplazachallenge.R;

import java.util.ArrayList;

/**
 * Created by Andrew El-Masry March 10th, 2019
 *
 * This is the list adapter for the User Recycler View
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {
    private ArrayList<User> userArrayList;
    RequestOptions options;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout userListItemLayout;
        public MyViewHolder(RelativeLayout userListItemLayout) {
            super(userListItemLayout);
            this.userListItemLayout = userListItemLayout;
        }
    }

    public UserListAdapter(ArrayList userArrayList, Context context) {
        this.userArrayList = userArrayList;
        this.context = context;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.user_avatar);
    }

    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        RelativeLayout userListItemLayout = (RelativeLayout) LayoutInflater.from(parent
            .getContext()).inflate(R.layout.user_list_item, parent, false);

        MyViewHolder vh = new MyViewHolder(userListItemLayout);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageView img = (ImageView) holder.userListItemLayout.getChildAt(0);
        Glide.with(context).load(userArrayList.get(position).getImgUrl()).apply(options).into(img);
        TextView tx = (TextView) holder.userListItemLayout.getChildAt(1);
        tx.setText(userArrayList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
}
