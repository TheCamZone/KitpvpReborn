package me.TheCamZone.Kits;

import java.util.HashMap;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import net.md_5.bungee.api.ChatColor;

public class KitHandler {

	private HashMap<String, Kit> kits = new HashMap<String, Kit>();
	
	private Pvp pvp = new Pvp();
	private Archer archer = new Archer();
	private Tank tank = new Tank();
	private Strafe strafe = new Strafe();
	private Berserker berserker = new Berserker();
	
	public void load() { 
		kits.put("pvp", pvp);
		kits.put("archer", archer);
		kits.put("tank", tank);
		kits.put("strafe", strafe);
		kits.put("berserker", berserker);
	}
	
	public HashMap<String, Kit> getKits() {
		HashMap<String, Kit> tempKits = kits;
		return tempKits;
	}
	
	public ItemStack addEnchantment(ItemStack item, Enchantment enchant, Integer level, Boolean unsafeEnchant) {
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.addEnchant(enchant, level, unsafeEnchant);
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	public ItemStack setUnbreakable(ItemStack item, Boolean bool) {
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setUnbreakable(bool);
		
		item.setItemMeta(itemMeta);
		return item;
	}
	
	public String getKitColors(Player player) {
		String coloredKits = ChatColor.GRAY + "";
		
		int max = kits.values().size();
		int iteration = 1;
		
		for(Kit kit : kits.values()) {
			if(player.hasPermission(kit.getPermission())) {
				coloredKits = coloredKits + ChatColor.GREEN + kit.getName();
			} else {
				coloredKits = coloredKits + ChatColor.RED + kit.getName();
			}
			
			if(iteration < max) {
				coloredKits = coloredKits + ChatColor.GRAY + ", ";
			}
			
			iteration++;
		}
		
		return coloredKits;
	}
	
	public Kit getKit(String kitName) {
		return kits.get(kitName);
	}
	
	public void giveKit(Player player, String kitName) {
		player.getInventory().clear();
		
		Kit kit = kits.get(kitName);
		PlayerInventory inv = player.getInventory();
		
		for(PotionEffect active : player.getActivePotionEffects()) {
			player.removePotionEffect(active.getType());
		}
		
		if(kit.armor() != null) {
			inv.setArmorContents(kit.armor());
		}
		
		if(kit.tools() != null) {
			inv.addItem(kit.tools());
		}

		if(kit.inventoryItems() != null) {
			Integer start = 9;
			for(ItemStack item : kit.inventoryItems()) {
				inv.setItem(start, item);
				start++;
			}
		}
	
		if(kit.fill() != null) {
			while(player.getInventory().firstEmpty() != -1) {
				inv.addItem(kit.fill());
			}
		}
		
		if(kit.effects() != null) {
			for(PotionEffect effect : kit.effects()) {
				player.addPotionEffect(effect);
			}
		}
	}
	
}
