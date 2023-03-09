package com.example.smallgames.part2.game_controller;

public class Toy_Machine_Controller {
    private final int answers[] = {48,44,45,47,48,46,43,47,45,43,44,46};
    public boolean checkAns(int ans,int i)
    {
        if(ans == answers[i])
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
