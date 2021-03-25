package org.jayjaytee.planetreego.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jayjaytee.planetreego.PlanetReego;
import org.jayjaytee.planetreego.enums.MESSAGES;
import org.jayjaytee.planetreego.managers.ItemManager;
import org.jayjaytee.planetreego.utils.NumberUtils;

import java.util.ArrayList;

public class ItemCommand implements CommandExecutor {

    PlanetReego plugin;
    public ItemCommand(PlanetReego plugin){
        this.plugin = plugin;
        plugin.getCommand("item").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender.hasPermission("reego.admin"))){
            sender.sendMessage(String.valueOf(MESSAGES.PERMISSION_DENIED));
            return true;
        }

        // /item (player) (item) (amount)

        if(args.length == 2 || args.length == 3){
            Player player = Bukkit.getServer().getPlayer(args[0]);
            if(player == null){
                sender.sendMessage("§cThat player isn't online!");
                return true;
            }
            if(Material.matchMaterial(args[1]) == null){
                if(!ItemManager.item.containsKey(args[1].toUpperCase())){
                    sender.sendMessage("§cThat item doesn't exist!");
                    return true;
                }
            }
            if(args.length == 3){
                if(!NumberUtils.isInt(args[2])){
                    sender.sendMessage("§cThe amount must be a number!");
                    return true;
                }
                if(ItemManager.item.containsKey(args[1].toUpperCase())){
                    for(int i = 0; i < Integer.parseInt(args[2]); i++){
                        player.getInventory().addItem(ItemManager.item.get(args[1].toUpperCase()));
                    }
                }else{
                    player.getInventory().addItem(new ItemStack(Material.matchMaterial(args[1].toUpperCase()), Integer.parseInt(args[2])));
                }
                player.sendMessage("§a§l+ §f" + args[1].toUpperCase() + "§7 (x" + args[2] + "§7)");
                sender.sendMessage("§aSuccessfully given " + player.getDisplayName() + " §f" + args[1].toUpperCase() + "§7 (x"+args[2]+"§7)");
                return true;
            }
            if(ItemManager.item.containsKey(args[1].toUpperCase())){
                player.getInventory().addItem(ItemManager.item.get(args[1].toUpperCase()));
            }else{
                player.getInventory().addItem(new ItemStack(Material.matchMaterial(args[1].toUpperCase())));
            }

            player.sendMessage("§a§l+ §f" + args[1].toUpperCase());
            sender.sendMessage("§aSuccessfully given " + player.getDisplayName() + " §f" + args[1].toUpperCase());
            return true;
        }

        sender.sendMessage("§cIncorrect Usage! /item (player) (item) [amount]");
        return true;
    }
}
