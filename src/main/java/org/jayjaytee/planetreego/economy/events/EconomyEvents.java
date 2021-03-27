package org.jayjaytee.planetreego.economy.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jayjaytee.planetreego.PlanetReego;

public class EconomyEvents implements Listener {

    PlanetReego plugin;
    public EconomyEvents(PlanetReego plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!plugin.getPlayerConfig().isSet(player.getUniqueId().toString() + ".Balance")){
            plugin.getPlayerConfig().set(player.getUniqueId().toString() + ".Balance", 0);
            player.sendMessage("§aWelcome to §fPlanetReego");
        }
    }

}
