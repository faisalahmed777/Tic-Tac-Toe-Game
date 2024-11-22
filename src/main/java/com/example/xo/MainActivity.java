package com.example.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        audio = MediaPlayer.create(MainActivity.this,R.raw.audio);

    }

    public void playButton(View view){
        Intent intent = new Intent(this, PlayerSetup.class);
        startActivity(intent);

    }
    public void playIt(View view) {
        if (!audio.isPlaying() && audio.getCurrentPosition() == 0) {
            audio.start();  // Start the music if it hasn't been played yet
        } else if (audio.isPlaying()) {
            audio.stop();  // Stop the music if it's currently playing
            try {
                audio.prepare(); // Prepare the player again after stopping
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!audio.isPlaying() && audio.getCurrentPosition() > 0) {
            audio.start();  // Resume the music if it was stopped
        }
    }


}