package com.example.application11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView toggleState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Intent Service
//        Intent intent = new Intent(this,SteviesIntentService.class);
//        startService(intent);
        // Service
        Intent steviesService = new Intent(this,SteviesService.class);
        startService(steviesService);

    }

    public void baconClick(View view){
        Intent I = new Intent(this, Bacon.class);
        // get user input
        final EditText userInput = (EditText) findViewById(R.id.userInput);
        String userMessage = userInput.getText().toString();
        // pass user input in the intent
        I.putExtra("applesMessage", userMessage);

        startActivity(I);
    }
}
