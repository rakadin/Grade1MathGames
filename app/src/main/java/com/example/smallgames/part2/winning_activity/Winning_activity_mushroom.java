package com.example.smallgames.part2.winning_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.smallgames.R;
import com.example.smallgames.SoundControl;
import com.example.smallgames.part2.Part2_Homepage_Activity;
import com.example.smallgames.part2.game_acitivity.Fishing_2_Activity;
import com.example.smallgames.part2.game_acitivity.Mushroom_Activity;

public class Winning_activity_mushroom extends AppCompatActivity {
    Button replayBut;
    Button menuBut;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_win);
        getSupportActionBar().hide();
        soundControl.winSoundFun(Winning_activity_mushroom.this);
        replayBut = findViewById(R.id.replayBut);
        menuBut = findViewById(R.id.menuBut);
        replayBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                soundControl.PopSoundFun(Winningactivity.this,);
                soundControl.PopSoundFun2(Winning_activity_mushroom.this,replayBut);
                Intent intent = new Intent();
                intent.setClass(Winning_activity_mushroom.this, Mushroom_Activity.class);
                startActivity(intent);
//                soundControl.player.pause();
            }
        });
        menuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun2(Winning_activity_mushroom.this,replayBut);
                Intent intent = new Intent();
                intent.setClass(Winning_activity_mushroom.this, Part2_Homepage_Activity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        soundControl.win.release();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.win.release();
    }
}