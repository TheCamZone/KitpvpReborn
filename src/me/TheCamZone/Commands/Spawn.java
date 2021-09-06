package me.TheCamZone.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TheCamZone.Engine.Main;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		
		if(!sender.hasPermission("kitpvp.default")) {
			sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.RED + "You do not have permission to use this command.");
		}
		
		if(Main.plugin.getLocations().getSpawn() == null) {
			sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.RED + "No spawn has been set up.");
		} else {
			player.teleport(Main.plugin.getLocations().getSpawn());
			Main.plugin.getPlayerManager().get(player).refreshLifeId();
		}
		return true;
	}

}
