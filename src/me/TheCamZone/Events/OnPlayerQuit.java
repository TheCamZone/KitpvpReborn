package me.TheCamZone.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.TheCamZone.Engine.Main;

public class OnPlayerQuit implements Listener {

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		
		Main.plugin.getPlayerManager().remove(player);
		Main.plugin.getPlayerManager().get(player).save();
	}
	
}
