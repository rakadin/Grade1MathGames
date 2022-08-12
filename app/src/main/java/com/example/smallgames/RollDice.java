package com.example.smallgames;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class RollDice extends AppCompatActivity {
    protected int randomNum;
    protected SoundControl soundControl = new SoundControl();
    protected void roll(ImageButton imgBut, Activity main)
    {
        int images[] = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};
        imgBut.setOnClickListener(view -> {

            int sec = 1;
//            for(int i =0;i<15;i++)
//            {
                Utils.delay(sec, () -> {
                    for (int j = 0 ; j < 5;j++){
                        soundControl.RollSoundFun(main);
                        int random = (int) (Math.random()*6+1);

                        imgBut.setImageResource(images[random-1]);
                        randomNum = random;
                    }

                });
//            }
        });
    }
}
