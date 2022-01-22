package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play, forward, rewind, pause, stop, reset;
        MediaPlayer mediaPlayer;

        int starttime = 0;
        int stopttime = 0;
        int forwardtime = 5000;
        int backwardtime = 5000;
        play = findViewById(R.id.play);
        forward = findViewById(R.id.froward);
        rewind = findViewById(R.id.rewind);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);
        mediaPlayer = MediaPlayer.create(this, R.raw.sample);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Playing Media now", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(starttime);
                mediaPlayer.start();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition();
                if ((currentpos + forwardtime) <= (mediaPlayer.getDuration())) {
                    mediaPlayer.seekTo(currentpos + forwardtime);
                }
            }
        });
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentpos = mediaPlayer.getCurrentPosition();
                if ((currentpos - backwardtime) >= starttime) {
                    mediaPlayer.seekTo(currentpos - backwardtime);
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.pause();
            }
        });
    }
}