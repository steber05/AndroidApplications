package com.example.application10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewGroup steviesLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        steviesLayout = (ViewGroup)findViewById(R.id.steviesLayout);
        steviesLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        moveButton();
                        return true;
                    }
                }
        );
    }

    public void moveButton(){
        View steviesButton = findViewById(R.id.steviesButton);

        TransitionManager.beginDelayedTransition(steviesLayout);

        // Change the position of the button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        steviesButton.setLayoutParams(positionRules);

        //Change the size of the button
        ViewGroup.LayoutParams sizeRules = steviesButton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height= 300;
        steviesButton.setLayoutParams(sizeRules);
    }
}
