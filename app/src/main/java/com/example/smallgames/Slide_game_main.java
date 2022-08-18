package com.example.smallgames;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/*
 slide game main activity class
 */
public class Slide_game_main extends AppCompatActivity {
    Slide_game_control control = new Slide_game_control();
    int temmove =0;
    int diceNumFinal = 0;
    ImageButton onoffBut;
    ImageButton diceBut;
    SoundControl soundControl = new SoundControl();
    Button moveBut;
    // image character
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    ImageView img10;
    ImageView img11;
    ImageView img12;
    ImageView img13;
    ImageView img14;
    ImageView img15;
    ImageView img16;
    ImageView img17;
    ImageView img18;
    ImageView img19;
    ImageView img20;
    ImageView img21;
    ImageView img22;
    ImageView img23;
    ImageView img24;
    ImageView img25;
    ImageView img26;
    ImageView img27;
    ImageView img28;
    ImageView img29;
    ImageView img30;
        // each move have 2 variables left and right
    int tableRight[] = {1,1,6,8,5,4,6,3,5,3,10,2,5,1,9,9,10,9,7,4,8,3,1,10,6,1,8,4};
    int tableLeft[] = {0,3,2,3,2,1,0,4,8,9,3,5,3,8,10,6,8,3,9,7,5,8,5,6,5,2,9,2};
    //create counting move
    int move = 0;
    TextView question;
    TextView txtInput;

