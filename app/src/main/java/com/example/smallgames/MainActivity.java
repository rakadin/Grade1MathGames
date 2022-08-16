package com.example.smallgames;

import static com.example.smallgames.R.drawable.*;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    SoundControl soundControl = new SoundControl();
    ImageButton onoffBut;
    ImageButton game1But;
    ImageButton game2But;
   private boolean vali = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        soundControl.vali = true;
        setContentView(R.layout.activity_main);
        onoffBut = findViewById(R.id.SonoffBut);
        game1But = findViewById(R.id.eggcatch);
        game2But = findViewById(R.id.slide);
        //onlick for game 1
        game1But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(MainActivity.this,game1But);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Game1.class);
                startActivity(intent);
                soundControl.player.pause();
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
    protected void onResume() {
        super.onResume();
        soundControl.player.start();
    }
}