package org.jayjaytee.planetreego.foodbuff.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.jayjaytee.planetreego.PlanetReego;
import org.jayjaytee.planetreego.foodbuff.enums.FOODS;

public class FoodEatEvent implements Listener {

    PlanetReego plugin;
    public FoodEatEvent(PlanetReego plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void onEat(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        for(FOODS food : FOODS.values()){
            if(item.getType().equals(Material.valueOf(food.name()))){
                event.setCancelled(true);
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.setSaturation(food.saturation);
                player.setFoodLevel(player.getFoodLevel() + food.bar);
                return;
            }
        }

        player.sendMessage("§cThis is not a registered food! Please contact a developer.");
        event.setCancelled(true);

    }

}
