package com.example.smallgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.concurrent.atomic.AtomicInteger;

public class Game1MainActivity extends AppCompatActivity {
    Button replayBut;
    Button menuBut;
    GameplayGame1 gameplayGame1 = new GameplayGame1();
    public SoundControl soundControl = new SoundControl();
    /*
    image view
     */
    ImageView imgEgg1;
    ImageView imgEgg2;
    ImageView imgEgg3;
    ImageView imgEgg4;
    ImageView imgEgg5;
    ImageView imgEgg6;
    //
    ImageButton homeBut;
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
    int diceNumFinal ;
    //    ImageView birdnest[] = {imgEgg1,imgEgg3,imgEgg4,imgEgg5,imgEgg6,imgEgg2};//get id bird nests
    int ImageSwitcherImages[] ={R.drawable.game1_pic1};// create images for img switcher
    int switcherImageLength = ImageSwitcherImages.length;//length get
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_main);
        imageSwitcher = findViewById(R.id.imgswt);
        homeBut = findViewById(R.id.homeBut);
        onoffBut = findViewById(R.id.SonoffBut);
        diceBut = findViewById(R.id.dice);
        //* img egg
        imgEgg1 = findViewById(R.id.ans1);
        imgEgg2 = findViewById(R.id.ans2);
        imgEgg3 = findViewById(R.id.ans3);
        imgEgg4 = findViewById(R.id.ans4);
        imgEgg5 = findViewById(R.id.ans5);
        imgEgg6 = findViewById(R.id.ans6);
        ImageView imgViews[] = {imgEgg1,imgEgg3,imgEgg4,imgEgg5,imgEgg6,imgEgg2};
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

        replayBut = findViewById(R.id.replayBut);
        menuBut = findViewById(R.id.menuBut);
       // roll the dice
        diceBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int images[] = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
                int sec = 1;
                Utils.delay(sec, () -> {
                    for (int j = 0 ; j < 7;j++){
                        soundControl.RollSoundFun(Game1MainActivity.this);
                        diceNumFinal = (int) (Math.random() * 6 + 1);
                        diceBut.setImageResource(images[diceNumFinal-1]);
                    }
                });
            }
        });
        // end roll
        /*
        start clicking the eggs
         */
        grEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg1,Game1MainActivity.this);
                winAcOpen();
            }
        });
        grEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg2,Game1MainActivity.this);
                winAcOpen();
            }
        });
        grEgg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg3,Game1MainActivity.this);
                winAcOpen();
//                countNest++;
            }
        });
        grEgg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg4,Game1MainActivity.this);
                winAcOpen();
//                countNest++;
            }
        });
        grEgg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg5,Game1MainActivity.this);
                winAcOpen();
//                grEgg5.setBackgroundResource(R.drawable.xsign);
//                soundControl.RollSoundFun(Game1MainActivity.this);
            }
        });
        grEgg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg6,Game1MainActivity.this);
                winAcOpen();
            }
        });
        grEgg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,grEgg7,Game1MainActivity.this);
                winAcOpen();
            }
        });
        redEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,redEgg1,Game1MainActivity.this);
                winAcOpen();
            }
        });
        redEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,redEgg2,Game1MainActivity.this);
                winAcOpen();
            }
        });
        redEgg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,redEgg3,Game1MainActivity.this);
                winAcOpen();
            }
        });
        yellowEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,yellowEgg1,Game1MainActivity.this);
                winAcOpen();
            }
        });
        yellowEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,yellowEgg2,Game1MainActivity.this);
                winAcOpen();
            }
        });
        purEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,purEgg1,Game1MainActivity.this);
                winAcOpen();
            }
        });
        purEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,purEgg2,Game1MainActivity.this);
                winAcOpen();
            }
        });
        blueEgg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,blueEgg1,Game1MainActivity.this);
                winAcOpen();
            }
        });
        blueEgg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameplayGame1.gameOn(diceNumFinal,imgViews,blueEgg2,Game1MainActivity.this);
                winAcOpen();
            }
        });

//        int finalegg = gameplayGame1.countEggs;
//        if(finalegg == 6){
//            Intent intent = new Intent();
//            intent.setClass(Game1MainActivity.this,Winningactivity.class);
//            startActivity(intent);
//        }
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
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundControl.PopSoundFun(Game1MainActivity.this,homeBut);
                Intent intent = new Intent();
                intent.setClass(Game1MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        imageSwitcher.setImageResource(ImageSwitcherImages[switcherImageLength-1]);
        soundControl.OnOffFun(Game1MainActivity.this,onoffBut);


    }
    // if eggs get ==6 -> open winning activity
    protected  void winAcOpen(){
        if(gameplayGame1.countEggs == 6)
        {
            Intent intent = new Intent();
            intent.setClass(Game1MainActivity.this,Winningactivity.class);
            startActivity(intent);
        }
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
    public void stopMusic(){
        soundControl.player.stop();
    }
}