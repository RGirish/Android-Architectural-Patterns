package com.girish.mvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;

import com.girish.mvp.model.User;
import com.girish.mvp.view.user.ViewUser;
import com.girish.mvp.view.user.ViewUserImpl;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements ViewUser.UserDetailsSubmitListener {

    ViewUserImpl view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        view = new ViewUserImpl(getLayoutInflater(), viewGroup);
        view.setListener(this);
    }

    @Override
    public void onSubmitClick(User user) {
        Log.i(getClass().getSimpleName(), user.getName());
        Log.i(getClass().getSimpleName(), String.valueOf(user.getAge()));
        Log.i(getClass().getSimpleName(), user.getProfession());
        view.displayId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
    }
}
