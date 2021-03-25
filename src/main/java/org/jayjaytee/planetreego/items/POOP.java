package org.jayjaytee.planetreego.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jayjaytee.planetreego.libs.ItemBuilder;

public class POOP {
    public static ItemStack getItem(){
        ItemStack item = new ItemBuilder(Material.WOOL, 1, (byte) 12)
                .addEnchantment(Enchantment.LURE, 1)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                .setName("§a§lPoop!")
                .addLore(
                        " ",
                        "§c§lADMIN ITEM")
                .build();
        return item;
    }
}
