package me.TheCamZone.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.TheCamZone.Extras.SpongeLauncher;

public class OnPlayerMove implements Listener {

	SpongeLauncher sl = new SpongeLauncher();
	
	@EventHandler
	public void OnMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		
		Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
		
		if(block.getType() == Material.SPONGE) {
			sl.launch(player);
		} else {
			return;
		}
	}
	
}
