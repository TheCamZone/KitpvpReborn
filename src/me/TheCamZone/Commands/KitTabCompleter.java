package me.TheCamZone.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import me.TheCamZone.Engine.Main;

public class KitTabCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if(command.getName().equalsIgnoreCase("kit")) {
			if(args.length == 0) {
				return Arrays.asList("");
			}
			
			if(args.length == 1) {
				ArrayList<String> kits = new ArrayList<String>();
				
				for(me.TheCamZone.Kits.Kit kit : Main.plugin.getKitHandler().getKits().values()) {
					kits.add(kit.getName());
				}
				
				return kits;
			}
		}
		return null;
	}

}
