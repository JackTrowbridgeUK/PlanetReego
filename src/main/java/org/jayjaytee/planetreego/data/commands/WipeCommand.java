package org.jayjaytee.planetreego.data.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jayjaytee.planetreego.PlanetReego;
import org.jayjaytee.planetreego.enums.MESSAGES;

import java.util.Set;

public class WipeCommand implements CommandExecutor {

    PlanetReego plugin;
    public WipeCommand(PlanetReego plugin){
        this.plugin = plugin;
        plugin.getCommand("wipe").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender.hasPermission("reego.admin"))){
            sender.sendMessage(String.valueOf(MESSAGES.PERMISSION_DENIED));
            return true;
        }

        if(args.length != 1){
            sender.sendMessage("§cIncorrect Usage! /wipe (player)");
            return true;
        }

        OfflinePlayer player = Bukkit.getServer().getOfflinePlayer(args[0]);
        if(player == null){
            sender.sendMessage("§cThat player is invalid!");
            return true;
        }

        if(plugin.getPlayerConfig().isSet(player.getUniqueId().toString())){
            plugin.getPlayerConfig().set(player.getUniqueId().toString(), null);
        }

        if(player.isOnline()){
            player.getPlayer().getInventory().clear();
            player.getPlayer().kickPlayer("§4Your account has been wiped!\n§cThis action was taken for a very good reason.");
        }

        Bukkit.dispatchCommand(sender, "plot delete "+player.getName());
        sender.sendMessage("§aSuccessfully wiped §f"+player.getName());

        return true;
    }
}
