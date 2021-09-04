package me.TheCamZone.Placeholders;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import me.TheCamZone.Engine.Main;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class PAPIplaceholders extends PlaceholderExpansion {

	@SuppressWarnings("unused")
	private Main plugin;
	
	public PAPIplaceholders(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public @NotNull String getAuthor() {
		return "TheCamZone";
	}

	@Override
	public @NotNull String getIdentifier() {
		return "kitpvp";
	}

	@Override
    public boolean persist(){
        return true;
    }
	
	@Override
	public @NotNull String getVersion() {
		return "0.0.1";
	}
	
	@Override
    public boolean canRegister(){
        return true;
    }
	
	@Override
    public String onPlaceholderRequest(Player p, String identifier) {

		if(p == null) { return ""; }
		
        if (identifier.equals("kills")) {
        	return Main.plugin.getPlayerManager().get(p).getKills() + "";
        }

        if (identifier.equals("deaths")) {
        	return Main.plugin.getPlayerManager().get(p).getDeaths() + "";
        }
        
        if (identifier.equals("killstreak")) {
        	return Main.plugin.getPlayerManager().get(p).getKillstreak() + "";
        }
        
        if (identifier.equals("kd")) {
        	return Main.plugin.getPlayerManager().get(p).getKD() + "";
        }

        return null;
    }

}
