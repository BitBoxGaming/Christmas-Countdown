package com.gmail.bitboxgaming.christmascountdown;

import net.minecraft.server.v1_8_R1.EntityArmorStand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by User 1 on 12/11/2014.
 */
public class MainClass extends JavaPlugin implements Listener{
    public static int secondsInDay = 86400;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Calendar thatDay = Calendar.getInstance();
        thatDay.setTime(new Date(0));
        thatDay.set(Calendar.DAY_OF_MONTH,25);
        thatDay.set(Calendar.MONTH,11);
        thatDay.set(Calendar.YEAR, 2014);
        thatDay.set(Calendar.HOUR, 0);

        Calendar today = Calendar.getInstance();
        long diff =  thatDay.getTimeInMillis() - today.getTimeInMillis();
        long diffSec = diff / 1000;

        long days = diffSec / secondsInDay;
        long secondsDay = diffSec % secondsInDay;
        long seconds = secondsDay % 60;
        long minutes = (secondsDay / 60) % 60;
        long hours = (secondsDay / 3600);
        if (label.equalsIgnoreCase("christmas")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f[&cChristmas &4Countdown&f] &cTime &fUntil &cChristmas&f: " + "&f" + days + " &cdays&f, " + "&f" + hours + " &chours&f, " + "&f" + minutes + " &cminutes&f, " + "&f" + seconds + " &cseconds&f."));
        }

        return true;
    }

}
