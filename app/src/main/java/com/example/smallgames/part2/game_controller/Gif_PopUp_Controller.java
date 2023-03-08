package com.example.smallgames.part2.game_controller;

import android.app.Dialog;

import com.example.smallgames.R;

import pl.droidsonroids.gif.GifImageView;

public class Gif_PopUp_Controller {
    // showw pop up dialog showing gif need
    //
    //
    public void show_ship_sailing(Dialog dialog)
    {
        dialog.setContentView(R.layout.pop_up_layout_gif);
        GifImageView gifphy ;
        gifphy = dialog.findViewById(R.id.gif_inset);
        gifphy.setImageResource(R.drawable.ship_sailing_gif);
        dialog.show();
    }
    public void show_gold_chest(Dialog dialog)
    {
        dialog.setContentView(R.layout.pop_up_layout_gif);
        GifImageView gifphy ;
        gifphy = dialog.findViewById(R.id.gif_inset);
        gifphy.setImageResource(R.drawable.gold_chest_open);
        dialog.show();
    }
    public void show_f_penguin(Dialog dialog)
    {
        dialog.setContentView(R.layout.pop_up_layout_gif);
        GifImageView gifphy ;
        gifphy = dialog.findViewById(R.id.gif_inset);
        gifphy.setImageResource(R.drawable.ice_fishing_gif);// insert gif need
        dialog.show();
    }
    public void show_yes_penguin(Dialog dialog)
    {
        dialog.setContentView(R.layout.pop_up_layout_gif);
        GifImageView gifphy ;
        gifphy = dialog.findViewById(R.id.gif_inset);
        gifphy.setImageResource(R.drawable.yes_penguin_gif);// insert gif need
        dialog.show();
    }
    public void show_no_penguin(Dialog dialog)
    {
        dialog.setContentView(R.layout.pop_up_layout_gif);
        GifImageView gifphy ;
        gifphy = dialog.findViewById(R.id.gif_inset);
        gifphy.setImageResource(R.drawable.sad_penguin_gif);// insert gif need
        dialog.show();
    }
    public void show_mario_win(Dialog dialog)
    {
        dialog.setContentView(R.layout.pop_up_layout_gif);
        GifImageView gifphy ;
        gifphy = dialog.findViewById(R.id.gif_inset);
        gifphy.setImageResource(R.drawable.mario_win_gif);// insert gif need
        dialog.show();
    }
}