    ImageButton homebut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_game_main);
        onoffBut = findViewById(R.id.SonoffBut_game2);
        diceBut = findViewById(R.id.dice_game2);
        // questions
        question = findViewById(R.id.questionText);
        txtInput = findViewById(R.id.textInput);
        //get id move charaacter
        moveBut = findViewById(R.id.startMove);
        //animation set
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_to_left);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.animation_to_right);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.animation_go_up_left);
        Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.anim_go_up_left_2);
        Animation animation5 = AnimationUtils.loadAnimation(this, R.anim.anim_down_right);
        // get image view id for character
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);
        img10 = findViewById(R.id.img10);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        img13 = findViewById(R.id.img13);
        img14 = findViewById(R.id.img14);
        img15 = findViewById(R.id.img15);
        img16 = findViewById(R.id.img16);
        img17 = findViewById(R.id.img17);
        img18 = findViewById(R.id.img18);
        img19 = findViewById(R.id.img19);
        img20 = findViewById(R.id.img20);
        img21 = findViewById(R.id.img21);
        img22 = findViewById(R.id.img22);
        img23 = findViewById(R.id.img23);
        img24 = findViewById(R.id.img24);
        img25 = findViewById(R.id.img25);
        img26 = findViewById(R.id.img26);
        img27 = findViewById(R.id.img27);
        img28 = findViewById(R.id.img28);
        img29 = findViewById(R.id.img29);
        img30 = findViewById(R.id.img30);

        homebut = findViewById(R.id.homeBut);
        ImageView table[] = {img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20,img21,img22,img23,img24,img25,img26,img27,img28,img29,img30};
        img1.setImageResource(R.drawable.mario);

        // dice button controll
        // roll the dice
        diceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int images[] = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
                int sec = 1;
                for (int j = 0 ; j < 7;j++){
                    Utils.delay(sec, () -> {
                        soundControl.RollSoundFun(Slide_game_main.this);
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

        // end roll

        // controll character movement
        /*
        start code
         */
        moveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temmove = temmove + diceNumFinal;
//                txtInput.setText(" "+temmove);
                if(temmove > 29)
                {
                    temmove -= diceNumFinal;
                    move -= diceNumFinal;
                }
                if(temmove == 29)
                {
                    table[temmove].setImageResource(R.drawable.mario);
                    table[temmove].setImageResource(R.drawable.mario);
                    Intent intent = new Intent();
                    intent.setClass(Slide_game_main.this, Winning_activity_Slide.class);
                    startActivity(intent);
                }
                else if( temmove <29)
                {
                    table[0].setImageResource(0);
                    for (int i = move+1;i<=temmove+1;i++)
                    {
                        //case 1
                        if( (i>=1 && i<=5) || (i>=11 && i<=15) ||(i>=21 && i<=25))
                        {
                            table[i-1].setImageResource(0); // important bcs delete all old move pic
                            table[3].setImageResource(0);//delete pic from previous lader move
                            table[12].setImageResource(0);//delete pic from previous lader move
                            table[14].setImageResource(0);//delete pic from previous lader move
                            table[23].setImageResource(0);//delete pic from previous lader move
                            table[18].setImageResource(0);//delete pic from previous slide move
                            table[9].setImageResource(0);//delete pic from previous slide move
                            table[27].setImageResource(0);//delete pic from previous slide move
                            table[16].setImageResource(0);//delete pic from previous slide move
                            if(i==temmove+1)
                            {
                                soundControl.runSoundFun(Slide_game_main.this);
                                int previousmove = i -2;
                                // release fall sound
                                soundControl.run.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        mediaPlayer.release();
                                    }
                                });
                                // when character go to lader -> go up
                                if(temmove==3)
                                {
                                    table[i-1].setImageResource(R.drawable.mario);
                                    table[i-1].startAnimation(animation);
                                    table[i-2].setImageResource(0);
//                                    table[i-1].startAnimation(animation4);
                                    temmove +=11;
                                    move+=(10);
                                    int sec = 6;
                                    int finalTemmove = temmove;
                                    Utils.delay(sec, () -> {
                                        table[previousmove+1].setImageResource(0);
                                        table[previousmove].setImageResource(0);
                                        soundControl.upSoundFun(Slide_game_main.this);
                                        table[finalTemmove].setImageResource(R.drawable.mario);
                                        table[finalTemmove].startAnimation(animation3);
                                        // check clicking ans
                                        control.checkAns(question,txtInput,temmove,tableRight,tableLeft,Slide_game_main.this,view.getContext());
                                        // release up sound
                                        soundControl.up.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                            @Override
                                            public void onCompletion(MediaPlayer mediaPlayer) {
                                                mediaPlayer.release();
                                            }
                                        });
                                    });

                                }
                                if(temmove==12)
                                {
                                    table[i-1].setImageResource(R.drawable.mario);
                                    table[i-1].startAnimation(animation);
                                    table[i-2].setImageResource(0);
//                                    table[i-1].startAnimation(animation4);
                                    temmove+=11;
                                    move+=(11);
                                    int sec = 6;
                                    int finalTemmove = temmove;
                                    Utils.delay(sec, () -> {
                                        table[previousmove+1].setImageResource(0);
                                        table[previousmove].setImageResource(0);
                                        soundControl.upSoundFun(Slide_game_main.this);
                                        table[finalTemmove].setImageResource(R.drawable.mario);
                                        table[finalTemmove].startAnimation(animation3);
                                        // check ans
                                        control.checkAns(question,txtInput,temmove,tableRight,tableLeft,Slide_game_main.this,view.getContext());
                                        // release up sound
                                        soundControl.up.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                            @Override
                                            public void onCompletion(MediaPlayer mediaPlayer) {
                                                mediaPlayer.release();
                                            }
                                        });
                                    });

                                }
                                else
                                {
                                    soundControl.runSoundFun(Slide_game_main.this);
                                    table[i-1].startAnimation(animation);
                                    table[i-1].setImageResource(R.drawable.mario);
                                    if(move > 3)
                                    {
                                        table[move-1].setImageResource(0); // important bcs delete all old move pic
                                        table[move-2].setImageResource(0);
                                        table[move-3].setImageResource(0);
                                    }

                                    table[i-2].setImageResource(0); // important bcs delete all old move pic
                                    move+=diceNumFinal;
                                    control.checkAns(question,txtInput,temmove,tableRight,tableLeft,Slide_game_main.this,view.getContext());
                                    // release run sound
                                    soundControl.run.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mediaPlayer) {
                                            mediaPlayer.release();
                                        }
                                    });
                                }
                            }

                        }
                        // case2
                        else if( (i>=6 && i<=10) || (i>=16 && i<=20) ||(i>=25 && i<=30))
                        {
                            table[i-1].setImageResource(0); // important bcs delete all old move pic
                            table[3].setImageResource(0);//delete pic from previous lader move
                            table[12].setImageResource(0);//delete pic from previous lader move
                            table[14].setImageResource(0);//delete pic from previous lader move
                            table[23].setImageResource(0);//delete pic from previous lader move
                            table[18].setImageResource(0);//delete pic from previous slide move
                            table[9].setImageResource(0);//delete pic from previous slide move
                            table[27].setImageResource(0);//delete pic from previous slide move
                            table[16].setImageResource(0);//delete pic from previous slide move
                            if(i==temmove+1){
                                soundControl.runSoundFun(Slide_game_main.this);
                                int previousmove = i-2;
                                // when character go to slide -> go down
                                if(temmove==18)
                                {
                                    table[i-1].setImageResource(R.drawable.mario2);
                                    table[i-1].startAnimation(animation4);
                                    table[i-2].setImageResource(0);
//                                    table[i-1].startAnimation(animation4);
                                    temmove -=9;
                                    move-=(9);
                                    int sec = 4;
                                    int finalTemmove = temmove;
                                    Utils.delay(sec, () -> {
                                        table[previousmove+1].setImageResource(0);
                                        table[previousmove].setImageResource(0);
                                        soundControl.fallSoundFun(Slide_game_main.this);
                                        table[finalTemmove].setImageResource(R.drawable.mario2);
                                        table[finalTemmove].startAnimation(animation4);
                                        // check answer
                                        control.checkAns(question,txtInput,temmove,tableRight,tableLeft,Slide_game_main.this,view.getContext());
                                        // release fall sound
                                        soundControl.fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                            @Override
                                            public void onCompletion(MediaPlayer mediaPlayer) {
                                                mediaPlayer.release();
                                            }
                                        });
                                    });

                                }
                                if(temmove==27)
                                {
                                    table[i-1].setImageResource(R.drawable.mario2);
                                    table[i-1].startAnimation(animation4);
                                    table[i-2].setImageResource(0);
//                                    table[i-1].startAnimation(animation4);
                                    temmove -=11;
                                    move-=(11);
                                    int sec = 4;
                                    int finalTemmove = temmove;
                                    Utils.delay(sec, () -> {
                                        table[previousmove+1].setImageResource(0);
                                        table[previousmove].setImageResource(0);
                                        soundControl.fallSoundFun(Slide_game_main.this);
                                        table[finalTemmove].setImageResource(R.drawable.mario);
                                        table[finalTemmove].startAnimation(animation5);
                                        // check answer
                                        control.checkAns(question,txtInput,temmove,tableRight,tableLeft,Slide_game_main.this,view.getContext());
                                        // release fall sound
                                        soundControl.fall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                            @Override
                                            public void onCompletion(MediaPlayer mediaPlayer) {
                                                mediaPlayer.release();
                                            }
                                        });
                                    });

                                }
                                else
                                {
                                    soundControl.runSoundFun(Slide_game_main.this);
                                    table[i-1].startAnimation(animation2);
                                    table[i-1].setImageResource(R.drawable.mario2);
                                    table[i-2].setImageResource(0);
                                    if(move >3)
                                    {
                                        table[move-1].setImageResource(0); // important bcs delete all old move pic
                                        table[move-2].setImageResource(0);
                                        table[move-3].setImageResource(0);
                                    }
                                    move+=diceNumFinal;
                                    // check answer
                                    control.checkAns(question,txtInput,temmove,tableRight,tableLeft,Slide_game_main.this,view.getContext());
                                    // release fall sound
                                    soundControl.run.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mediaPlayer) {
                                            mediaPlayer.release();
                                        }
                                    });
                                }
                            }
                        }

                    }
                }

            }
        });
        /*
        end code
         */
        // control sound button
        soundControl.OnOffFun(Slide_game_main.this,onoffBut);
        homebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(Slide_game_main.this,homebut);
                Intent intent = new Intent();
                intent.setClass(Slide_game_main.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // end controll sound but
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