package me.TheCamZone.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class OnPlayerPickupItem implements Listener {

	@EventHandler
	public void onPlayerPickup (EntityPickupItemEvent e) {
		if(!(e.getEntity() instanceof Player)) {
			return;
		}
		
		if(e.getItem().getItemStack().getType() == Material.BOWL) {
			e.setCancelled(true);
		}
	}
	
}
