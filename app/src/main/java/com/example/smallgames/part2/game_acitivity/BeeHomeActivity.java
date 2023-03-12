package com.example.smallgames.part2.game_acitivity;

import static com.example.smallgames.R.drawable.sound_on;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smallgames.R;
import com.example.smallgames.SoundControl;
import com.example.smallgames.Utils;
import com.example.smallgames.part2.Part2_Homepage_Activity;
import com.example.smallgames.part2.game_controller.Bee_Home_Controller;
import com.example.smallgames.part2.game_controller.Gif_PopUp_Controller;
import com.example.smallgames.part2.game_controller.GoldIsland_Controller;
import com.example.smallgames.part2.winning_activity.Winning_activity_bee_home;
import com.example.smallgames.part2.winning_activity.Winning_activity_golden_island;

import pl.droidsonroids.gif.GifImageView;

public class BeeHomeActivity extends AppCompatActivity {
    SoundControl soundControl = new SoundControl();
    ImageButton soundBut,homeBut,diceBut;
    Dialog dialog ;
    Bee_Home_Controller controller = new Bee_Home_Controller();
    Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();// call controller
    int diceNumFinal = 0;
    int now_loc =0, previous_loc =0;
    Button moveBut,getHBut;
    GifImageView clock_1,clock_2,clock_3,clock_4,clock_5,clock_6,clock_7,clock_8,clock_9,clock_10,
            clock_11,clock_12,clock_13,clock_14,clock_15;
    ImageView clock_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bee_home);
        getSupportActionBar().hide();
        dialog = new Dialog(BeeHomeActivity.this);// dialog
        // get idS
        soundBut = findViewById(R.id.SonoffBut);
        homeBut = findViewById(R.id.homeBut);
        diceBut = findViewById(R.id.dice);
        moveBut = findViewById(R.id.moveBut);
        getHBut = findViewById(R.id.getHBut);
        clock_now = findViewById(R.id.clock_now);
        getid();
        GifImageView clocks[] = {clock_1,clock_2,clock_3,clock_4,clock_5,clock_6,clock_7,clock_8,clock_9,clock_10,
                clock_11,clock_12,clock_13,clock_14,clock_15};
        // set sound controll button
        soundControl.OnOffFun(this,soundBut);
        setHomeBut();
        rollDice();
        // set function moving ship
        moveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    previous_loc = now_loc;
                    now_loc += diceNumFinal;
                    if(now_loc > 15)// if move > 15
                    {
                        now_loc -= diceNumFinal;
                        previous_loc = now_loc;
                    }
                    else
                    {
                        if(previous_loc >0)// previous lock must > 0
                        {
                            clocks[previous_loc-1].setImageResource(0);
                        }
                        soundControl.beeSoundFunc(view.getContext());
                        gif_popUp_controller.show_bee_yeah(dialog);
                        Utils.delay(50, () -> {
                            soundControl.fall.release();
                            dialog.dismiss();
                            clocks[now_loc-1].setImageResource(R.drawable.bee_gif);
                            controller.getIMG(now_loc-1,clock_now);
                            if(now_loc == 15)
                            {
                                gif_popUp_controller.show_bee_home(dialog);
                                soundControl.hooraySoundFun2(view.getContext());
                                Utils.delay(50, () -> {
                                   winner(view.getContext());
                                });
                            }
                            if(now_loc == 11 || now_loc == 7)
                            {
                                moveBut.setVisibility(View.GONE);
                                getHBut.setVisibility(View.VISIBLE);
                                HButFunc();
                            }
                        });


                    }
                }
            }
        });


    }
    void HButFunc()
    {
        getHBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gif_popUp_controller.show_bee_home(dialog);
                soundControl.hooraySoundFun2(view.getContext());
                Utils.delay(50, () -> {
                    winner(view.getContext());
                });
            }
        });
    }
    void winner(Context context)
    {
        Intent intent = new Intent();
        intent.setClass(context, Winning_activity_bee_home.class);
        startActivity(intent);
    }
    // get clock id
    void getid()
    {
        clock_1 = findViewById(R.id.clock_1);
        clock_2 = findViewById(R.id.clock_2);
        clock_3 = findViewById(R.id.clock_3);
        clock_4 = findViewById(R.id.clock_4);
        clock_5 = findViewById(R.id.clock_5);
        clock_6 = findViewById(R.id.clock_6);
        clock_7 = findViewById(R.id.clock_7);
        clock_8 = findViewById(R.id.clock_8);
        clock_9 = findViewById(R.id.clock_9);
        clock_10 = findViewById(R.id.clock_10);
        clock_11 = findViewById(R.id.clock_11);
        clock_12 = findViewById(R.id.clock_12);
        clock_13 = findViewById(R.id.clock_13);
        clock_14 = findViewById(R.id.clock_14);
        clock_15 = findViewById(R.id.clock_15);
    }
    // home button func
    void setHomeBut()
    {
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Part2_Homepage_Activity.class);
                startActivity(intent);
            }
        });
    }
    // roll the dicefunc
    int rollDice()
    {
        // dice button controll
        // roll the dice
        diceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int images[] = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
                int sec = 1;
                for (int j = 0 ; j < 7;j++){
                    Utils.delay(sec, () -> {
                        soundControl.RollSoundFun(BeeHomeActivity.this);
                        diceNumFinal = (int) (Math.random() * 6 + 1);
                        diceBut.setImageResource(images[diceNumFinal-1]);
                    });
                }

            }

        });

        // end roll
        return diceNumFinal;

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