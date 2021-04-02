package org.jayjaytee.planetreego.items.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jayjaytee.planetreego.PlanetReego;
import org.jayjaytee.planetreego.enums.MESSAGES;
import org.jayjaytee.planetreego.items.managers.ItemManager;
import org.jayjaytee.planetreego.utils.NumberUtils;

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

        // /item (player) (minecraft/item/generator) (item) (amount)

        if(args.length == 3 || args.length == 4){
            Player player = Bukkit.getServer().getPlayer(args[0]);
            if(player == null){
                sender.sendMessage("§cThat player isn't online!");
                return true;
            }

            if(args[1].equalsIgnoreCase("minecraft")){
                if(Material.matchMaterial(args[2]) == null){
                    sender.sendMessage("§cThat item doesn't exist!");
                    return true;
                }
                if(args.length == 4){
                    if(!NumberUtils.isInt(args[3])){
                        sender.sendMessage("§cThe amount must be a number!");
                        return true;
                    }
                    if(Integer.parseInt(args[3]) >= 2304){
                        sender.sendMessage("§cThe number must be smaller than 2304!");
                        return true;
                    }
                    player.getInventory().addItem(new ItemStack(Material.matchMaterial(args[2]), Integer.parseInt(args[3])));
                    player.sendMessage("§a§l+ §f" + args[2].toUpperCase() + "§7 (x" + args[3] + "§7)");
                    sender.sendMessage("§aSuccessfully given " + player.getDisplayName() + " §f" + args[2].toUpperCase() + "§7 (x"+args[3]+"§7)");
                }else if(args.length == 3){
                    player.getInventory().addItem(new ItemStack(Material.matchMaterial(args[2])));
                    player.sendMessage("§a§l+ §f" + args[2].toUpperCase());
                    sender.sendMessage("§aSuccessfully given " + player.getDisplayName() + " §f" + args[2].toUpperCase());
                }
                return true;
            }else if(args[1].equalsIgnoreCase("item")){
                if(!ItemManager.item.containsKey(args[2].toUpperCase())){
                    sender.sendMessage("§cThat item doesn't exist!");
                    return true;
                }
                if(args.length == 4){
                    if(!NumberUtils.isInt(args[3])){
                        sender.sendMessage("§cThe amount must be a number!");
                        return true;
                    }
                    if(Integer.parseInt(args[3]) >= 2304){
                        sender.sendMessage("§cThe number must be smaller than 2304!");
                        return true;
                    }
                    for(int i = 0; i < Integer.parseInt(args[3]); i++){
                        player.getInventory().addItem((ItemManager.item.get(args[2].toUpperCase())));
                    }
                    player.sendMessage("§a§l+ §f" + args[2].toUpperCase() + "§7 (x" + args[3] + "§7)");
                    sender.sendMessage("§aSuccessfully given " + player.getDisplayName() + " §f" + args[2].toUpperCase() + "§7 (x"+args[3]+"§7)");
                }else if(args.length == 3){
                    player.getInventory().addItem(ItemManager.item.get(args[2].toUpperCase()));
                    player.sendMessage("§a§l+ §f" + args[2].toUpperCase());
                    sender.sendMessage("§aSuccessfully given " + player.getDisplayName() + " §f" + args[2].toUpperCase());
                }
                return true;
            }else{
                sender.sendMessage("§cIncorrect Usage! /item (player) (minecraft/item/generator) (item) [amount]");
                return true;
            }
        }

        sender.sendMessage("§cIncorrect Usage! /item (player) (minecraft/item/generator) (item) [amount]");
        return true;
    }
}
