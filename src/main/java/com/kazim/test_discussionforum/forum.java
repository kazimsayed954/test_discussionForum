package com.kazim.test_discussionforum;

import android.app.Application;

import com.firebase.client.Firebase;


public class forum extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
