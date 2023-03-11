package com.example.smallgames.part2.game_acitivity;

import static com.example.smallgames.R.drawable.sound_on;
import static com.example.smallgames.R.drawable.xsign;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.smallgames.R;
import com.example.smallgames.SoundControl;
import com.example.smallgames.Utils;
import com.example.smallgames.part2.Part2_Homepage_Activity;
import com.example.smallgames.part2.game_controller.Fishing_2_Controller;
import com.example.smallgames.part2.game_controller.Gif_PopUp_Controller;
import com.example.smallgames.part2.game_controller.Toy_Machine_Controller;
import com.example.smallgames.part2.winning_activity.Winning_activity_fishing_2;
import com.example.smallgames.part2.winning_activity.Winning_activity_toy_machine;

import pl.droidsonroids.gif.GifImageView;

public class Toy_Machine_Activity extends AppCompatActivity {
    ImageButton soundBut,homeBut,diceBut;
    Button mathBut;
    TextView question;
    GifImageView claw;
    Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    SoundControl soundControl = new SoundControl();
    Toy_Machine_Controller controller = new Toy_Machine_Controller();
    int diceNumFinal =0;
    int count =0;
    Dialog dialog;
    ImageButton toy_1,toy_2,toy_3,toy_4,toy_5,toy_6,toy_7,toy_8,toy_9,toy_10,toy_11,toy_12;
    int ans =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_toy_machine);
        getSupportActionBar().hide();
        dialog = new Dialog(Toy_Machine_Activity.this);
        soundBut = findViewById(R.id.SonoffBut);
        homeBut = findViewById(R.id.homeBut);
        diceBut = findViewById(R.id.dice);
        claw = findViewById(R.id.claw_gif);
        mathBut = findViewById(R.id.mathBut);
        question = findViewById(R.id.questionText);
        Animation animation_claw = AnimationUtils.loadAnimation(this, R.anim.animation_claw);
        claw.setAnimation(animation_claw);
        getToyID();
        ImageButton toys[] ={ toy_1,toy_2,toy_3,toy_4,toy_5,toy_6,toy_7,toy_8,toy_9,toy_10,toy_11,toy_12};
        ImageButton toys2[] ={ toy_1,toy_2,toy_3,toy_4,toy_5,toy_6,toy_7,toy_8,toy_9,toy_10,toy_11,toy_12};
        // clicking toys
        for(int i=0;i<12;i++)
        {
            int temi = i;
            toys[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(diceNumFinal ==0)// make sure roll the dice first
                    {
                        Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        gif_popUp_controller.show_claw_machine(dialog);
                        Utils.delay(60, () -> {
                            dialog.dismiss();
                            boolean tem = controller.checkAns(ans,temi);
                            if(tem == true)
                            {
                                gif_popUp_controller.show_yes_penguin(dialog);
                                count ++;
                                soundControl.correctSoundFun(Toy_Machine_Activity.this);
                                toys2[temi].setImageResource(xsign);
                                toys2[temi].setClickable(false);
                                Utils.delay(50, () -> {
                                    dialog.dismiss();
                                });
                                if(count == 6)//get 6 toys -> win
                                {
                                    gif_popUp_controller.show_yes_penguin(dialog);
                                    soundControl.hooraySoundFun(Toy_Machine_Activity.this);
                                    Utils.delay(50, () -> {
                                        winner();
                                    });
                                }
                            }
                            else
                            {
                                gif_popUp_controller.show_no_penguin(dialog);
                                soundControl.wrongSoundFun(Toy_Machine_Activity.this);
                                Utils.delay(50, () -> {
                                    dialog.dismiss();
                                });
                            }
                        });
                    }


                }
            });
        }
        setHomeBut();
        rollDice();
        setMathBut();
        // set sound but func
        soundControl.OnOffFun(Toy_Machine_Activity.this,soundBut);
    }
    void getToyID()
    {
        toy_1 = findViewById(R.id.toy_1);
        toy_2 = findViewById(R.id.toy_2);
        toy_3 = findViewById(R.id.toy_3);
        toy_4 = findViewById(R.id.toy_4);
        toy_5 = findViewById(R.id.toy_5);
        toy_6 = findViewById(R.id.toy_6);
        toy_7 = findViewById(R.id.toy_7);
        toy_8 = findViewById(R.id.toy_8);
        toy_9 = findViewById(R.id.toy_9);
        toy_10 = findViewById(R.id.toy_10);
        toy_11 = findViewById(R.id.toy_11);
        toy_12 = findViewById(R.id.toy_12);
    }
    void winner()
    {
        Intent intent = new Intent();
        intent.setClass(Toy_Machine_Activity.this, Winning_activity_toy_machine.class);
        startActivity(intent);
    }
    //math but func
    void setMathBut()
    {
        mathBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    question.setText("49-"+diceNumFinal);
                    ans = 49-diceNumFinal;
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
                intent.setClass(Toy_Machine_Activity.this, Part2_Homepage_Activity.class);
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
                        soundControl.RollSoundFun(Toy_Machine_Activity.this);
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