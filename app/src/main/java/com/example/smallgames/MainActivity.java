package com.example.smallgames;

import static com.example.smallgames.R.drawable.*;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton onoffBut;
   MediaPlayer player;
   private boolean vali = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onoffBut = findViewById(R.id.SonoffBut);
        //play sound
            if(player == null)
            {
                player = MediaPlayer.create(MainActivity.this,R.raw.backgroundmusic);
            }
            player.start();
            // Loop sound when play to the end
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                player.start();
            }
        });

        // background sound control button function
        onoffBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vali == true)// when sound is on -> click -> off
                {
                    vali = false;
                    player.pause();
                    onoffBut.setImageResource(sound_off);
                }
                else// when sound is off -> click -> on
                {
                    vali = true;
                    player.start();
                    onoffBut.setImageResource(sound_on);
                }

            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(player != null)
        {
            player.stop();
        }
    }
}