package me.TheCamZone.Kits;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import me.TheCamZone.Engine.Main;

public class Berserker implements Kit {

	private Boolean enabled = true;
	private Boolean free = false;
	
	@Override
	public String getName() {
		return "Berserker";
	}

	@Override
	public String getPermission() {
		return "kitpvp.berserker";
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
		
		ItemStack leggings = new ItemStack(Material.GOLDEN_LEGGINGS);
		leggings = Main.plugin.getKitHandler().setUnbreakable(leggings, true);
		
		ItemStack chestplate = new ItemStack(Material.GOLDEN_CHESTPLATE);
		chestplate = Main.plugin.getKitHandler().setUnbreakable(chestplate, true);
		
		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		helmet = Main.plugin.getKitHandler().setUnbreakable(helmet, true);
		
		return new ItemStack[] { boots, leggings, chestplate, helmet };
	}

	@Override
	public ItemStack[] tools() {
		ItemStack axe = new ItemStack(Material.IRON_AXE);
		axe = Main.plugin.getKitHandler().setUnbreakable(axe, true);
		
		return new ItemStack[] { axe };
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
