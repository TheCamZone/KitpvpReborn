package me.TheCamZone.Events;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.TheCamZone.Engine.Main;

public class OnPlayerDeath implements Listener {

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		e.getDrops().clear();
		
		Player player = e.getEntity();
		Player killer = player.getKiller();
		DamageCause deathCause = player.getLastDamageCause().getCause();
		
		Collection<Entity> items = Main.plugin.getPlayerManager().dropInventory(player);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){
            @Override
            public void run(){
            	for(Entity e : items) {
            		e.remove();
            	}
            }
        }, 60L);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
	        @Override
	        public void run() {
	            player.spigot().respawn();
	            player.teleport(Main.plugin.getLocations().getSpawn());
	        }
	    }, 2L);
		
		e.setDeathMessage(null);
		
		if(killer == null) {
			String message = Main.plugin.getPlayerManager().getDeathMessage(player, deathCause.toString());
			if(message != null) {
				e.setDeathMessage(Main.plugin.getCfg().getPrefix() + message);
			}
			Main.plugin.getPlayerManager().get(player).addDeath();
		} else {
			String message = Main.plugin.getPlayerManager().getDeathMessage(killer, player, deathCause.toString());
			if(message != null) {
				e.setDeathMessage(Main.plugin.getCfg().getPrefix() + message);
			}
			Main.plugin.getPlayerManager().get(player).addDeath();
			Main.plugin.getPlayerManager().get(killer).addKill();
			Main.plugin.getPlayerManager().get(player).refreshLifeId();
		}
		
		Main.plugin.getCooldownHandler().setCooldown(player, 0);
		Main.plugin.getPlayerManager().setKit(player, null);
	}
	
}
