package org.jayjaytee.planetreego.items.managers;

import org.bukkit.inventory.ItemStack;
import org.jayjaytee.planetreego.items.Poop;

import java.util.HashMap;

public class ItemManager {

    public static HashMap<String, ItemStack> item = new HashMap<>();

    public static void registerItems(){
        item.put("POOP", Poop.getItem());
    }
}
