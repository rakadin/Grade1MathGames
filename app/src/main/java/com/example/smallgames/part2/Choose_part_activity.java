package com.example.smallgames.part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smallgames.MainActivity;
import com.example.smallgames.R;
import com.example.smallgames.SoundControl;

public class Choose_part_activity extends AppCompatActivity {
    Button p1,p2;
    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_part);
        getSupportActionBar().hide();
        p1 = findViewById(R.id.part1But);
        p2 = findViewById(R.id.part2But);
        soundControl.themeSongFunc(Choose_part_activity.this);// play theme music in the background
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.touchButFunc(view.getContext());
                Intent intent = new Intent();
                intent.setClass(Choose_part_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Choose_part_activity.this, Part2_Homepage_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.player.release();
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.player.release();
    }
}