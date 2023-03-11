package com.example.smallgames.part2.game_controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.ImageButton;

import com.example.smallgames.SoundControl;
import com.example.smallgames.Utils;
import com.example.smallgames.part2.game_acitivity.Mushroom_Activity;

public class Mushroom_Controller {
    static final int ans[] = {35,34,6,67,50,12};
    public boolean getAns( int numFinal, int loc)
    {
        boolean check = false;
       if(ans[loc]== numFinal)// correct
       {
           check = true;
       }
       return check;
    }
}
