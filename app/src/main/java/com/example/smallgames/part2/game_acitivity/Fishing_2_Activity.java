package com.example.smallgames.part2.game_acitivity;

import static com.example.smallgames.R.drawable.sound_on;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
import com.example.smallgames.part2.winning_activity.Winning_activity_fishing_2;

public class Fishing_2_Activity extends AppCompatActivity {
    ImageButton soundBut,homeBut,diceBut;
    Button moveBut;
    TextView ans;
    Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    SoundControl soundControl = new SoundControl();
    Fishing_2_Controller fishing_2_controller = new Fishing_2_Controller();
    int diceNumFinal =0;
    int now_loc = 0; // now location
    int previous =0;// previous location
    int now_number =0;
    int count =0;
    static final int fish_num[] = {42,93,76,14,58};
    Dialog dialog;
    ImageButton move_0,move_1,move_2,move_3,move_4,move_5,move_6,move_7,move_8,move_9,
            move_10,move_11,move_12,move_13,move_14,move_15;
    ImageButton fish_42,fish_93,fish_76,fish_14,fish_58;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishing2);
        getSupportActionBar().hide();

        dialog = new Dialog(Fishing_2_Activity.this);

        soundBut = findViewById(R.id.SonoffBut);
        homeBut = findViewById(R.id.homeBut);
        diceBut = findViewById(R.id.dice);
        moveBut = findViewById(R.id.moveBut);
        ans = findViewById(R.id.questionText);

        // set sound but func
        soundControl.OnOffFun(Fishing_2_Activity.this,soundBut);
        setHomeBut();
        rollDice();
        getmoveID();
        getfishID();
        // set move_ids
        ImageButton moves[] = {move_0,move_1,move_2,move_3,move_4,move_5,move_6,move_7,move_8,move_9,
                move_10,move_11,move_12,move_13,move_14,move_15};
        ImageButton fishes[] = {fish_42,fish_93,fish_76,fish_14,fish_58};
        moveFunc(moves);

        for(int i=0;i<5;i++)
        {
            int tem =i;
            fishes[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(diceNumFinal ==0)// make sure roll the dice first
                    {
                        Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        checkans(now_number,view.getContext(),tem,fishes,dialog);
                    }

                }
            });
        }
    }
    // check the winner cost 5
    public void checkans(int num, Context context, int loc, ImageButton fishes[], Dialog dialog)
    {
        if(num == fish_num[loc])
        {
            soundControl.fishingSoundFunc(context);
            gif_popUp_controller.show_f_penguin(dialog);
            Utils.delay(75, () -> {
                soundControl.fall.release();
                soundControl.hooraySoundFun2(context);
                gif_popUp_controller.show_yes_penguin(dialog);
            });
            Utils.delay(135, () -> {
                fishes[loc].setBackgroundResource(R.drawable.xsign);
                dialog.dismiss();
                count +=1; // increase fish catched
                if(count == 5)
                {
                    Intent intent = new Intent();
                    intent.setClass(context, Winning_activity_fishing_2.class);
                    startActivity(intent);
                }
            });

            fishes[loc].setClickable(false);
        }
        else
        {
            soundControl.fishingSoundFunc(context);
            gif_popUp_controller.show_f_penguin(dialog);
            Utils.delay(75, () -> {
                soundControl.fall.release();
                soundControl.wrongSoundFun2(context);
                gif_popUp_controller.show_no_penguin(dialog);
            });
            Utils.delay(135, () -> {
                dialog.dismiss();
            });
        }
        ///

    }
    // home button func
    void setHomeBut()
    {
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Fishing_2_Activity.this, Part2_Homepage_Activity.class);
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
                        soundControl.RollSoundFun(Fishing_2_Activity.this);
                        diceNumFinal = (int) (Math.random() * 6 + 1);
                        diceBut.setImageResource(images[diceNumFinal-1]);
                    });
                }

            }

        });

        // end roll
        return diceNumFinal;

    }
    void getmoveID()
    {
        move_0 = findViewById(R.id.move_0);
        move_1 = findViewById(R.id.move_1);
        move_2 = findViewById(R.id.move_2);
        move_3 = findViewById(R.id.move_3);
        move_4 = findViewById(R.id.move_4);
        move_5 = findViewById(R.id.move_5);
        move_6 = findViewById(R.id.move_6);
        move_7 = findViewById(R.id.move_7);
        move_8 = findViewById(R.id.move_8);
        move_9 = findViewById(R.id.move_9);
        move_10 = findViewById(R.id.move_10);
        move_11 = findViewById(R.id.move_11);
        move_12 = findViewById(R.id.move_12);
        move_13 = findViewById(R.id.move_13);
        move_14 = findViewById(R.id.move_14);
        move_15 = findViewById(R.id.move_15);
    }
    void getfishID()
    {
        fish_14 = findViewById(R.id.fish_14);
        fish_93 = findViewById(R.id.fish_93);
        fish_42 = findViewById(R.id.fish_42);
        fish_58 = findViewById(R.id.fish_58);
        fish_76 = findViewById(R.id.fish_76);
    }
    // character moving func
    void moveFunc(ImageButton moves[])
    {
        int final_ans=0;
        moveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(diceNumFinal ==0)// make sure roll the dice first
                {
                    Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                }
                else
                {

                    previous =now_loc;
                    now_loc += diceNumFinal;
                    if(now_loc>15)
                    {
                        now_loc -= 15;
                        now_number = fishing_2_controller.getnum(ans,now_loc,previous,moves,view.getContext());

                    }
                    else
                    {
                        now_number = fishing_2_controller.getnum(ans,now_loc,previous,moves,view.getContext());

                    }
                }


            }
        });
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