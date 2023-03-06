package com.example.smallgames.part2.game_controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smallgames.R;
import com.example.smallgames.SoundControl;
import com.example.smallgames.Utils;
import com.example.smallgames.part2.game_acitivity.GoldIslandActivity;
import com.example.smallgames.part2.winning_activity.Winning_activity_fishing_2;

public class Fishing_2_Controller extends AppCompatActivity {
    private int count =0;
    static final int move_num[] = {0,76,58,93,76,14,58,42,93,14,42,93,58,76,42,14};


    public int getnum(TextView textView, int location, int previous_loc, ImageButton moves[], Context context)
    {
        Animation animation1 = AnimationUtils.loadAnimation(context, R.anim.mario_up_top);
        Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.mario_right_to_left);
        Animation animation3 = AnimationUtils.loadAnimation(context, R.anim.mario_go_down);
        Animation animation4 = AnimationUtils.loadAnimation(context, R.anim.mario_left_to_right);
        if(location>0)
        {
            moves[previous_loc].setImageResource(0);
            if(location >0 && location <=4)
            {
                moves[location].setImageResource(R.drawable.penguin);
                moves[location].setAnimation(animation1);

            }
            if(location >4 && location <=8)
            {
                moves[location].setImageResource(R.drawable.penguin);
                moves[location].setAnimation(animation2);

            }
            if(location >8 && location <=12)
            {
                moves[location].setImageResource(R.drawable.penguin);
                moves[location].setAnimation(animation3);

            }
            if(location >12 && location <=15)
            {
                moves[location].setImageResource(R.drawable.penguin);
                moves[location].setAnimation(animation4);

            }
            textView.setText(""+move_num[location]);

        }
        return move_num[location];
    }

}
