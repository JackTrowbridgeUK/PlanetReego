package org.jayjaytee.planetreego.economy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jayjaytee.planetreego.PlanetReego;
import org.jayjaytee.planetreego.economy.utils.EconomyUtils;

public class BalanceCommand implements CommandExecutor {

    PlanetReego plugin;
    public BalanceCommand(PlanetReego plugin){
        this.plugin = plugin;
        plugin.getCommand("balance").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cYou must be a player to execute this command!");
            return true;
        }

        EconomyUtils economyUtils = new EconomyUtils(plugin);

        sender.sendMessage("§f"+((Player) sender).getDisplayName() + "'s Balance: §a£"+economyUtils.getBalance(((Player) sender).getPlayer()));

        return true;
    }
}
