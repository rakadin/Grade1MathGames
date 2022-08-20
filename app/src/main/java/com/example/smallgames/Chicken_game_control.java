package com.example.smallgames;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Chicken_game_control extends AppCompatActivity {
    int get_count =0;
    SoundControl soundControl = new SoundControl();
    int id_values[]={R.drawable.chick_1,R.drawable.chick_2,R.drawable.chick_3,R.drawable.chick_4,R.drawable.chick_5,R.drawable.chick_6,R.drawable.chick_7,R.drawable.chick_8,R.drawable.chick_9,R.drawable.chick_10};
    int math_values[]={3,7,2,9,6,5,7,3,0,1,7,9,1,2,8,5,4,8,6,4,0};
    String maths[] ={"","5-2","4+3","3-1","6+3","8-2","6-1","7-0","6-3","3-3","10-9","6+1","5+4","7-6","2-0","6+2","9-4","1+3","3+5","6-0","7-3","8-8"};
    protected void setString(TextView showT, int move, ImageButton imgs[], int previousMove, Activity main, Context context)
    {
        //animation set
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.mario_up_top);
        Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.mario_right_to_left);
        Animation animation3 = AnimationUtils.loadAnimation(context, R.anim.mario_go_down);
        Animation animation4 = AnimationUtils.loadAnimation(context, R.anim.mario_left_to_right);
        if(move >=0 && move <=11)
        {
            soundControl.runSoundFun(main);
            imgs[previousMove].startAnimation(animation);
            imgs[move].setImageResource(R.drawable.mario);
            if( move <=6)
            {
                imgs[move].startAnimation(animation);
            }
            else
            {
                imgs[move].startAnimation(animation2);
            }
            imgs[previousMove].setImageResource(0);
            showT.setText(""+maths[move]);
            soundControl.run.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
       else
        {
            soundControl.runSoundFun(main);
            imgs[move].setImageResource(R.drawable.mario2);
            if(move >=12 && move <=17)
            {
                imgs[move].startAnimation(animation3);
            }
            else
            {
                imgs[move].startAnimation(animation4);
            }
            imgs[previousMove].setImageResource(0);
            showT.setText(""+maths[move]);
            soundControl.run.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    protected void checkAns(Context context, int temi, int chick_value, Activity main, ImageButton imgBut, ImageView gets[],int i)
    {
        //animation set
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.card_animation);
        Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.card_animation_wrong);
        if(temi >0)
        {
            if(chick_value == math_values[temi-1])
            {
                gets[get_count].setImageResource(id_values[i]);// set image chicken that u get
                get_count++;
                soundControl.correctSoundFun(main);
                imgBut.startAnimation(animation);
                Toast.makeText(context,"Đúng rồi !!!",Toast.LENGTH_LONG).show();
                soundControl.correct.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
            else
            {
                soundControl.wrongSoundFun(main);
                imgBut.startAnimation(animation2);
                Toast.makeText(context,"Sai rồi !!!",Toast.LENGTH_LONG).show();
                soundControl.wrong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
            }
        }
    }
}
