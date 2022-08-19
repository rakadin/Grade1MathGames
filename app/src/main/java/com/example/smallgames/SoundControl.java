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
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        // Loop sound when play to the end
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
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
        popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    protected void PopSoundFun2(Activity main, Button onoffBut)
    {
        popSound = MediaPlayer.create(main,R.raw.pop);
        popSound.start();
        popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    // roll the dice sound
    protected void RollSoundFun(Activity main)
    {
        rollSound = MediaPlayer.create(main,R.raw.dicerollsound);
        for (int i = 0 ; i < 50;i++)
        {
            rollSound.start();
        }
        rollSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    // wrong sound
    protected void wrongSoundFun(Activity main)
    {

        wrong = MediaPlayer.create(main,R.raw.wrong);
        wrong.start();
        wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    // correct sound
    protected void correctSoundFun(Activity main)
    {
        correct = MediaPlayer.create(main,R.raw.correct);
        correct.start();
        correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    // winning sound
    protected void winSoundFun(Activity main)
    {

        win= MediaPlayer.create(main,R.raw.winning);
        win.start();
        win.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    // running sound
    protected void runSoundFun(Activity main)
    {
        run= MediaPlayer.create(main,R.raw.running);
        run.start();
        run.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    protected void runSoundStopFun(Activity main)
    {

        run= MediaPlayer.create(main,R.raw.running);
        run.stop();
        run.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    // go up sound
    protected void upSoundFun(Activity main)
    {
        up= MediaPlayer.create(main,R.raw.upstair);
        up.start();
        up.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    protected void upSoundStopFun(Activity main)
    {
        up= MediaPlayer.create(main,R.raw.upstair);
        up.stop();
        up.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    // falling sound
    protected void fallSoundFun(Activity main)
    {
        fall= MediaPlayer.create(main,R.raw.fall);
        fall.start();
        fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    protected void fallSoundStopFun(Activity main)
    {
        fall= MediaPlayer.create(main,R.raw.fall);
        fall.stop();
        fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
}
