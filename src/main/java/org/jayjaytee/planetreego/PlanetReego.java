package org.jayjaytee.planetreego;

import org.bukkit.plugin.java.JavaPlugin;
import org.jayjaytee.planetreego.events.FoodEatEvent;

public final class PlanetReego extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerClasses();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerClasses(){
        new FoodEatEvent(this);
    }
}
