package me.TheCamZone.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.TheCamZone.Engine.Main;

public class Kitpvp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("Kitpvp")) {
			if(args.length == 0) {
				sender.sendMessage(Main.plugin.getCfg().getPrefix() + "KitpvpReborn created by TheCamZone for The Zone Network.");
			}
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("reload")) {
					if(sender.hasPermission("kitpvp.admin")) {
						Main.plugin.getCfg().load();
						Main.plugin.getLocations().load();
						Main.plugin.getRegionHandler().load();
						
						sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.GREEN + "KitpvpReborn reloaded.");
					}
				}
			}
		}
		
		return true;
	}

}
