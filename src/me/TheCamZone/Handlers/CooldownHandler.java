package me.TheCamZone.Handlers;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.TheCamZone.Engine.Main;

public class CooldownHandler {

	HashMap<UUID, Integer> cooldowns = new HashMap<UUID, Integer> ();
	HashMap<UUID, UUID> lifeIds = new HashMap<UUID, UUID> ();
	
	public void start() {
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				if(cooldowns.isEmpty()) {
					return;
				}
				
				for(UUID uuid : cooldowns.keySet()) {
					int timeleft = cooldowns.get(uuid);
					
					cooldowns.put(uuid, timeleft - 1);
					
					if(timeleft <= 0) {
						cooldowns.remove(uuid);
						
						if(Main.plugin.getPlayerManager().get(Bukkit.getPlayer(uuid)).getLifeId() == lifeIds.get(uuid)) {
							Bukkit.getPlayer(uuid).sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.GREEN + "Ability ready!");
							lifeIds.remove(uuid);
						}
						
						return;
					}
				}
				
			}
			
		}.runTaskTimer(Main.plugin, 0, 20);
		
	}
	
	public void setCooldown(Player player, Integer delay) {
		if(delay == null) {
			cooldowns.put(player.getUniqueId(), 0);
			lifeIds.put(player.getUniqueId(), Main.plugin.getPlayerManager().get(player).getLifeId());
		}
		
		cooldowns.put(player.getUniqueId(), delay);
	}
	
	public Integer getCooldown(Player player) {
		UUID uuid = player.getUniqueId();
		
		if(cooldowns.get(uuid) == null) {
			return 0;
		}
		
		return cooldowns.get(uuid);
	}
	
}
