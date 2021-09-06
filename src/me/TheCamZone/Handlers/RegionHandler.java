package me.TheCamZone.Handlers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;

import me.TheCamZone.Files.ConfigFile;

public class RegionHandler {
	
	List<String> protectedRegions;
	
	public Boolean checkPlayerInRegion(Player player, String regionName) {
		Location loc = BukkitAdapter.adapt(player.getLocation());
		RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
		RegionQuery query = container.createQuery();
		ApplicableRegionSet set = query.getApplicableRegions(loc);
		
		for (ProtectedRegion region : set) {
		  if(region.getId().equalsIgnoreCase(regionName)) {
			 return true;
		  }
		}
		
		return false;
	}
	
	public List<String> getPlayerRegions (Player player) {
		Location loc = BukkitAdapter.adapt(player.getLocation());
		RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
		RegionQuery query = container.createQuery();
		ApplicableRegionSet set = query.getApplicableRegions(loc);
		
		List<String> regions = new ArrayList<String>();
		for (ProtectedRegion region : set) {
			  regions.add(region.getId().toLowerCase());
		}
		return regions;
	}
	
	public Boolean inProtectedRegion(Player player) {
		for(String region : getPlayerRegions(player)) {
			if(getProtectedRegions().contains(region)) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<String> getProtectedRegions() {
		return protectedRegions;
	}
	
	public void loadProtectedRegions() {
		protectedRegions = ConfigFile.get().getStringList("regions.protectedRegions");
	}
	
	public void load() {
		loadProtectedRegions();
	}
}
