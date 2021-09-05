package me.TheCamZone.Engine;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.TheCamZone.Commands.Kit;
import me.TheCamZone.Commands.KitTabCompleter;
import me.TheCamZone.Commands.SetSpawn;
import me.TheCamZone.Commands.Spawn;
import me.TheCamZone.Events.OnEntityDamage;
import me.TheCamZone.Events.OnInventoryClick;
import me.TheCamZone.Events.OnItemSpawn;
import me.TheCamZone.Events.OnPlayerDeath;
import me.TheCamZone.Events.OnPlayerDropItem;
import me.TheCamZone.Events.OnPlayerInteract;
import me.TheCamZone.Events.OnPlayerJoin;
import me.TheCamZone.Events.OnPlayerMove;
import me.TheCamZone.Events.OnPlayerPickupItem;
import me.TheCamZone.Events.OnPlayerQuit;
import me.TheCamZone.Events.OnSoup;
import me.TheCamZone.Files.Config;
import me.TheCamZone.Files.ConfigFile;
import me.TheCamZone.Files.DataFile;
import me.TheCamZone.Files.Locations;
import me.TheCamZone.Files.LocationsFile;
import me.TheCamZone.Handlers.CooldownHandler;
import me.TheCamZone.Handlers.PlayerManager;
import me.TheCamZone.Kits.KitHandler;
import me.TheCamZone.Placeholders.PAPIplaceholders;

public class Main extends JavaPlugin {

	public static Main plugin;
	
	private SetSpawn setSpawn = new SetSpawn();
	private Spawn spawn = new Spawn();
	private Kit kit = new Kit();
	
	private KitTabCompleter kitTabCompleter = new KitTabCompleter();
	
	private OnSoup onSoup = new OnSoup();
	private OnPlayerDeath onPlayerDeath = new OnPlayerDeath();
	private OnPlayerJoin onPlayerJoin = new OnPlayerJoin();
	private OnPlayerQuit onPlayerQuit = new OnPlayerQuit();
	private OnPlayerDropItem onPlayerDropItem = new OnPlayerDropItem();
	private OnInventoryClick onInventoryClick = new OnInventoryClick();
	private OnItemSpawn onItemSpawn = new OnItemSpawn();
	private OnPlayerPickupItem onPlayerPickupItem = new OnPlayerPickupItem();
	private OnPlayerMove onPlayerMove = new OnPlayerMove();
	private OnPlayerInteract onPlayerInteract = new OnPlayerInteract();
	private OnEntityDamage onEntityDamage = new OnEntityDamage();
	
	private PlayerManager playerManager = new PlayerManager();
	private KitHandler kitHandler = new KitHandler();
	private CooldownHandler cooldownHandler = new CooldownHandler();
	
	private Locations locations = new Locations();
	private Config config = new Config();
	
	public void onEnable() {
		plugin = this;
		
		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
		
		ConfigFile.setup();
		LocationsFile.setup();
		DataFile.setup();
		
		config.load();
		locations.load();
		
		kitHandler.load();
		cooldownHandler.start();
		
		getCommand("setspawn").setExecutor(setSpawn);
		getCommand("spawn").setExecutor(spawn);
		getCommand("kit").setExecutor(kit);
		
		getCommand("kit").setTabCompleter(kitTabCompleter);
		
		getServer().getPluginManager().registerEvents(onSoup, this);
		getServer().getPluginManager().registerEvents(onPlayerDeath, this);
		getServer().getPluginManager().registerEvents(playerManager, this);
		getServer().getPluginManager().registerEvents(onPlayerJoin, this);
		getServer().getPluginManager().registerEvents(onPlayerQuit, this);
		getServer().getPluginManager().registerEvents(onPlayerDropItem, this);
		getServer().getPluginManager().registerEvents(onInventoryClick, this);
		getServer().getPluginManager().registerEvents(onItemSpawn, this);
		getServer().getPluginManager().registerEvents(onPlayerPickupItem, this);
		getServer().getPluginManager().registerEvents(onPlayerMove, this);
		getServer().getPluginManager().registerEvents(onPlayerInteract, this);
		getServer().getPluginManager().registerEvents(onEntityDamage, this);
		
		if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
			new PAPIplaceholders(this).register();
		}
	}
	
	public PlayerManager getPlayerManager() {
		return playerManager;
	}
	
	public Config getCfg() {
		return config;
	}
	
	public Locations getLocations() {
		return locations;
	}

	public KitHandler getKitHandler() {
		return kitHandler;
	}
	
	public CooldownHandler getCooldownHandler() {
		return cooldownHandler;
	}
	
}
