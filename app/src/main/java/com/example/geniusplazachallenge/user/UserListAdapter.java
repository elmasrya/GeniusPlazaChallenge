package com.example.geniusplazachallenge.user;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.geniusplazachallenge.R;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {
    private String[] testDataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout userListItemLayout;
        public MyViewHolder(RelativeLayout userListItemLayout) {
            super(userListItemLayout);
            this.userListItemLayout = userListItemLayout;
        }
    }

    public UserListAdapter(String[] myDataset) {
        testDataSet = myDataset;
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
        TextView tx = (TextView) holder.userListItemLayout.getChildAt(1);
        tx.setText(testDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return testDataSet.length;
    }
}
