package me.TheCamZone.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.TheCamZone.Engine.Main;
import net.md_5.bungee.api.ChatColor;

public class Kit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		
		if(!sender.hasPermission("kitpvp.default")) {
			sender.sendMessage(Main.plugin.getCfg().getPrefix() + "You do not have permission to use this command.");
			return true;
		}
		
		if(command.getName().equalsIgnoreCase("kit")) {
			if(args.length == 0) {
				sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.translateAlternateColorCodes('&', "&7Syntax: /kit [KitName]"));
				sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.translateAlternateColorCodes('&', "&aGreen = Owned &8// &cRed = Unowned &8// &7Gray = Disabled"));
				sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.translateAlternateColorCodes('&', "&7Kits: " + Main.plugin.getKitHandler().getKitColors(player)));
			}
			
			if(args.length == 1) {
				if(Main.plugin.getKitHandler().getKits().containsKey(args[0])) {
					if(sender.hasPermission(Main.plugin.getKitHandler().getKit(args[0]).getPermission())) {
						if(Main.plugin.getPlayerManager().setKit(player, args[0].toLowerCase())) {
							sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.translateAlternateColorCodes('&', "&7Set kit to " + Main.plugin.getPlayerManager().get(player).getKit()));
						}
					} else {
						sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.translateAlternateColorCodes('&', "&cYou do not have that kit unlocked."));
					}
				} else {
					sender.sendMessage(Main.plugin.getCfg().getPrefix() + ChatColor.translateAlternateColorCodes('&', "&7The kit " + args[0] + " does not exist."));
				}
			}
		}
		return true;
	}

}
