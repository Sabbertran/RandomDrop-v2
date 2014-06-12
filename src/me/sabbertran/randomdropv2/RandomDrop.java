package me.sabbertran.randomdropv2;

import java.util.ArrayList;
import java.util.logging.Logger;
import me.sabbertran.randomdropv2.region.Region;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomDrop extends JavaPlugin
{

    private Events events;

    private boolean dropsEnabled;
    private int globalDropChance;
    
    private ArrayList<Region> regions;

    private static final Logger log = Bukkit.getLogger();

    @Override
    public void onDisable()
    {
        log.info("RandomDrop v2 disabled");
    }

    @Override
    public void onEnable()
    {

        events = new Events(this);
        regions = new ArrayList<Region>();
        getServer().getPluginManager().registerEvents(events, this);

        log.info("RandomDrop v2 enabled");
    }

    public boolean isDropsEnabled()
    {
        return dropsEnabled;
    }

    public void setDropsEnabled(boolean dropsEnabled)
    {
        this.dropsEnabled = dropsEnabled;
    }

    public int getGlobalDropChance()
    {
        return globalDropChance;
    }

    public void setGlobalDropChance(int globalDropChance)
    {
        this.globalDropChance = globalDropChance;
    }

    public ArrayList<Region> getRegions()
    {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions)
    {
        this.regions = regions;
    }

    
}
