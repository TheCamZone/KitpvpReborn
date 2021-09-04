package me.TheCamZone.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TheCamZone.Engine.Main;
import me.TheCamZone.Files.LocationsFile;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		
		if(!sender.hasPermission("kitpvp.admin")) {
			sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.RED + "You do not have permission to use this command.");
		}
		
		if(command.getName().equalsIgnoreCase("setspawn")) {
			Location loc = player.getLocation();
			
			LocationsFile.get().set("spawn", player.getWorld().getName() + ", " + Math.round(loc.getX() * 100) / 100 + ", " + Math.round(loc.getY() * 100) / 100 + ", " + Math.round(loc.getZ() * 100) / 100 + ", " + Math.round(loc.getYaw() * 100) / 100 + ", " + Math.round(loc.getPitch() * 100) / 100);
			LocationsFile.save();
			Main.plugin.getLocations().loadSpawn();
			sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.GRAY + "Spawn successfully set.");
		}
		return true;
	}

}
