package com.example.application15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    MyService theService;
    boolean isBound = false;

    public void showTime(View view){
        String currentTime = theService.getCurrentTime();
        TextView steviesText = (TextView) findViewById(R.id.steviesText);
        steviesText.setText(currentTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MyService.class);
        bindService(i, steviesConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection steviesConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // get a ref to the binder class and call the bind method
            MyService.MyLocalBinder binder = (MyService.MyLocalBinder) service;
            theService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}
