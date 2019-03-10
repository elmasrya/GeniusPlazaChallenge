package com.example.geniusplazachallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.geniusplazachallenge.user.UserListAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // TODO: Delete Test data
        String[] hey = {"john", "suzy", "mike", "nancy", "Tim", "Sam", "Lima", "Alpha", "Sierra",
            "Hoe", "john", "suzy", "mike", "nancy", "Tim", "Sam", "Lima", "Alpha", "Sierra",
            "john", "suzy", "mike", "nancy", "Tim", "Sam", "Lima", "Alpha", "Sierra"};
        mAdapter = new UserListAdapter(hey);
        recyclerView.setAdapter(mAdapter);
    }
}
