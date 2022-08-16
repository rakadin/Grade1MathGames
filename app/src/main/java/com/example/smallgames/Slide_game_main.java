package com.example.smallgames;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

public class Slide_game_main extends AppCompatActivity {
    int diceNumFinal = 0;
    ImageButton onoffBut;
    ImageButton diceBut;
    TextView question;
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

//    ImageView table[] = {img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20,img21,img22,img23,img24,img25,img26,img27,img28,img29,img30};
    //create counting move
    int move = 0;
    TextInputEditText txtInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_game_main);
        onoffBut = findViewById(R.id.SonoffBut_game2);
        diceBut = findViewById(R.id.dice_game2);
        question = findViewById(R.id.questionText);
        //get id move charaacter
        moveBut = findViewById(R.id.startMove);
        //animation set
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_to_left);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.animation_to_right);
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
        txtInput = findViewById(R.id.textInput);
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
                        question.setText(" "+diceNumFinal);
                        diceBut.setImageResource(images[diceNumFinal-1]);
                    });
                }

            }

        });
        // end roll
        // controll character movement
        moveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temmove = move + diceNumFinal;
                txtInput.setText(" "+temmove);
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
                    intent.setClass(Slide_game_main.this, Winningactivity.class);
                    startActivity(intent);
                }
                else if( temmove <29)
                {
                    for (int i = move+1;i<=temmove+1;i++)
                    {
                        if( (i>=1 && i<=5) || (i>=11 && i<=15) ||(i>=21 && i<=25))
                        {
                            table[i-1].startAnimation(animation);
                            table[i-1].setImageResource(R.drawable.mario);
                            table[i-1].setImageResource(0);
                            if(i==temmove+1){
                                soundControl.runSoundFun(Slide_game_main.this);
                                table[i-1].setImageResource(R.drawable.mario);
                            }
                        }
                        else if( (i>=6 && i<=10) || (i>=16 && i<=20) ||(i>=25 && i<=30))
                        {

                            table[i-1].startAnimation(animation2);
                            table[i-1].setImageResource(R.drawable.mario2);
                            table[i-1].setImageResource(0);
                            if(i==temmove+1){
                                soundControl.runSoundFun(Slide_game_main.this);
                                table[i-1].setImageResource(R.drawable.mario2);
                            }
                        }

                    }
                }
                move+=diceNumFinal;
            }
        });
        // control sound button
        soundControl.OnOffFun(Slide_game_main.this,onoffBut);
        // end controll sound but
    }
}