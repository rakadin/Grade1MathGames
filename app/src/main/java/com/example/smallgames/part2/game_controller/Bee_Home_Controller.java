package com.example.smallgames.part2.game_controller;

import android.widget.ImageView;

import com.example.smallgames.R;

public class Bee_Home_Controller {
    final int ids[] = {R.drawable.clock_1,R.drawable.clock_2,R.drawable.clock_3,R.drawable.clock_4,R.drawable.clock_5,
            R.drawable.clock_6,0,R.drawable.clock_7,R.drawable.clock_8,R.drawable.clock_9,0,R.drawable.clock_10,
            R.drawable.clock_11,R.drawable.clock_12,0};
    public void getIMG(int location, ImageView img)
    {
        img.setImageResource(ids[location]);
    }
}
