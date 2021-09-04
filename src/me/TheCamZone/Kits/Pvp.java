package me.TheCamZone.Kits;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import me.TheCamZone.Engine.Main;

public class Pvp implements Kit {

	private Boolean enabled = true;
	private Boolean free = false;
	
	@Override
	public String getName() {
		return "PvP";
	}

	@Override
	public String getPermission() {
		return "kitpvp.pvp";
	}

	@Override
	public Boolean enabled() {
		return enabled;
	}

	@Override
	public Boolean free() {
		return free;
	}

	@Override
	public ItemStack[] armor() {
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		boots = Main.plugin.getKitHandler().setUnbreakable(boots, true);
		
		ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		leggings = Main.plugin.getKitHandler().setUnbreakable(leggings, true);
		
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		chestplate = Main.plugin.getKitHandler().setUnbreakable(chestplate, true);
		
		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		helmet = Main.plugin.getKitHandler().setUnbreakable(helmet, true);
		
		return new ItemStack[] { boots, leggings, chestplate, helmet };
	}

	@Override
	public ItemStack[] tools() {
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword = Main.plugin.getKitHandler().setUnbreakable(sword, true);
		
		return new ItemStack[] { sword };
	}

	@Override
	public ItemStack fill() {
		return new ItemStack(Material.MUSHROOM_STEW);
	}

	@Override
	public ItemStack[] inventoryItems() {
		return null;
	}
	
	@Override
	public PotionEffect[] effects() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setEnabled(Boolean bool) {
		enabled = bool;
	}

	@Override
	public void setFree(Boolean bool) {
		free = bool;
	}

	

}
