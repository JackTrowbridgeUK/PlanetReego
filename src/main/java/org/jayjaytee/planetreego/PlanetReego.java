package org.jayjaytee.planetreego;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jayjaytee.planetreego.data.commands.WipeCommand;
import org.jayjaytee.planetreego.data.managers.SaveManager;
import org.jayjaytee.planetreego.economy.commands.BalanceCommand;
import org.jayjaytee.planetreego.economy.commands.EconomyCommand;
import org.jayjaytee.planetreego.economy.events.EconomyEvents;
import org.jayjaytee.planetreego.economy.utils.EconomyUtils;
import org.jayjaytee.planetreego.items.commands.ItemCommand;
import org.jayjaytee.planetreego.foodbuff.events.FoodEatEvent;
import org.jayjaytee.planetreego.events.WeatherPreventionEvent;
import org.jayjaytee.planetreego.items.managers.ItemManager;

import java.io.File;

public final class PlanetReego extends JavaPlugin {

    private File playerFile = new File(getDataFolder(), "players.yml");
    private FileConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);

    private final SaveManager saveManager = new SaveManager(this);

    @Override
    public void onEnable() {

        if(!playerFile.exists()) { saveResource("players.yml", false); }
        saveManager.savePlayerFileLoop();

        registerClasses();
        ItemManager.registerItems();
    }

    @Override
    public void onDisable() {
        saveManager.savePlayerFile();
    }

    private void registerClasses(){
        new FoodEatEvent(this);
        new WeatherPreventionEvent(this);
        new ItemCommand(this);
        new EconomyCommand(this);
        new EconomyUtils(this);
        new BalanceCommand(this);
        new EconomyEvents(this);
        new WipeCommand(this);
    }

    public FileConfiguration getPlayerConfig() { return playerConfig; }
    public File getPlayerFile() { return playerFile; }

    public SaveManager getSaveManager() { return saveManager; }
}
