package com.example.smallgames;

import static com.example.smallgames.R.drawable.sound_off;
import static com.example.smallgames.R.drawable.sound_on;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class Game1MainActivity extends AppCompatActivity {
    RollDice rollDice = new RollDice();
    SoundControl soundControl = new SoundControl();
    ImageButton onoffBut;
    ImageButton diceBut;
    //* button
    Button grEgg1;
    Button grEgg2;
    Button grEgg3;
    Button grEgg4;
    Button grEgg5;
    Button grEgg6;
    Button grEgg7;
    Button redEgg1;
    Button redEgg2;
    Button redEgg3;
    Button yellowEgg1;
    Button yellowEgg2;
    Button purEgg1;
    Button purEgg2;
    Button blueEgg1;
    Button blueEgg2;
    //end egg

    ImageSwitcher imageSwitcher;
    int ImageSwitcherImages[] ={R.drawable.game1_pic1};// create images for img switcher
    int switcherImageLength = ImageSwitcherImages.length;//length get
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_main);
        imageSwitcher = findViewById(R.id.imgswt);
        onoffBut = findViewById(R.id.SonoffBut);
        diceBut = findViewById(R.id.dice);
        //get eggbut id
        grEgg1 = findViewById(R.id.grEgg1);
        grEgg2 = findViewById(R.id.grEgg2);
        grEgg3 = findViewById(R.id.grEgg3);
        grEgg4 = findViewById(R.id.grEgg4);
        grEgg5 = findViewById(R.id.grEgg5);
        grEgg6 = findViewById(R.id.grEgg6);
        grEgg7 = findViewById(R.id.grEgg7);
        redEgg1 = findViewById(R.id.redEgg1);
        redEgg2 = findViewById(R.id.redEgg2);
        redEgg3 = findViewById(R.id.redEgg3);
        yellowEgg1 = findViewById(R.id.yellowEgg1);
        yellowEgg2 = findViewById(R.id.yellowEgg2);
        purEgg1 = findViewById(R.id.purEgg1);
        purEgg2 = findViewById(R.id.purEgg2);
        blueEgg1 = findViewById(R.id.blueEgg1);
        blueEgg2 = findViewById(R.id.blueEgg2);

        grEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        grEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        grEgg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        grEgg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        grEgg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        grEgg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        grEgg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        grEgg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        redEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        redEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        redEgg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        yellowEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        yellowEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        purEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        purEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        blueEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        blueEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(getApplicationContext());
//                switcherImageView.setLayoutParams(new ViewGroup.LayoutParams());
                switcherImageView.setImageResource(ImageSwitcherImages[switcherImageLength-1]);
                //switcherImageView.setMaxHeight(100);
                return switcherImageView;
            }
        });
        imageSwitcher.setImageResource(ImageSwitcherImages[switcherImageLength-1]);
        soundControl.OnOffFun(Game1MainActivity.this,onoffBut);
        rollDice.roll(diceBut,Game1MainActivity.this);

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