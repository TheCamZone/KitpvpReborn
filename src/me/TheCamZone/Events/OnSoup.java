package me.TheCamZone.Events;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OnSoup implements Listener {

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e) {
		if(e.getItem() == null) { return; }
		if(e.getPlayer() == null) { return; }
		if(e.getAction() == null) { return; }
		
		ItemStack item = e.getItem();
		Player player = e.getPlayer();
		Action action = e.getAction();
		Double health = player.getHealth();
		Double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
		Integer food = player.getFoodLevel();
		Integer maxFood = 20;
		
		if(item.getType() == Material.MUSHROOM_STEW) {
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				
				if(health.equals(maxHealth) && food.equals(maxFood)) { return; }
				
				if(health.equals(maxHealth)) {
					if((food + 7) > maxFood) {
						player.setFoodLevel(maxFood);
					} else {
						player.setFoodLevel(food + 7);
					}
				}
				
				else {
					if((health + 7) > maxHealth) {
						player.setHealth(maxHealth);
					}
					else {
						player.setHealth(health + 7);
					}
				}
				
				player.getInventory().setItemInMainHand(new ItemStack(Material.BOWL));
			}
		}
	}
	
}
