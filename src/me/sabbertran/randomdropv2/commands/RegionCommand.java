package me.sabbertran.randomdropv2.commands;

import com.avaje.ebean.enhance.ant.MainTransform;
import java.util.HashMap;
import me.sabbertran.randomdropv2.RandomDrop;
import me.sabbertran.randomdropv2.region.Region;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegionCommand implements CommandExecutor
{

    private RandomDrop main;
    private HashMap<String, Location> loc1, loc2;

    public RegionCommand(RandomDrop rd)
    {
        this.main = rd;

        loc1 = new HashMap<String, Location>();
        loc2 = new HashMap<String, Location>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (args[0].equalsIgnoreCase("pos1"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                loc1.put(p.getName(), p.getLocation());
                p.sendMessage("First position set.");
                return true;
            } else
            {
                sender.sendMessage("You have to be a player to use this command.");
                return false;
            }
        } else if (args[0].equalsIgnoreCase("pos2"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                loc2.put(p.getName(), p.getLocation());
                p.sendMessage("Second position set.");
                return true;
            } else
            {
                sender.sendMessage("You have to be a player to use this command.");
                return false;
            }
        } else if (args[0].equalsIgnoreCase("create"))
        {
            if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (args.length == 2)
                {
                    if (loc1.get(p.getName()) != null && loc2.get(p.getName()) != null)
                    {
                        Region r = new Region(args[1], loc1.get(p.getName()), loc2.get(p.getName()));
                        main.getRegions().add(r);
                        p.sendMessage("Successfully created region " + args[2] + ".");
                        return true;
                    } else
                    {
                        p.sendMessage("You have to set two corners first.");
                        return false;
                    }
                } else
                {
                    p.sendMessage("Use /rdregion create 'name' to create a region.");
                    return false;
                }
            } else
            {
                sender.sendMessage("You have to be a player to use this command.");
                return false;
            }
        } else if (args[0].equalsIgnoreCase("remove"))
        {
            if (args.length == 2)
            {
                for (Region r : main.getRegions())
                {
                    if (r.getName().equalsIgnoreCase(args[2]))
                    {
                        main.getRegions().remove(r);
                        sender.sendMessage("Succesfully removed region " + args[2] + ".");
                        return true;
                    }
                }
                sender.sendMessage("Region " + args[2] + " does not exist.");
                return false;

            } else
            {
                sender.sendMessage("Use /rdregion remove 'name' to remove a region.");
                return false;
            }
        } else
        {
            sender.sendMessage("Unknown command.");
            return true;
        }
    }

    //Getter/Setter    
    public HashMap<String, Location> getLoc1()
    {
        return loc1;
    }

    public HashMap<String, Location> getLoc2()
    {
        return loc2;
    }

}
