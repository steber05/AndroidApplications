package com.example.application11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Bacon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);

        Bundle appleData = getIntent().getExtras();
        if (appleData== null){
            return;
        }
        String applesMessage = appleData.getString("applesMessage");
        TextView tvBacon = (TextView) findViewById(R.id.baconText);
        tvBacon.setText(applesMessage);
    }

    public void applesClick(View view){
        Intent I = new Intent(this, MainActivity.class);
        startActivity(I);
    }
}
