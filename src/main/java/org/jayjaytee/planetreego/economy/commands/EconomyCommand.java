package org.jayjaytee.planetreego.economy.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jayjaytee.planetreego.PlanetReego;
import org.jayjaytee.planetreego.enums.MESSAGES;
import org.jayjaytee.planetreego.utils.NumberUtils;

public class EconomyCommand implements CommandExecutor {

    PlanetReego plugin;
    public EconomyCommand(PlanetReego plugin){
        this.plugin = plugin;
        plugin.getCommand("eco").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender.hasPermission("reego.admin"))){
            sender.sendMessage(String.valueOf(MESSAGES.PERMISSION_DENIED));
            return true;
        }
        // /eco (player) (set/add/remove) (amount)

        if(args.length != 3){
            sender.sendMessage("§cIncorrect Usage! /eco (player) (set/add/remove) (amount)");
            return true;
        }

        Player player = Bukkit.getServer().getPlayer(args[0]);
        if(player == null){
            sender.sendMessage("§cThat player is invalid!");
            return true;
        }

        if(!NumberUtils.isFloat(args[2])){
            sender.sendMessage("§cThat number is invalid!");
            return true;
        }

        if(args[1].equalsIgnoreCase("set")){
            plugin.getPlayerConfig().set(player.getUniqueId().toString() + ".Balance", Float.parseFloat(args[2]));
            sender.sendMessage("§aSuccessfully set §f" + player.getDisplayName() + "§a balance to §f£" + args[2]);
        }else if(args[1].equalsIgnoreCase("add")){
            double amount = (float) plugin.getPlayerConfig().getDouble(player.getUniqueId().toString() + ".Balance") + Float.parseFloat(args[2]);
            plugin.getPlayerConfig().set(player.getUniqueId().toString() + ".Balance", amount);
            sender.sendMessage("§aSuccessfully added §f" + args[2] + "§a to §f" + player.getDisplayName() + "§a balance");
        }else if(args[1].equalsIgnoreCase("remove")){
            double amount = (float) plugin.getPlayerConfig().getDouble(player.getUniqueId().toString() + ".Balance") - Float.parseFloat(args[2]);
            plugin.getPlayerConfig().set(player.getUniqueId().toString() + ".Balance", amount);
            sender.sendMessage("§aSuccessfully removed §f" + args[2] + "§a from §f" + player.getDisplayName() + "§a balance");
        }else{
            sender.sendMessage("§cIncorrect Usage! /eco (player) (set/add/remove) (amount)");
        }

        return true;
    }
}
