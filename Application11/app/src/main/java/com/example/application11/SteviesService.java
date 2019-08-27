package com.example.application11;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SteviesService extends Service {

    public static final String TAG = "com.example.application11";

    public SteviesService() {

    }

    @SuppressLint("LongLogTag")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // default - return super.onStartCommand(intent, flags, startId);
        Log.i(TAG,"onStartCommand called");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // What do you want the thread to do
                for (int i = 0; i < 5; i++) {
                    long futureTime = (System.currentTimeMillis() + 5000);// 5 sec

                    while (System.currentTimeMillis() < futureTime) {
                        // Don't need to sync when you are not using a thread e,g, Tutorial 39
                        synchronized (this) {
                            try {
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG, "Service is doing something");
                            } catch (Exception e) {

                            }
                        }
                    }
                }
            }
        };
        // start the thread
        Thread steviesThread = new Thread(r);
        steviesThread.start();
        return Service.START_STICKY; // restarts the service if it gets destroyed.
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onDestroy() {
        //Removed default super
        Log.i(TAG,"onDestroy called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
