package me.TheCamZone.Files;

import net.md_5.bungee.api.ChatColor;

public class Config {

	String prefix;
	
	public void load() {
		loadPrefix();
	}
	
	public void loadPrefix() {
		if(ConfigFile.get().getString("Messages.prefix") == null) {
			ConfigFile.get().set("Messages.prefix", "&4KitPvP &6> &7");
			ConfigFile.save();
		}
		
		prefix = ChatColor.translateAlternateColorCodes('&', ConfigFile.get().getString("Messages.prefix"));
	}
	
	public String getPrefix() {
		if(prefix == null) {
			return "null";
		}
		
		return prefix;
	}
	
}
