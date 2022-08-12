package com.example.smallgames;

import static com.example.smallgames.R.drawable.sound_off;
import static com.example.smallgames.R.drawable.sound_on;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SoundControl extends AppCompatActivity {
    MediaPlayer player;
    MediaPlayer popSound;
    MediaPlayer rollSound;
    protected boolean vali = true;
    protected void OnOffFun(Activity main, ImageButton onoffBut)
    {
        if (vali == true){
            onoffBut.setImageResource(sound_on);
        }
        //play sound
        if(player == null)
        {
            player = MediaPlayer.create(main,R.raw.backgroundmusic);
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
    protected void PopSoundFun(Activity main, ImageButton onoffBut)
    {
        popSound = MediaPlayer.create(main,R.raw.pop);
        popSound.start();
    }
    protected void PopSoundFun2(Activity main, Button onoffBut)
    {
        popSound = MediaPlayer.create(main,R.raw.pop);
        popSound.start();
    }
    protected void RollSoundFun(Activity main)
    {
        rollSound = MediaPlayer.create(main,R.raw.dicerollsound);
        for (int i = 0 ; i < 50;i++)
        {
            rollSound.start();
        }
    }
    protected void wrongSoundFun(Activity main)
    {
        MediaPlayer wrong;
        wrong = MediaPlayer.create(main,R.raw.wrong);
        wrong.start();
    }
    protected void winSoundFun(Activity main)
    {
        MediaPlayer win;
        win= MediaPlayer.create(main,R.raw.winning);
        win.start();
    }
}
