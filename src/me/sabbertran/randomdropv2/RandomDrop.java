package me.sabbertran.randomdropv2;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomDrop extends JavaPlugin
{

    private Events events;

    private boolean dropsEnabled;
    private int globalDropChance;

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
        getServer().getPluginManager().registerEvents(events, this);

        log.info("RandomDrop v2 enabled");
    }

    public int getGlobalDropChance()
    {
        return globalDropChance;
    }

    public boolean getDropsEnabled()
    {
        return dropsEnabled;
    }
}
