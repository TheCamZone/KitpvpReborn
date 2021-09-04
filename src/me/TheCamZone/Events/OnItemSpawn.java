package me.TheCamZone.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

import me.TheCamZone.Engine.Main;

public class OnItemSpawn implements Listener {

	@EventHandler
	public void onItemSpawn(ItemSpawnEvent e) {
		if(e.getEntityType() != EntityType.DROPPED_ITEM) {
			return;
		}
		
		Item item = (Item) e.getEntity();
		if(item.getItemStack().getType() == Material.BOWL || item.getItemStack().getType() == Material.MUSHROOM_STEW) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
		        @Override
		        public void run() {
		        	item.remove();
		        }
		    }, 60L);
		}
	}
	
}
