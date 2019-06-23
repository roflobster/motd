/*//////////////////////////////////////////////////////////////////////////
/   MOTD                                                                   /                                                                                                                          /
/                                                                          /
/   Simple plugin for displaying a Message of the Day to joining players   /
//////////////////////////////////////////////////////////////////////////*/

package com.roflobster.motd;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class motd extends JavaPlugin implements Listener {
FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        config.addDefault("youAreAwesome", true);
        config.options().copyDefaults(true);
        saveConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);

        Bukkit.broadcastMessage(ChatColor.YELLOW + (player.getDisplayName() + " has joined the server"));

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);

        Bukkit.broadcastMessage(ChatColor.YELLOW + (player.getDisplayName() + " has left the server"));

    }





}
