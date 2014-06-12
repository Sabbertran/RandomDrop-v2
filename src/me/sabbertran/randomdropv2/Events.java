package me.sabbertran.randomdropv2;

import java.util.ArrayList;
import java.util.Random;
import me.sabbertran.randomdropv2.region.Region;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

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
        Player p = ev.getPlayer();

        if (main.isDropsEnabled())
        {
            if (r.nextInt(main.getGlobalDropChance()) == 0)
            {
                Region applicable = null;
                for (Region r : main.getRegions())
                {
                    if (r.inRegion(p.getLocation()))
                    {
                        if (applicable == null || r.getPriority() > applicable.getPriority())
                        {
                            applicable = r;
                        }
                    }
                }

                if (applicable != null)
                {
                    for (ArrayList<ItemStack> is : applicable.getDrops())
                    {
                        
                    }
                }
            }
        }
    }
}
