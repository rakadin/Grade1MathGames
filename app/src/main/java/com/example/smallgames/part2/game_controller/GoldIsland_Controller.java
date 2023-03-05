package com.example.smallgames.part2.game_controller;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smallgames.R;

public class GoldIsland_Controller {
    private int nums[] ={0,11,7,15,12,-4,10,13,20,14,9,19,16,6,11,19,-3,15,8,-2,18,11,1,7,3,-1,18,10,20,12,4,15,19,16,13,10,17,14,20,0};
    public void show_num(TextView num_now, int location)
    {
        num_now.setText(""+nums[location-1]);
    }
}
