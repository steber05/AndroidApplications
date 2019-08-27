package com.example.application14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Handler waitMsgHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView displayText = (TextView) findViewById(R.id.displayText);
            displayText.setText("Good job!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view){
    // Vid 40
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // thread commands
                long futureTime = (System.currentTimeMillis()+ 10000);//10 sec

                while (System.currentTimeMillis()< futureTime){
                    // If you're not using a thread you don't need to sync
                    synchronized(this){
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        }catch(Exception e){}
                    }
                }
                waitMsgHandler.sendEmptyMessage(0);
            }
        };
        Thread steviesThread = new Thread(r);
        steviesThread.start();

        Toast.makeText(MainActivity.this,"Wait 10 seconds",Toast.LENGTH_LONG).show();

        //Non thread code
    /*
        long futureTime = (System.currentTimeMillis()+ 10000);//10 sec
        //Don't make futuretime more than 3 seconds else Toast wont show
        Toast.makeText(MainActivity.this,"Waiting 2 seconds",Toast.LENGTH_LONG).show();

        while (System.currentTimeMillis()< futureTime){
            // If you're not using a thread you don't need to sync
            synchronized(this){
                try {
                    wait(futureTime - System.currentTimeMillis());
                }catch(Exception e){}
            }
        }

        // Move to handler.
        TextView displayText = (TextView) findViewById(R.id.displayText);
        displayText.setText("Good job!");
    */
    }
}
