package com.example.smallgames.part2.game_acitivity;

import static com.example.smallgames.R.drawable.home;
import static com.example.smallgames.R.drawable.sound_on;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smallgames.R;
import com.example.smallgames.Slide_game_main;
import com.example.smallgames.SoundControl;
import com.example.smallgames.Utils;
import com.example.smallgames.part2.Part2_Homepage_Activity;
import com.example.smallgames.part2.game_controller.Gif_PopUp_Controller;
import com.example.smallgames.part2.game_controller.GoldIsland_Controller;
import com.example.smallgames.part2.winning_activity.Winning_activity_golden_island;

import pl.droidsonroids.gif.GifImageView;

public class GoldIslandActivity extends AppCompatActivity {
    GoldIsland_Controller goldIsland_controller = new GoldIsland_Controller();
    SoundControl soundControl = new SoundControl();
    ImageButton soundBut,homeBut,diceBut;
    GifImageView ship_gif,chest_gif;
    TextView num_now;
    Dialog dialog ;
    Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();// call controller
    int diceNumFinal = 0;
    int now_loc =0, previous_loc =0;
    Button loc_1,loc_2,loc_3,loc_4,loc_5,loc_6,loc_7,loc_8,loc_9,loc_10,loc_11,loc_12,loc_13,loc_14,loc_15,loc_16,loc_17,loc_18,loc_19,loc_20,
            loc_21,loc_22,loc_23,loc_24,loc_25,loc_26,loc_27,loc_28,loc_29,loc_30,
            loc_31,loc_32,loc_33,loc_34,loc_35,loc_36,loc_37,loc_38,loc_39;
    Button moveBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_island);
        getSupportActionBar().hide();
        dialog = new Dialog(GoldIslandActivity.this);// dialog
        // get idS
        soundBut = findViewById(R.id.SonoffBut);
        homeBut = findViewById(R.id.homeBut);
        diceBut = findViewById(R.id.dice);
        moveBut = findViewById(R.id.moveBut);
        num_now = findViewById(R.id.num_now);
        ship_gif = findViewById(R.id.ship_sailing);
        chest_gif = findViewById(R.id.chest_open);
        getShipBut();
        Button multiShip[] ={loc_1,loc_2,loc_3,loc_4,loc_5,loc_6,loc_7,loc_8,loc_9,loc_10,loc_11,loc_12,loc_13,loc_14,loc_15,loc_16,loc_17,loc_18,loc_19,loc_20,
                loc_21,loc_22,loc_23,loc_24,loc_25,loc_26,loc_27,loc_28,loc_29,loc_30,
                loc_31,loc_32,loc_33,loc_34,loc_35,loc_36,loc_37,loc_38,loc_39};
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
                    // switching location
                    int tempr = previous_loc;
                    int tem = now_loc;
                    previous_loc = tem;
                    now_loc = previous_loc+ diceNumFinal;
                    if(now_loc >39)// not increase > 39
                    {
                        now_loc = now_loc - diceNumFinal;
                        previous_loc = tempr;
                        dialog.dismiss();
                    }
                    else
                    {
                        Animation animation3 = AnimationUtils.loadAnimation(view.getContext(), R.anim.ship_go_down_right);
                        Animation animation4 = AnimationUtils.loadAnimation(view.getContext(), R.anim.ship_go_up_right);
                        Animation animation5 = AnimationUtils.loadAnimation(view.getContext(), R.anim.ship_go_up_right_2);
                        if(now_loc == 39)//go to island
                        {

                            Utils.delay(55, () -> {
                                soundControl.hooraySoundFun(GoldIslandActivity.this);
                                gif_popUp_controller.show_gold_chest(dialog);
                            });
                            Utils.delay(125, () -> {
                                dialog.dismiss();
                                Intent intent = new Intent();
                                intent.setClass(view.getContext(), Winning_activity_golden_island.class);
                                startActivity(intent);
                            });

                        }
                        if(now_loc == 5)
                        {
                            now_loc = 13;
                            Utils.delay(55, () -> {
                                multiShip[now_loc-1].setAnimation(animation4);
                            });

                        }
                        if(now_loc == 16)
                        {
                            now_loc = 27;
                            Utils.delay(55, () -> {
                                multiShip[now_loc-1].setAnimation(animation5);
                            });
                        }
                        if(now_loc == 19)
                        {
                            now_loc = 3;
                            Utils.delay(55, () -> {
                                multiShip[now_loc-1].setAnimation(animation3);
                            });
                        }
                        if(now_loc == 25)
                        {
                            now_loc = 36;
                            Utils.delay(55, () -> {
                                multiShip[now_loc-1].setAnimation(animation4);
                            });
                        }
                        soundControl.sailingSoundFunc(view.getContext());
                        gif_popUp_controller.show_ship_sailing(dialog);
                        Utils.delay(55, () -> {
                            soundControl.fall.release();
                            if(now_loc <39)
                            { // dismiss dialog after few secs when location <39
                                dialog.dismiss();
                            }
                            multiShip[now_loc-1].setBackgroundResource(R.drawable.pirate_ship);
                            goldIsland_controller.show_num(num_now,now_loc+1);//show location number
                            if(previous_loc>0)
                            {
                                multiShip[previous_loc-1].setBackgroundResource(0);
                            }
                        });
                    }
                }


            }
        });


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
                        soundControl.RollSoundFun(GoldIslandActivity.this);
                        diceNumFinal = (int) (Math.random() * 6 + 1);
                        diceBut.setImageResource(images[diceNumFinal-1]);
                    });
                }

            }

        });

        // end roll
        return diceNumFinal;

    }
    void getShipBut()
    {
        loc_1 = findViewById(R.id.loc_1);
        loc_2 = findViewById(R.id.loc_2);
        loc_3 = findViewById(R.id.loc_3);
        loc_4 = findViewById(R.id.loc_4);
        loc_5 = findViewById(R.id.loc_6);
        loc_6 = findViewById(R.id.loc_7);
        loc_7 = findViewById(R.id.loc_8);
        loc_8 = findViewById(R.id.loc_9);
        loc_9 = findViewById(R.id.loc_10);
        loc_10 = findViewById(R.id.loc_11);
        loc_11 = findViewById(R.id.loc_12);
        loc_12 = findViewById(R.id.loc_13);
        loc_13 = findViewById(R.id.loc_14);
        loc_14 = findViewById(R.id.loc_15);
        loc_15 = findViewById(R.id.loc_16);
        loc_16 = findViewById(R.id.loc_17);
        loc_17 = findViewById(R.id.loc_18);
        loc_18 = findViewById(R.id.loc_19);
        loc_19 = findViewById(R.id.loc_20);
        loc_20 = findViewById(R.id.loc_21);
        loc_21 = findViewById(R.id.loc_22);
        loc_22 = findViewById(R.id.loc_23);
        loc_23 = findViewById(R.id.loc_24);
        loc_24 = findViewById(R.id.loc_25);
        loc_25 = findViewById(R.id.loc_26);
        loc_26 = findViewById(R.id.loc_27);
        loc_27 = findViewById(R.id.loc_28);
        loc_28 = findViewById(R.id.loc_29);
        loc_29 = findViewById(R.id.loc_30);
        loc_30 = findViewById(R.id.loc_31);
        loc_31 = findViewById(R.id.loc_32);
        loc_32 = findViewById(R.id.loc_33);
        loc_33 = findViewById(R.id.loc_34);
        loc_34 = findViewById(R.id.loc_35);
        loc_35 = findViewById(R.id.loc_36);
        loc_36 = findViewById(R.id.loc_37);
        loc_37 = findViewById(R.id.loc_38);
        loc_38 = findViewById(R.id.loc_39);
        loc_39 = findViewById(R.id.loc_40);
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