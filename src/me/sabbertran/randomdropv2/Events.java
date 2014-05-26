package me.sabbertran.randomdropv2;

import java.util.Random;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Events implements Listener
{

    private RandomDrop main;
    private Random r;

    public Events(RandomDrop rd)
    {
        this.main = rd;
        r = new Random();
    }

    public void onPlayerMove(PlayerMoveEvent ev)
    {
        if (main.getDropsEnabled())
        {
            if (r.nextInt(main.getGlobalDropChance()) == 0)
            {
                
            }
        }
    }
}
