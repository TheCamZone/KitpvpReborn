package me.TheCamZone.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.TheCamZone.Engine.Main;
import net.raidstone.wgevents.events.RegionLeftEvent;

public class OnRegionLeft implements Listener {

	@EventHandler
	public void onRegionLeave (RegionLeftEvent e) {
		if(e.getRegion().getId().equalsIgnoreCase("spawn")) {
			Player player = e.getPlayer();
			
			Main.plugin.getPlayerManager().get(player).setFallDamage(false);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
		        @Override
		        public void run() {
		        	Main.plugin.getPlayerManager().get(player).setFallDamage(true);
		        }
		    }, 40L);
			
		}
	}
	
}
