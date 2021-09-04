package me.TheCamZone.Files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.TheCamZone.Engine.Main;
import net.md_5.bungee.api.ChatColor;

public class ConfigFile {
	
	private static File file;
	private static FileConfiguration customFile;
	
	// Generates file if not created.
	public static void setup()
	{
		file = new File(Main.plugin.getDataFolder(), "config.yml");
		
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			} catch (IOException e)
			{
				Bukkit.getServer().getConsoleSender().sendMessage("Could not create config.yml.");
			}
			
		}
		
		customFile = YamlConfiguration.loadConfiguration(file);
	}
	
	public static FileConfiguration get()
	{
		return customFile;
	}
	
	public static void save()
	{
		try
		{
			customFile.save(file);
		} catch (IOException e)
		{
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save config.yml.");
		}
		
	}
	
	public static void reload()
	{
		customFile = YamlConfiguration.loadConfiguration(file);
	}
	
}
