package com.xware.jsonwithgson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.xware.jsonwithgson.Adapters.RecyclerViewAdapter;
import com.xware.jsonwithgson.Models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeComponents();
    }

    private void InitializeComponents()
    {
        RecyclerView rvUsers = (RecyclerView) findViewById(R.id.rvUsers);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        List<User> users= new ArrayList<>();
        int i=1;
        while (i<99)
        {
            User user= new User();
            user.setName("Name "+i);
            user.setId(i);
            try
            {
                user.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.getDefault()).parse("2017-11-27T13:10:00"));
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            users.add(user);
            ++i;
        }
        RecyclerViewAdapter adapter= new RecyclerViewAdapter(users);
        rvUsers.setAdapter(adapter);
    }
}
