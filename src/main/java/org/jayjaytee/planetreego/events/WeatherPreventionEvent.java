package org.jayjaytee.planetreego.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.jayjaytee.planetreego.PlanetReego;

public class WeatherPreventionEvent implements Listener {

    PlanetReego plugin;
    public WeatherPreventionEvent(PlanetReego plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void onWeather(WeatherChangeEvent event){
        event.setCancelled(true);
        event.getWorld().setStorm(false);
    }
}
