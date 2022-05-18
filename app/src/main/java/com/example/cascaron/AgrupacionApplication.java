package com.example.cascaron;

import android.app.Application;

public class AgrupacionApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AgrupacionDatabase.create(this);
    }
}
