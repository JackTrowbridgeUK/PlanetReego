package org.jayjaytee.planetreego.buildings.generators;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jayjaytee.planetreego.libs.ItemBuilder;
import org.jayjaytee.planetreego.utils.StringUtils;

public class Generator {
    public static ItemStack getItem(Material type){
        return new ItemBuilder(type, 1)
                .addNBT("gen", type.toString())
                .addNBT("type", "generator")
                .setName("&a" + StringUtils.formatString(type.toString()) + " Generator")
                .addLore("&8Generator")
                .addLore(" ")
                .addLore("&ePlace on ground")
                .build();
    }
}
