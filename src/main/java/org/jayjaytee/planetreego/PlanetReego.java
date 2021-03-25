package org.jayjaytee.planetreego;

import org.bukkit.plugin.java.JavaPlugin;
import org.jayjaytee.planetreego.commands.ItemCommand;
import org.jayjaytee.planetreego.events.FoodEatEvent;
import org.jayjaytee.planetreego.events.WeatherPreventionEvent;
import org.jayjaytee.planetreego.managers.ItemManager;

public final class PlanetReego extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerClasses();
        ItemManager.registerItems();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerClasses(){
        new FoodEatEvent(this);
        new WeatherPreventionEvent(this);
        new ItemCommand(this);
    }
}
