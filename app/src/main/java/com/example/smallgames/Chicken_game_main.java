package com.example.smallgames;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Chicken_game_main extends AppCompatActivity {
    Chicken_game_control controller = new Chicken_game_control();
    ImageButton diceBut;
    SoundControl soundControl = new SoundControl();
    int diceNumFinal=0;
    ImageButton onoffBut;
    ImageButton homeBut;
    Button moveBut;
    TextView questionT;
    int temmove = 0;

    // moves button
    ImageButton move0;
    ImageButton move1;
    ImageButton move2;
    ImageButton move3;
    ImageButton move4;
    ImageButton move5;
    ImageButton move6;
    ImageButton move7;
    ImageButton move8;
    ImageButton move9;
    ImageButton move10;
    ImageButton move11;
    ImageButton move12;
    ImageButton move13;
    ImageButton move14;
    ImageButton move15;
    ImageButton move16;
    ImageButton move17;
    ImageButton move18;
    ImageButton move19;
    ImageButton move20;
    ImageButton move21;
    // chickens button
    ImageButton chick1;
    ImageButton chick2;
    ImageButton chick3;
    ImageButton chick4;
    ImageButton chick5;
    ImageButton chick6;
    ImageButton chick7;
    ImageButton chick8;
    ImageButton chick9;
    ImageButton chick10;
    // chicken get
    ImageView get_1;
    ImageView get_2;
    ImageView get_3;
    ImageView get_4;
    ImageView get_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_game_main);
        diceBut = findViewById(R.id.dice);
        onoffBut = findViewById(R.id.SonoffBut_game2);
        homeBut = findViewById(R.id.homeBut);
        moveBut = findViewById(R.id.moveBut);
        questionT = findViewById(R.id.questionText);
/// move buttons id
        move0 = findViewById(R.id.move_0);
        move1 = findViewById(R.id.move_1);
        move2 = findViewById(R.id.move_2);
        move3 = findViewById(R.id.move_3);
        move4 = findViewById(R.id.move_4);
        move5 = findViewById(R.id.move_5);
        move6 = findViewById(R.id.move_6);
        move7 = findViewById(R.id.move_7);
        move8 = findViewById(R.id.move_8);
        move9 = findViewById(R.id.move_9);
        move10 = findViewById(R.id.move_10);
        move11 = findViewById(R.id.move_11);
        move12 = findViewById(R.id.move_12);
        move13 = findViewById(R.id.move_13);
        move14 = findViewById(R.id.move_14);
        move15 = findViewById(R.id.move_15);
        move16 = findViewById(R.id.move_16);
        move17 = findViewById(R.id.move_17);
        move18 = findViewById(R.id.move_18);
        move19 = findViewById(R.id.move_19);
        move20 = findViewById(R.id.move_20);
        move21 = findViewById(R.id.move_21);
/// chickens ids
        chick1 = findViewById(R.id.chick_1);
        chick2 = findViewById(R.id.chick_2);
        chick3 = findViewById(R.id.chick_3);
        chick4 = findViewById(R.id.chick_4);
        chick5 = findViewById(R.id.chick_5);
        chick6 = findViewById(R.id.chick_6);
        chick7 = findViewById(R.id.chick_7);
        chick8 = findViewById(R.id.chick_8);
        chick9 = findViewById(R.id.chick_9);
        chick10 = findViewById(R.id.chick_10);
        // chickens u get ids
        get_1 = findViewById(R.id.get_1);
        get_2 = findViewById(R.id.get_2);
        get_3 = findViewById(R.id.get_3);
        get_4 = findViewById(R.id.get_4);
        get_5 = findViewById(R.id.get_5);

        ImageButton moveButs[]={ move0,move1,move2,move3,move4,move5,move6,move7,move8,move9,move10,move11,move12,move13,move14,move15,move16,move17,move18,move19,move20,move21};
        ImageButton chickens[] = {chick1,chick2,chick3,chick4,chick5,chick6,chick7,chick8,chick9,chick10};
        ImageView gets[] = {get_1,get_2,get_3,get_4,get_5};
        int chick_values[]={7,1,4,2,5,3,8,6,9,0};
        /*
        dice roll controll
         */
        diceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int images[] = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
                int sec = 1;
                for (int j = 0 ; j < 7;j++){
                    Utils.delay(sec, () -> {
                        soundControl.RollSoundFun(Chicken_game_main.this);
                        diceNumFinal = (int) (Math.random() * 6 + 1);
//                        question.setText(" "+diceNumFinal);
                        diceBut.setImageResource(images[diceNumFinal-1]);
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
        end roll
         */
        /*
        move button controll
         */
        move0.setImageResource(R.drawable.mario);
        moveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int previous = temmove;
                if((temmove+diceNumFinal)==0)
                {

                }
                else
                {
                    if((temmove + diceNumFinal)>21)
                    {
                        temmove += diceNumFinal;
                        temmove -= 21;
                        controller.setString(questionT,temmove,moveButs,previous,Chicken_game_main.this,view.getContext());
                    }
                    else
                    {
                        temmove += diceNumFinal;
                        controller.setString(questionT,temmove,moveButs,previous,Chicken_game_main.this,view.getContext());
                    }
                }


            }
        });
        /*
        chickens clicking control
         */
        for(int i=0;i<10;i++)
        {
            int temi = i;
            chickens[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    controller.checkAns(view.getContext(),temmove,chick_values[temi],Chicken_game_main.this,chickens[temi],gets,temi);
                    if(controller.get_count == 5)
                    {
                        Intent intent = new Intent();
                        intent.setClass(Chicken_game_main.this, Winning_activity_chicken.class);
                        startActivity(intent);
                    }
                }
            });
        }
        // sound controll but
        soundControl.OnOffFun(Chicken_game_main.this,onoffBut);
        // home navigate button
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(Chicken_game_main.this,homeBut);
                Intent intent = new Intent();
                intent.setClass(Chicken_game_main.this, MainActivity.class);
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