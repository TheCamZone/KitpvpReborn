package me.TheCamZone.Events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import me.TheCamZone.Engine.Main;

public class OnEntityDamage implements Listener {

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(!(e.getEntity() instanceof Player)) {
			return;
		}
		
		Player player = (Player) e.getEntity();
		DamageCause damageCause = e.getCause();
		Double damage = e.getDamage();
		
		if(Main.plugin.getPlayerManager().get(player).getKit().equalsIgnoreCase("Stomper")) {
			if(damageCause == DamageCause.FALL) {
				List<Entity> entities = player.getNearbyEntities(1.5, 1, 1.5);
				for(Entity entity : entities) {
					if(entity instanceof Player) {
						Player otherPlayer = (Player) entity;
						otherPlayer.damage(e.getDamage());
						
						if(damage >= otherPlayer.getHealth()) {
							Bukkit.broadcastMessage(Main.plugin.getCfg().getPrefix() + player.getName() + " [Stomper] stomped " + otherPlayer.getName() + " [" + Main.plugin.getPlayerManager().get(otherPlayer).getKit() + "]");
							Main.plugin.getPlayerManager().get(player).addKill();
							Main.plugin.getPlayerManager().get(otherPlayer).addDeath();
						}
					} else if(entity instanceof Damageable) {
						Damageable otherEntity = (Damageable) entity;
						otherEntity.damage(e.getDamage());
					}
				}
				
				e.setDamage(4);
			}
		}
		
		
		
	}
	
}
