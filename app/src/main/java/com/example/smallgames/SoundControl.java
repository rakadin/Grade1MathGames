package com.example.smallgames;

import static com.example.smallgames.R.drawable.sound_off;
import static com.example.smallgames.R.drawable.sound_on;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
/*
     control all sounds in the project
 */
public class SoundControl extends AppCompatActivity {
    public MediaPlayer player;
    public MediaPlayer up;
    public MediaPlayer fall;
    public MediaPlayer run;
    public MediaPlayer win;
    public MediaPlayer correct;
    public MediaPlayer wrong;
    public MediaPlayer hooray;
    public MediaPlayer popSound;
    public MediaPlayer rollSound;
    protected boolean vali = true;

    // background sound control
    public void OnOffFun(Activity main, ImageButton onoffBut)
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
    //play theme song
    public void themeSongFunc(Context context)
    {
        player = MediaPlayer.create(context,R.raw.theme_song);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
                player.release();
            }
        });
    }
    // pop sound
    public  void touchButFunc(Context context)
    {
        popSound = MediaPlayer.create(context,R.raw.pop);
        popSound.start();
        popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    public void PopSoundFun(Activity main, ImageButton onoffBut)
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
    public void PopSoundFun2(Activity main, Button onoffBut)
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
    public void RollSoundFun(Activity main)
    {
        rollSound = MediaPlayer.create(main,R.raw.dicerollsound);
        for (int i = 0 ; i < 10;i++)
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
    public void wrongSoundFun(Activity main)
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
    // wrong sound
    public void wrongSoundFun2(Context context)
    {

        wrong = MediaPlayer.create(context,R.raw.wrong);
        wrong.start();
        wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    // correct sound
    public void correctSoundFun(Activity main)
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
    public void winSoundFun(Activity main)
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
    public void runSoundFun(Activity main)
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
    public void runSoundStopFun(Activity main)
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
    public void upSoundFun(Activity main)
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
    public void upSoundStopFun(Activity main)
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
    public void fallSoundFun(Activity main)
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
    public void fallSoundStopFun(Activity main)
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
    // hooray sound
    public void hooraySoundFun2(Context context)
    {
        hooray= MediaPlayer.create(context,R.raw.hooray);
        hooray.start();
        hooray.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    // hooray sound
    public void hooraySoundFun(Activity main)
    {
        hooray= MediaPlayer.create(main,R.raw.hooray);
        hooray.start();
        hooray.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    public void sailingSoundFunc(Context context)
    {
        fall= MediaPlayer.create(context,R.raw.ship_sailing_sound);
        fall.start();
        fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    public void fishingSoundFunc(Context context)
    {
        fall= MediaPlayer.create(context,R.raw.fishing_sound);
        fall.start();
        fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    public void pianoSoundFunc(Context context)
    {
        fall= MediaPlayer.create(context,R.raw.piano);
        fall.start();
        fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    public void machineSoundFunc(Context context)
    {
        fall= MediaPlayer.create(context,R.raw.machine_startup);
        fall.start();
        fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
    public void beeSoundFunc(Context context)
    {
        fall= MediaPlayer.create(context,R.raw.bee_noise);
        fall.start();
        fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
}
