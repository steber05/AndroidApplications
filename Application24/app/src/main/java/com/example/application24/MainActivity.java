package com.example.application24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    TextView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.userNameInput);
        password = (EditText) findViewById(R.id.passwordInput);
        dataView = (TextView) findViewById(R.id.dataTextView);
    }

    public void saveInfo(View view){
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginData.edit();
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();

        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }

    public void getInfo(View view){
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = loginData.getString("username", "");
        String pw = loginData.getString("password","");
        String msg = "Username: " + name + "\nPassword: " + pw;
        dataView.setText(msg);
    }
}
