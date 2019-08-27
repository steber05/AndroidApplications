package com.example.application11;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class SteviesIntentService extends IntentService {

    public static final String TAG = "com.example.application11";

    public SteviesIntentService() {
        super("SteviesIntentService");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onHandleIntent(Intent intent) {
        // this is what the service does.
        Log.i(TAG,"Intent now started.");
    }
}
