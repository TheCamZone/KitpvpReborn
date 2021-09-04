package me.TheCamZone.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;

public class OnInventoryClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
		if(e.getSlotType().equals(SlotType.ARMOR)) {
			e.setCancelled(true);
			
			player.sendMessage(ChatColor.GREEN + "You might want to keep that!");
		}
	}
	
}
