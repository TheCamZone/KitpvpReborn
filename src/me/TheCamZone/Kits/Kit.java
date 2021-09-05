package me.TheCamZone.Kits;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public interface Kit {
	
	Boolean enabled = true;
	Boolean free = false;
	
	public String getName();
	public String getPermission();
	public Boolean enabled();
	public Boolean free();
	
	public ItemStack[] armor();
	public ItemStack[] tools();
	public ItemStack fill();
	public ItemStack[] inventoryItems();
	
	public PotionEffect[] effects();
	
	void setEnabled(Boolean bool);
	void setFree(Boolean bool);
}
