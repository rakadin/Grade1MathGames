package com.example.smallgames.part2;

import static com.example.smallgames.R.drawable.sound_on;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.smallgames.R;
import com.example.smallgames.SoundControl;
import com.example.smallgames.part2.game_rules.Fishing_2_rule;
import com.example.smallgames.part2.game_rules.GoldIsland_rule;

public class Part2_Homepage_Activity extends AppCompatActivity {
    SoundControl soundControl = new SoundControl();
    ImageButton soundbut,bookBut;
    Button  goldisland,fishing,ladder_slide,mushroom,gettoy,beehome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2_homepage);
        getSupportActionBar().hide();
        //get ids
        soundbut = findViewById(R.id.SonoffBut);
        goldisland = findViewById(R.id.goldisland);
        fishing = findViewById(R.id.fishing);
        ladder_slide = findViewById(R.id.ladder_slide);
        mushroom = findViewById(R.id.ladder_slide);
        gettoy = findViewById(R.id.gettoy);
        beehome = findViewById(R.id.beehome);
        bookBut = findViewById(R.id.bookBut);

        // get on click button funcs
        goldisland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), GoldIsland_rule.class);
                startActivity(intent);
            }
        });
        bookBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(),Choose_part_activity.class);
                startActivity(intent);
            }
        });
        fishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Fishing_2_rule.class);
                startActivity(intent);
            }
        });
        // function
        soundControl.OnOffFun(Part2_Homepage_Activity.this,soundbut);

    }

    // if restart set activity again
    @Override
    protected void onRestart() {
        super.onRestart();
        soundbut.setImageResource(sound_on);
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