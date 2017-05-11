package com.example.a4_contentresolver_broadcastreceiver;

import android.app.Application;

import com.example.a4_contentresolver_broadcastreceiver.data.local.ContactRepo;
import com.example.a4_contentresolver_broadcastreceiver.data.local.ContentResolverContactRepo;


public class MyApplication extends Application {

    private static ContactRepo contactRepo;

    @Override
    public void onCreate() {
        super.onCreate();
        contactRepo = new ContentResolverContactRepo(this);
    }

    public static ContactRepo getContactRepo() {
        return contactRepo;
    }
}
