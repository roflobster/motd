package me.roflobster.motd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;

// Implements Listener for events-
public class motd extends JavaPlugin implements Listener {

    //Defining Variables from Config.yml
    String pJoin = this.getConfig().getString("playerOnJoin");
    String pQuit = this.getConfig().getString("playerOnQuit");
    String pMOTD = this.getConfig().getString("playerJoinMOTD");


    public void registerConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

// Registers listener and posts in console that plugin activated
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        this.registerConfig();

    }


// Sends Joining player custom message
// Disables built in player join message in favor of custom one
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        Bukkit.broadcastMessage(ChatColor.YELLOW + (player.getDisplayName() + pJoin));
        player.sendMessage(pMOTD);

    }

// Disables built in player quit message in favor of custom one
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);

        Bukkit.broadcastMessage(ChatColor.YELLOW + (player.getDisplayName() + pQuit));

    }



}