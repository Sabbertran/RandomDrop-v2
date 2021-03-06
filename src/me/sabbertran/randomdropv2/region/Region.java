package me.sabbertran.randomdropv2.region;

import java.util.ArrayList;
import me.sabbertran.randomdropv2.RandomDrop;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class Region
{

    private RandomDrop main;

    private String name;
    private World world;
    private int minX, minY, minZ, maxX, maxY, maxZ, priority;

    private ArrayList<ItemStack>[] drops;

    /**
     * Drop Chances (Drop Level - Chance) 1 - 18%; 2 - 16%; 3 - 15%; 4 - 13%; 5 -
     * 11%; 6 - 9%; 7 - 7%; 8 - 5%; 9 - 4%; 10 - 2%
     */
    public Region(String name, Location loc1, Location loc2)
    {
        this(name, loc1, loc2, 0);
    }

    public Region(String name, Location loc1, Location loc2, int priority)
    {
        this.name = name;
        
        this.minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        this.minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        this.minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());

        this.maxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
        this.maxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
        this.maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());

        this.world = loc1.getWorld();
        this.priority = priority;

        this.drops = new ArrayList[10];
    }

    public boolean inRegion(Location loc)
    {
        if (loc.getWorld() != this.world)
        {
            return false;
        }
        if ((loc.getBlockX() >= this.minX) && (loc.getBlockX() <= this.maxX)
                && (loc.getBlockY() >= this.minY) && (loc.getBlockY() <= this.maxY)
                && (loc.getBlockZ() >= this.minZ) && (loc.getBlockZ() <= this.maxZ))
        {
            return true;
        }
        return false;
    }

    public String getName()
    {
        return name;
    }
    
    public int getPriority()
    {
        return priority;
    }

    public ArrayList<ItemStack>[] getDrops()
    {
        return drops;
    }

    public void setDrops(ArrayList<ItemStack>[] drops)
    {
        this.drops = drops;
    }

}
