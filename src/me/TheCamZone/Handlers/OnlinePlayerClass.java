package me.TheCamZone.Handlers;

import java.util.UUID;

import org.bukkit.entity.Player;

import me.TheCamZone.Files.DataFile;

public class OnlinePlayerClass {

	UUID uuid;
	
	private String lastName;
	private String kit;
	private String lastKit;
	
	private Integer kills;
	private Integer deaths;
	private Integer killstreak;
	
	private UUID lifeId;
	private Boolean fallDamage = true;
	
	public OnlinePlayerClass(Player player) {
		uuid = player.getUniqueId();
		lastName = player.getName();
		
		if(DataFile.get().getString(uuid + ".lastName") == null) {
			DataFile.get().set(uuid + ".lastName", lastName);
		}
		
		if(DataFile.get().getString(uuid + ".lastKit") == null) {
			DataFile.get().set(uuid + ".lastKit", "None");
		}
		
		if(DataFile.get().getInt(uuid + ".kills") == 0) {
			DataFile.get().set(uuid + ".kills", 0);
		}
		
		if(DataFile.get().getInt(uuid + ".deaths") == 0) {
			DataFile.get().set(uuid + ".deaths", 0);
		}
		
		DataFile.save();
		
		lastKit = DataFile.get().getString(uuid + ".lastKit");
		
		kills = DataFile.get().getInt(uuid + ".kills");
		deaths = DataFile.get().getInt(uuid + ".deaths");
		
		refreshLifeId();
	}

	public void save() {
		DataFile.get().set(uuid + ".lastKit", lastKit);
		DataFile.get().set(uuid + ".kills", kills);
		DataFile.get().set(uuid + ".deaths", deaths);
		DataFile.save();
	}
	
	public UUID getLifeId() {
		return lifeId;
	}
	
	public UUID refreshLifeId() {
		UUID uuid = UUID.randomUUID();
		lifeId = uuid;
		return lifeId;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFallDamage(Boolean bool) {
		fallDamage = bool;
	}
	
	public Boolean getFallDamage() {
		return fallDamage;
	}
	
	public void setKitName(String name) {
		kit = name;
	}
	
	public String getKit() {
		if(kit == null) {
			return "None";
		}
		
		return kit;
	}

	public String getLastKit() {
		if(lastKit == null) {
			return "None";
		}
		
		return lastKit;
	}

	public Integer getKills() {
		if(kills == null) {
			return 0;
		}
		
		return kills;
	}

	public Integer getDeaths() {
		if(deaths == null) {
			return 0;
		}
		
		return deaths;
	}

	public Integer getKillstreak() {
		return killstreak;
	}

	public void addKill() {
		kills++;
		killstreak++;
	}
	
	public void addDeath() {
		deaths++;
		killstreak = 0;
	}
	
	public Double getKD() {
		return (double) Math.round((kills/deaths) * 100) / 100;
	}
}
