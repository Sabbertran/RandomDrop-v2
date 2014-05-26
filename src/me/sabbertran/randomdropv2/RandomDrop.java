package me.sabbertran.randomdropv2;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomDrop extends JavaPlugin
{
    private static final Logger log = Bukkit.getLogger();
    
    @Override
    public void onDisable()
    {
        log.info("RandomDrop v2 disabled");
    }
    
    @Override
    public void onEnable()
    {
        log.info("RandomDrop v2 enabled");
    }
}
