package me.sabbertran.randomdropv2;

import java.util.Random;
import me.sabbertran.randomdropv2.region.Region;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
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
                    double x = p.getLocation().getBlockX() + r.nextInt(20) - 10;
                    double y = p.getLocation().getBlockY() + 2;
                    double z = p.getLocation().getBlockZ() + r.nextInt(20) - 10;
                    Location loc = new Location(p.getWorld(), x, y, z);

                    double d = Math.random() * 100;
                    if ((d -= 18) < 0)
                    {
                        //chance 1
                        p.getWorld().dropItem(loc, applicable.getDrops()[1].get(r.nextInt(applicable.getDrops()[1].size())));
                    } else if ((d -= 16) < 0)
                    {
                        //chance 2
                        p.getWorld().dropItem(loc, applicable.getDrops()[2].get(r.nextInt(applicable.getDrops()[2].size())));
                    } else if ((d -= 15) < 0)
                    {
                        //chance 3
                        p.getWorld().dropItem(loc, applicable.getDrops()[3].get(r.nextInt(applicable.getDrops()[3].size())));
                    } else if ((d -= 13) < 0)
                    {
                        //chance 4
                        p.getWorld().dropItem(loc, applicable.getDrops()[4].get(r.nextInt(applicable.getDrops()[4].size())));
                    } else if ((d -= 11) < 0)
                    {
                        //chance 5
                        p.getWorld().dropItem(loc, applicable.getDrops()[5].get(r.nextInt(applicable.getDrops()[5].size())));
                    } else if ((d -= 9) < 0)
                    {
                        //chance 6
                        p.getWorld().dropItem(loc, applicable.getDrops()[6].get(r.nextInt(applicable.getDrops()[6].size())));
                    } else if ((d -= 7) < 0)
                    {
                        //chance 7
                        p.getWorld().dropItem(loc, applicable.getDrops()[7].get(r.nextInt(applicable.getDrops()[7].size())));
                    } else if ((d -= 5) < 0)
                    {
                        //chance 8
                        p.getWorld().dropItem(loc, applicable.getDrops()[8].get(r.nextInt(applicable.getDrops()[8].size())));
                    } else if ((d -= 4) < 0)
                    {
                        //chance 9
                        p.getWorld().dropItem(loc, applicable.getDrops()[9].get(r.nextInt(applicable.getDrops()[9].size())));
                    } else if ((d -= 2) < 0)
                    {
                        //chance 10
                        p.getWorld().dropItem(loc, applicable.getDrops()[10].get(r.nextInt(applicable.getDrops()[10].size())));
                    }
                }
            }
        }
    }

    public void onInteract(PlayerInteractEvent ev)
    {
        Player p = ev.getPlayer();
        Location loc1 = null, loc2 = null;

        if (ev.getAction() == Action.LEFT_CLICK_BLOCK)
        {
            main.getRegionCommand().getLoc1().put(p.getName(), ev.getClickedBlock().getLocation());
            p.sendMessage("First position set.");
        } else if (ev.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            main.getRegionCommand().getLoc2().put(p.getName(), ev.getClickedBlock().getLocation());
            p.sendMessage("Second position set.");
        }
    }
}
