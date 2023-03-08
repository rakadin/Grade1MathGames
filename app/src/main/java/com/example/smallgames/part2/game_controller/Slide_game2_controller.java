package com.example.smallgames.part2.game_controller;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smallgames.R;
import com.example.smallgames.SoundControl;

public class Slide_game2_controller {
    // each move have 2 variables left and right
    final int right[] = {0,11,31,93,17,14,9,13,49,18,31,29,15,26,22,19,28,12,14,35,26,59,38,18,80,13,17,17,36,0};
    final int left[] = {0,10,22,99,71,41,12,30,47,40,42,88,55,62,27,34,65,9,20,87,51,55,83,13,90,4,20,53,89,0};
    int check =0;
    SoundControl soundControl = new SoundControl();
    public void getNum(TextView top, TextView bot, int location, int previous_loc, ImageView moves[], Context context,Activity main)
    {
        //animation set
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.animation_to_left);
        Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.animation_to_right);
        Animation animation3 = AnimationUtils.loadAnimation(context, R.anim.animation_go_up_left);
        Animation animation4 = AnimationUtils.loadAnimation(context, R.anim.animation_go_up_right);
        Animation animation5 = AnimationUtils.loadAnimation(context, R.anim.anim_down_right);
        Animation animation6 = AnimationUtils.loadAnimation(context, R.anim.anim_down_left);
        Animation bounce = AnimationUtils.loadAnimation(context, R.anim.bounce_animation);
        top.setText(""+right[location]);
        bot.setText(""+left[location]);
        if(location>=0 && location <=4 ||location>=10 && location <=14 || location>=20 && location <=24)
        {
            moves[location].setImageResource(R.drawable.mario);
            moves[previous_loc].setImageResource(0);
            if(location == 14 && previous_loc == 3)// go to 1 ladder
            {
                moves[location].setAnimation(animation3);
                soundControl.upSoundFun(main);
            }
            else
            {
                moves[location].setAnimation(animation);
                soundControl.runSoundFun(main);
            }

        }
        if(location>=5 && location <=9 ||location>=15 && location <=19 || location>=25 && location <=30)
        {
            moves[location].setImageResource(R.drawable.mario2);
            // meet the ladder
            if((location == 19 && previous_loc == 8) || (location == 26 && previous_loc ==17) ||(location == 9 && previous_loc == 18) || (location == 16 && previous_loc == 27))// go to 2 ladder
            {
                if(location == 19)
                {
                    moves[location].setAnimation(animation4);
                    soundControl.upSoundFun(main);
                    moves[previous_loc].setImageResource(0);
                }
                if(location == 26)
                {
                    moves[location].setAnimation(animation3);
                    moves[previous_loc].setImageResource(0);
                    soundControl.upSoundFun(main);
                }
                // meet the slide go down
                if(location == 9)
                {
                    moves[location].setAnimation(animation6);
                    soundControl.fallSoundFun(main);
                    moves[previous_loc].setImageResource(0);
                }
                if(location == 16)
                {
                    moves[location].setAnimation(animation5);
                    moves[previous_loc].setImageResource(0);
                    soundControl.fallSoundFun(main);
                }
            }
            else
            {
                moves[previous_loc].setImageResource(0);
                moves[location].setAnimation(animation2);
                soundControl.runSoundFun(main);
            }

        }
    }
    public void checkAns(TextView top, TextView bot, int move, Activity main, Context context)
    {
        if(move >0)
        {
            top.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(left[move] < right[move])
                    {
                        soundControl.correctSoundFun(main);
                        Toast.makeText(context,"Đúng rồi!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        soundControl.wrongSoundFun(main);
                        Toast.makeText(context,"Sai rồi!",Toast.LENGTH_LONG).show();
                    }
                }

            });
            bot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(left[move] > right[move])
                    {
                        soundControl.correctSoundFun(main);
                        Toast.makeText(context,"Đúng rồi!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        soundControl.wrongSoundFun(main);
                        Toast.makeText(context,"Sai rồi!",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        else
        {

        }
    }
}
