package com.example.smallgames;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Slide_game_control  {
    // each move have 2 variables left and right
    final int right[] = {0,1,1,6,8,5,4,6,3,5,3,10,2,5,1,9,9,10,9,7,4,8,3,1,10,6,1,8,4,0};
    final int left[] = {0,0,3,2,3,2,1,0,4,8,9,3,5,3,8,10,6,8,3,9,7,5,8,5,6,5,2,9,2,0};
    int check =0;
    SoundControl soundControl = new SoundControl();
    public void getNum(TextView top, TextView bot, int location, int previous_loc, ImageView moves[], Context context, Activity main)
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
            else if(location == 23 && previous_loc == 12)// go to 2 ladder
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
            if((location == 9 && previous_loc == 18) || (location == 16 && previous_loc ==27) )// go to 2 slider
            {
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
