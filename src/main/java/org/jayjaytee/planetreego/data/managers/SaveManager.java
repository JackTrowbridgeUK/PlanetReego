package org.jayjaytee.planetreego.data.managers;

import org.jayjaytee.planetreego.PlanetReego;

import java.io.IOException;

public class SaveManager {

    PlanetReego plugin;
    public SaveManager(PlanetReego plugin) { this.plugin = plugin; }

    public void savePlayerFile(){
        try{
            plugin.getPlayerConfig().save(plugin.getPlayerFile());
            plugin.getServer().getConsoleSender().sendMessage("§aSuccessfully saved the player file.");
        }catch(IOException e){
            e.printStackTrace();
            plugin.getServer().getConsoleSender().sendMessage("§cUnable to save player file.");
        }
    }

    public void savePlayerFileLoop()
    {
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                savePlayerFile();
                savePlayerFileLoop();
            }
        }, 20 * 600);
    }
}
