package com.example.smallgames;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
/*
fishing game main activity
 */
public class Fishing_game_main extends AppCompatActivity {
    ImageButton onoffBut;
    ImageButton diceButA;
    ImageButton diceButB;
    ImageButton homeBut;
    TextView valueB;
    TextView valueA;
    // dices values
    int diceValueA = 1;
    int diceValueB = 1;
    int fishSum =0;
    // get fish click id
    ImageButton fish1;
    ImageButton fish2;
    ImageButton fish3;
    ImageButton fish4;
    ImageButton fish5;
    ImageButton fish6;
    ImageButton fish7;
    ImageButton fish8;
    ImageButton fish9;
    ImageButton fish10;
    ImageButton fish11;

    // get fish to tank id
    ImageView get1;
    ImageView get2;
    ImageView get3;
    ImageView get4;
    ImageView get5;


    SoundControl soundControl = new SoundControl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishing_game_main);
        //get id
        // onoffBut
        onoffBut = findViewById(R.id.SonoffBut_game2);
        //dices id
        diceButA = findViewById(R.id.dice);
        diceButB = findViewById(R.id.dice2);
        // home id
        homeBut = findViewById(R.id.homeBut);
        // value text id
        valueB = findViewById(R.id.rightText);
        valueA = findViewById(R.id.leftText);
        // get fishs id
        fish1 = findViewById(R.id.fish1);
        fish2 = findViewById(R.id.fish2);
        fish3 = findViewById(R.id.fish3);
        fish4 = findViewById(R.id.fish4);
        fish5 = findViewById(R.id.fish5);
        fish6 = findViewById(R.id.fish6);
        fish7 = findViewById(R.id.fish7);
        fish8 = findViewById(R.id.fish8);
        fish9 = findViewById(R.id.fish9);
        fish10 = findViewById(R.id.fish10);
        fish11= findViewById(R.id.fish11);
        ImageButton fishs[] = {fish1,fish2,fish3,fish4,fish5,fish6,fish7,fish8,fish9,fish10,fish11};
        int GET_variable[]= {1,5,8,7,0,4,10,2,6,3,9}; // variable of fish
        int imgFish_id[] = {R.drawable.pink_1,R.drawable.blue_5,R.drawable.green_8,R.drawable.yellow_7,R.drawable.purple_0,R.drawable.yellow_4,R.drawable.red_10,R.drawable.green_2,R.drawable.red_6,R.drawable.red_3,R.drawable.green_9};
        // get fish catch id
        get1 = findViewById(R.id.get1);
        get2 = findViewById(R.id.get2);
        get3 = findViewById(R.id.get3);
        get4 = findViewById(R.id.get4);
        get5 = findViewById(R.id.get5);
        ImageView gets[] = {get1,get2,get3,get4,get5};
        int variable2[] = {0,1,2,3,4,5};
        int variable1[] = {5,6,7,8,9,10};
        // animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fish_animation);
        // dice roll controll
        /*
        dice B
         */
        final int[] temB = new int[1];
        final int temA;
        diceButB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int images[] = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};

                int sec = 1;

                for (int j = 0 ; j < 7;j++){
                    int temJ = j;
                    Utils.delay(sec, () -> {
                        soundControl.RollSoundFun(Fishing_game_main.this);
                        diceValueB = (int) (Math.random() * 6 + 1);
//                        question.setText(" "+diceNumFinal);
                        diceButB.setImageResource(images[diceValueB-1]);
                        valueB.setText(" B: "+variable1[diceValueB-1]);
                        // release roll sound
                        soundControl.rollSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.release();
                            }
                        });
                    });
                }
            }
        });

        // dice A
        diceButA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get img id[]
                int images[] = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
                int sec = 1;
                for (int j = 0 ; j < 7;j++){
                    Utils.delay(sec, () -> {
                        soundControl.RollSoundFun(Fishing_game_main.this);
                        diceValueA = (int) (Math.random() * 6 + 1);
//                        question.setText(" "+diceNumFinal);
                        diceButA.setImageResource(images[diceValueA-1]);
                        valueA.setText(" A: "+variable2[diceValueA-1]);
                        // release roll sound
                        soundControl.rollSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.release();
                            }
                        });
                    });
                }
            }
        });
        /*
        end roll dices
         */
        /*
        gameplay control
         */
        /*
        controller of the game
         */
        for (int i = 0 ; i < 11; i++)
        {
            int tem = i;
            fishs[tem].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int ans = variable1[diceValueB-1] - variable2[diceValueA-1];
                    if(ans == GET_variable[tem])
                    {
                        gets[fishSum].setImageResource(imgFish_id[tem]);
                        fishs[tem].startAnimation(animation);
                        soundControl.correctSoundFun(Fishing_game_main.this);
                        fishSum++;
                        if(fishSum == 5)
                        {
                            soundControl.hooraySoundFun(Fishing_game_main.this);
                            Utils.delay(50, () -> {
                                Intent intent = new Intent();
                                intent.setClass(Fishing_game_main.this, Winning_activity_fish_catch.class);
                                startActivity(intent);
                            });

                        }
                        soundControl.correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.release();
                            }
                        });
                    }
                    else
                    {
                        soundControl.wrongSoundFun(Fishing_game_main.this);
                        soundControl.wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.release();
                            }
                        });
                    }
                }
            });
        }

        // sound controll but
        soundControl.OnOffFun(Fishing_game_main.this,onoffBut);
        // home navigate button
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(Fishing_game_main.this,homeBut);
                Intent intent = new Intent();
                intent.setClass(Fishing_game_main.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundControl.player.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        soundControl.player.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundControl.player.stop();
    }
}