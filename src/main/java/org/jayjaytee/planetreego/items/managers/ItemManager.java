package org.jayjaytee.planetreego.items.managers;

import org.bukkit.inventory.ItemStack;
import org.jayjaytee.planetreego.items.POOP;

import java.util.HashMap;

public class ItemManager {

    public static HashMap<String, ItemStack> item = new HashMap<>();

    public static void registerItems(){
        item.put("POOP", POOP.getItem());
    }
}
