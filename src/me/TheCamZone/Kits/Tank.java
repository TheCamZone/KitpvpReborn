package me.TheCamZone.Kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.TheCamZone.Engine.Main;

public class Tank implements Kit {

	private Boolean enabled = true;
	private Boolean free = false;
	
	@Override
	public String getName() {
		return "Tank";
	}

	@Override
	public String getPermission() {
		return "kitpvp.tank";
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
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		boots = Main.plugin.getKitHandler().setUnbreakable(boots, true);
		
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		leggings = Main.plugin.getKitHandler().setUnbreakable(leggings, true);
		
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		chestplate = Main.plugin.getKitHandler().setUnbreakable(chestplate, true);
		
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		helmet = Main.plugin.getKitHandler().setUnbreakable(helmet, true);
		
		return new ItemStack[] { boots, leggings, chestplate, helmet };
	}

	@Override
	public ItemStack[] tools() {
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword = Main.plugin.getKitHandler().setUnbreakable(sword, true);
		sword = Main.plugin.getKitHandler().addEnchantment(sword, Enchantment.DAMAGE_ALL, 1, true);
		
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
		PotionEffect slow = new PotionEffect(PotionEffectType.SLOW, 1000000, 2, true, true);
		PotionEffect jump = new PotionEffect(PotionEffectType.JUMP, 1000000, -1, true, true);
		
		return new PotionEffect[] { slow, jump };
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
