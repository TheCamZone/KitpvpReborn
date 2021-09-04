package me.TheCamZone.Files;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class Locations {

	Location spawn;
	
	public void load() {
		loadSpawn();
	}
	
	public Boolean loadSpawn() {
		if(LocationsFile.get().getString("spawn") == null) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Spawn not defined.");
			return false;
		}
		
		String spawnString = LocationsFile.get().getString("spawn");
		
		String[] c1 = spawnString.split(",[ ]*");
		Location loc1 = new Location(Bukkit.getWorld(c1[0]), Double.parseDouble(c1[1]), Double.parseDouble(c1[2]), Double.parseDouble(c1[3]), (float) Double.parseDouble(c1[4]), (float) Double.parseDouble(c1[5]));
		spawn = loc1;
		return true;
	}
	
	public Location getSpawn() {
		if(spawn == null) {
			return null;
		}
		return spawn;
	}
	
}
