package me.TheCamZone.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class OnPlayerDropItem implements Listener {

	@EventHandler
	public void onDrop (PlayerDropItemEvent e) {
		Player player = e.getPlayer();
		
		ItemStack droppedItem = e.getItemDrop().getItemStack();
		
		if(droppedItem.getType() != Material.MUSHROOM_STEW && e.getItemDrop().getItemStack().getType() != Material.BOWL) {
			e.setCancelled(true);
			
			player.sendMessage(ChatColor.GREEN + "You might want to keep that!");
		}
	}
	
}
