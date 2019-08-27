package com.example.application19;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView stevieVideoView = (VideoView) findViewById(R.id.steviesVideoView);
        stevieVideoView.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4");

        //Player controls(play, pause, stop, etc...)
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(stevieVideoView);
        stevieVideoView.setMediaController(mediaController);

        stevieVideoView.start();
    }
}
