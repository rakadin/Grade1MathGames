package com.example.smallgames.part2.game_rules;

import static com.example.smallgames.R.drawable.sound_on;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.smallgames.R;
import com.example.smallgames.SoundControl;
import com.example.smallgames.part2.game_acitivity.Fishing_2_Activity;
import com.example.smallgames.part2.game_acitivity.Slide_game_2_activity;

public class Slide_2_rule extends AppCompatActivity {
    ImageButton soundBut;
    Button nextBut;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide2_rule);
        getSupportActionBar().hide();
        //get id
        soundBut = findViewById(R.id.SonoffBut);
        nextBut = findViewById(R.id.nextBut);

        soundControl.OnOffFun(Slide_2_rule.this,soundBut);
        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Slide_game_2_activity.class);
                startActivity(intent);
            }
        });
    }
    // if restart set activity again
    @Override
    protected void onRestart() {
        super.onRestart();
        soundBut.setImageResource(sound_on);
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