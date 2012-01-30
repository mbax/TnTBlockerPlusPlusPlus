package org.kitteh.tnt.blocker.plus.plus;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Plus extends JavaPlugin implements Listener {

    @Override
    public void onDisable() {
        this.getLogger().info("TnTBlockerPlusPlusPlus v" + this.getDescription().getVersion() + " disabled.");
    }

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getLogger().info("TnTBlockerPlusPlusPlus v" + this.getDescription().getVersion() + " enabled.");
    }

    @EventHandler
    public void prelogin(PlayerPreLoginEvent event) {
        if (event.getName().equalsIgnoreCase("TnTBass")) {
            event.disallow(PlayerPreLoginEvent.Result.KICK_BANNED, "TnT is not allowed on this server.");
        }
    }

    // Even protects offline mode servers!
    @EventHandler
    public void login(PlayerLoginEvent event) {
        if (event.getPlayer().getName().equalsIgnoreCase("TnTBass")) {
            event.disallow(PlayerLoginEvent.Result.KICK_BANNED, "TnT is not allowed on this server.");
        }
    }

}