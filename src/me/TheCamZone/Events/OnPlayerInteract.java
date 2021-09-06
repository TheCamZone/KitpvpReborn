package me.TheCamZone.Events;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.TheCamZone.Engine.Main;

public class OnPlayerInteract implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		String kitName = Main.plugin.getPlayerManager().get(player).getKit();
		ItemStack item = e.getItem();
		
		if(item == null) { return; }
		
		if(kitName == "Berserker") {
			if(item.getType() == Material.IRON_AXE) {
				if(e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) { return; }
				
				if(Main.plugin.getCooldownHandler().getCooldown(player) == 0) {
					if(!Main.plugin.getRegionHandler().inProtectedRegion(player)) {
						Main.plugin.getCooldownHandler().setCooldown(player, 25);
						
						player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 160, 1));
						player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 160, 1));
						
						player.sendMessage(ChatColor.GREEN + "BERSERKER ACTIVE");
						
						UUID lifeId = Main.plugin.getPlayerManager().get(player).getLifeId();
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					        @Override
					        public void run() {
					        	if(Main.plugin.getPlayerManager().get(player).getKit() == "Berserker") {
					        		if(lifeId == Main.plugin.getPlayerManager().get(player).getLifeId()) {
					        			if(!Main.plugin.getRegionHandler().inProtectedRegion(player)) {
						        			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 1));
								        	player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1));
								        	
								        	player.sendMessage(ChatColor.RED + "You are worn out.");
					        			}
					        		}
					        	}
					        }
					    }, 160L);
					} else {
						player.sendMessage(Main.plugin.getCfg().getPrefix() + "You can't do that in this region.");
					}
				} else {
					player.sendMessage(Main.plugin.getCfg().getPrefix() + "Still on cooldown for " + Main.plugin.getCooldownHandler().getCooldown(player) + " seconds.");
				}
			}
		}
	}
	
}
