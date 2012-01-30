package org.kitteh.tnt.blocker.plus.plus;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Plus extends JavaPlugin implements Listener {

    @Override
    public void onDisable() {
        this.getLogger().info("v" + this.getDescription().getVersion() + " disabled.");
    }

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getLogger().info("v" + this.getDescription().getVersion() + " enabled.");
    }

    @EventHandler
    public void prelogin(PlayerPreLoginEvent event) {
        if (event.getName().equalsIgnoreCase("tntbass")) {
            event.disallow(PlayerPreLoginEvent.Result.KICK_BANNED, "TNT is not allowed on this server");
        }
    }

    // Even protects offline mode servers!
    @EventHandler
    public void login(PlayerLoginEvent event) {
        if (event.getPlayer().getName().equalsIgnoreCase("tntbass")) {
            event.disallow(PlayerLoginEvent.Result.KICK_BANNED, "TNT is not allowed on this server");
        }
    }

}