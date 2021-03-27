package org.jayjaytee.planetreego.economy.utils;

import org.bukkit.entity.Player;
import org.jayjaytee.planetreego.PlanetReego;

public class EconomyUtils {

    PlanetReego plugin;
    public EconomyUtils(PlanetReego plugin){
        this.plugin = plugin;
    }

    public float getBalance(Player player){
        return (float) plugin.getPlayerConfig().getDouble(player.getUniqueId().toString() + ".Balance");
    }

}
