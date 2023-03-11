package com.example.smallgames.part2.game_acitivity;

import static com.example.smallgames.R.drawable.sound_on;
import static com.example.smallgames.R.drawable.xsign;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.example.smallgames.part2.game_controller.Mushroom_Controller;
import com.example.smallgames.part2.winning_activity.Winning_activity_fishing_2;
import com.example.smallgames.part2.winning_activity.Winning_activity_mushroom;

public class Mushroom_Activity extends AppCompatActivity {
    ImageButton soundBut,homeBut,diceBut;
    Gif_PopUp_Controller gif_popUp_controller = new Gif_PopUp_Controller();
    SoundControl soundControl = new SoundControl();
    Mushroom_Controller controller =  new Mushroom_Controller();
    int diceNumFinal =0;
    int count =0;
    static final int dice_num[] = {6,12,34,35,50,67};// dice variable
    Dialog dialog;
    ImageButton move_0,move_1,move_2,move_3,move_4,move_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushroom);
        getSupportActionBar().hide();

        dialog = new Dialog(Mushroom_Activity.this);

        soundBut = findViewById(R.id.SonoffBut);
        homeBut = findViewById(R.id.homeBut);
        diceBut = findViewById(R.id.dice);

        // set sound but func
        soundControl.OnOffFun(Mushroom_Activity.this,soundBut);
        setHomeBut();
        rollDice();
        getmoveID();
        // set move_ids
        ImageButton moves[] = {move_0,move_1,move_2,move_3,move_4,move_5};


        for(int i=0;i<=5;i++)
        {
            int tem =i;
            moves[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(diceNumFinal == 0) // make sure that users have roll the dice first
                    {
                        Toast.makeText(view.getContext(),"Bạn cần xúc xắc trước đã!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        soundControl.pianoSoundFunc(view.getContext());
                        gif_popUp_controller.show_mushroom_picker(dialog);
                        Utils.delay(40, () -> {
                            soundControl.fall.release();
                            dialog.dismiss();
                            checkAns(tem,moves, view.getContext());
                        });
                    }

                }
            });
        }
    }
    void checkAns(int tem,ImageButton moves[],Context context)// checking ans
    {
        boolean check = controller.getAns(diceNumFinal,tem);
        if(check == true)
        {
            soundControl.correctSoundFun(Mushroom_Activity.this);
            gif_popUp_controller.show_mushroom_yeah(dialog);
            Utils.delay(40, () -> {
                dialog.dismiss();
                moves[tem].setImageResource(xsign);// set xsign to mushroom
                moves[tem].setClickable(false); // cant click after xsign
                count++; // mushroom ++
                if(count == 4)
                {
                    winning(context,dialog);
                }
            });
        }
        else
        {
            soundControl.wrongSoundFun(Mushroom_Activity.this);
            gif_popUp_controller.show_mushroom_sad(dialog);
            Utils.delay(50, () -> {
                dialog.dismiss();
            });
        }
    }
    void winning(Context context,Dialog dialog)// check and open winning
    {
        if(count == 4)
        {
            soundControl.hooraySoundFun2(context);
            gif_popUp_controller.show_mushroom_yeah(dialog);
            Utils.delay(80, () -> {
                dialog.dismiss();
                Intent intent = new Intent();
                intent.setClass(Mushroom_Activity.this, Winning_activity_mushroom.class);
                startActivity(intent);
            });

        }
    }
    // home button func
    void setHomeBut()
    {
        homeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Mushroom_Activity.this, Part2_Homepage_Activity.class);
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
                int images[] = {R.drawable.num_dice_6,R.drawable.num_dice_12,R.drawable.num_dice_34,R.drawable.num_dice_35,R.drawable.num_dice_50,R.drawable.num_dice_67};
                int sec = 1;
                for (int j = 0 ; j < 7;j++){
                    Utils.delay(sec, () -> {
                        soundControl.RollSoundFun(Mushroom_Activity.this);
                        int tem = (int) (Math.random() * 6 + 1);
                        diceNumFinal = dice_num[tem-1];
                        diceBut.setImageResource(images[tem-1]);
                    });
                }

            }

        });

        // end roll
        return diceNumFinal;

    }
    void getmoveID()
    {
        move_0 = findViewById(R.id.mushroom_1);
        move_1 = findViewById(R.id.mushroom_2);
        move_2 = findViewById(R.id.mushroom_3);
        move_3 = findViewById(R.id.mushroom_4);
        move_4 = findViewById(R.id.mushroom_5);
        move_5 = findViewById(R.id.mushroom_6);

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