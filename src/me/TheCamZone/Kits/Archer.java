package me.TheCamZone.Kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import me.TheCamZone.Engine.Main;

public class Archer implements Kit {

	private Boolean enabled = true;
	private Boolean free = false;
	
	@Override
	public String getName() {
		return "Archer";
	}

	@Override
	public String getPermission() {
		// TODO Auto-generated method stub
		return "kitpvp.archer";
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
		
		ItemStack chestplate = new ItemStack(Material.GOLDEN_CHESTPLATE);
		chestplate = Main.plugin.getKitHandler().setUnbreakable(chestplate, true);
		
		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		helmet = Main.plugin.getKitHandler().setUnbreakable(helmet, true);
		
		return new ItemStack[] { boots, leggings, chestplate, helmet };
	}

	@Override
	public ItemStack[] tools() {
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword = Main.plugin.getKitHandler().setUnbreakable(sword, true);
		
		ItemStack bow = new ItemStack(Material.BOW);
		bow = Main.plugin.getKitHandler().addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, false);
		bow = Main.plugin.getKitHandler().addEnchantment(bow, Enchantment.ARROW_DAMAGE, 1, false);
		bow = Main.plugin.getKitHandler().addEnchantment(bow, Enchantment.ARROW_KNOCKBACK, 1, false);
		bow = Main.plugin.getKitHandler().setUnbreakable(bow, true);
		
		return new ItemStack[] { sword, bow };
	}

	@Override
	public ItemStack fill() {
		return new ItemStack(Material.MUSHROOM_STEW);
	}

	@Override
	public ItemStack[] inventoryItems() {
		ItemStack arrow = new ItemStack(Material.ARROW);
		
		return new ItemStack[] { arrow };
	}
	
	@Override
	public PotionEffect[] effects() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setEnabled(Boolean bool) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFree(Boolean bool) {
		// TODO Auto-generated method stub
		
	}

}
