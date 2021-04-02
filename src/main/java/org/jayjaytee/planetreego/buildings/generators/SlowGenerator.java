package org.jayjaytee.planetreego.buildings.generators;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jayjaytee.planetreego.libs.ItemBuilder;
import org.jayjaytee.planetreego.utils.StringUtils;

public class SlowGenerator {
    public static ItemStack getItem(){
        return new ItemBuilder(Material.DROPPER, 1)
                .addNBT("gen", "slow")
                .addNBT("type", "generator")
                .setName("&7Slow Generator")
                .addLore("&8Generator")
                .addLore(" ")
                .addLore("&ePlace on ground")
                .build();
    }
}
