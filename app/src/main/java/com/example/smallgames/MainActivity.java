package com.example.smallgames;

import static com.example.smallgames.R.drawable.*;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.smallgames.part2.Choose_part_activity;

/*

 home activity that navigate to 5 games

 */
public class MainActivity extends AppCompatActivity {
    SoundControl soundControl = new SoundControl();
    ImageButton onoffBut;
    ImageButton game1But;
    ImageButton game2But;
    ImageButton game3But;
    ImageButton game4But;
    ImageButton game5But,bookBut;
   private boolean vali = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        soundControl.vali = true;
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        onoffBut = findViewById(R.id.SonoffBut);
        game1But = findViewById(R.id.eggcatch);
        game2But = findViewById(R.id.slide);
        game3But = findViewById(R.id.fishcatch);
        game4But = findViewById(R.id.chicken);
        game5But = findViewById(R.id.cardch);
        bookBut = findViewById(R.id.bookBut);
        // choose book
        bookBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Choose_part_activity.class);
                startActivity(intent);
            }
        });
        //onlick for game 1
        game1But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game1But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Game1.class);
                startActivity(intent);
                soundControl.player.pause();
                soundControl.popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });
        game2But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game2But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Slide_introduction.class);
                startActivity(intent);
                soundControl.player.pause();
                soundControl.popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });
        game3But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game3But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Fishing_introduction.class);
                startActivity(intent);
                soundControl.player.pause();
                soundControl.popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });
        game4But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game4But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Card_game_introduction.class);
                startActivity(intent);
                soundControl.player.pause();
                soundControl.popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });
        game5But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game4But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Chicken_game_introduction.class);
                startActivity(intent);
                soundControl.player.pause();
                soundControl.popSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        });
        soundControl.OnOffFun(MainActivity.this,onoffBut);

    }
// if restart set activity again
    @Override
    protected void onRestart() {
        super.onRestart();
        onoffBut.setImageResource(sound_on);
        vali = true;
        soundControl.player.start();
    }
// if destroy stop music
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(soundControl.player != null)
        {
            soundControl.player.stop();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.player.stop();
        soundControl.player.release();
    }
}