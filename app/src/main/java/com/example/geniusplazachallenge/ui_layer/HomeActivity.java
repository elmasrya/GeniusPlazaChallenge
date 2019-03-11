package com.example.geniusplazachallenge.ui_layer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.geniusplazachallenge.R;
import com.example.geniusplazachallenge.network_layer.RequestController;
import com.example.geniusplazachallenge.network_layer.UserRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter mAdapter;
    JSONArray userArray = null;
    ArrayList<User> userList = null;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        activity = this;
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Button createNewUser = (Button) findViewById(R.id.create_user_button);
        createNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, CreateUserActivity.class);
                startActivityForResult(i, 100);
            }
        });

        final UserRequest userRequest = new UserRequest(this);

        userRequest.getRequest(new RequestController() {
            @Override
            public void start() {

            }

            @Override
            public void finish(JSONObject response) {
                String firstName, lastName, imgUrl;
                userList = new ArrayList<>();
                User user = null;

                try {
                    userArray = response.getJSONArray("data");
                    int i;

                    for (i = 0; i < userArray.length(); i++) {
                        user = new User();
                        firstName = userArray.getJSONObject(i).getString("first_name");
                        lastName = userArray.getJSONObject(i).getString("last_name");
                        user.setUserName(firstName + " " + lastName);
                        imgUrl = userArray.getJSONObject(i).getString("avatar");
                        user.setImgUrl(imgUrl);
                        userList.add(i, user);
                    }

                    mAdapter = new UserListAdapter(userList, activity);
                    recyclerView.setAdapter(mAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
