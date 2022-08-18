package com.example.smallgames;

import static com.example.smallgames.R.drawable.sound_off;
import static com.example.smallgames.R.drawable.sound_on;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
/*
     control all sounds in the project
 */
public class SoundControl extends AppCompatActivity {
    MediaPlayer player;
    MediaPlayer up;
    MediaPlayer fall;
    MediaPlayer run;
    MediaPlayer win;
    MediaPlayer correct;
    MediaPlayer wrong;

    MediaPlayer popSound;
    MediaPlayer rollSound;
    protected boolean vali = true;

    // background sound control
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
    // pop sound
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
    // roll the dice sound
    protected void RollSoundFun(Activity main)
    {
        rollSound = MediaPlayer.create(main,R.raw.dicerollsound);
        for (int i = 0 ; i < 50;i++)
        {
            rollSound.start();
        }
    }
    // wrong sound
    protected void wrongSoundFun(Activity main)
    {

        wrong = MediaPlayer.create(main,R.raw.wrong);
        wrong.start();
    }
    // correct sound
    protected void correctSoundFun(Activity main)
    {

        correct = MediaPlayer.create(main,R.raw.correct);
        correct.start();
    }
    // winning sound
    protected void winSoundFun(Activity main)
    {

        win= MediaPlayer.create(main,R.raw.winning);
        win.start();
    }
    // running sound
    protected void runSoundFun(Activity main)
    {
        run= MediaPlayer.create(main,R.raw.running);
        run.start();
    }
    protected void runSoundStopFun(Activity main)
    {

        run= MediaPlayer.create(main,R.raw.running);
        run.stop();
    }
    // go up sound
    protected void upSoundFun(Activity main)
    {
        up= MediaPlayer.create(main,R.raw.upstair);
        up.start();
    }
    protected void upSoundStopFun(Activity main)
    {
        up= MediaPlayer.create(main,R.raw.upstair);
        up.stop();
    }

    // falling sound
    protected void fallSoundFun(Activity main)
    {
        fall= MediaPlayer.create(main,R.raw.fall);
        fall.start();
    }
    protected void fallSoundStopFun(Activity main)
    {
        fall= MediaPlayer.create(main,R.raw.fall);
        fall.stop();
    }
}
