package me.TheCamZone.Handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.TheCamZone.Engine.Main;
import me.TheCamZone.Kits.Kit;

public class PlayerManager implements Listener {

	HashMap<UUID, OnlinePlayerClass> onlinePlayerClasses = new HashMap<UUID, OnlinePlayerClass>();
	
	public void add(Player player) {
		onlinePlayerClasses.put(player.getUniqueId(), new OnlinePlayerClass(player));
	}
	
	public void remove(Player player) {
		onlinePlayerClasses.remove(player.getUniqueId());
	}
	
	public OnlinePlayerClass get(Player player) {
		if(onlinePlayerClasses.get(player.getUniqueId()) == null) {
			add(player);
		}
		
		return onlinePlayerClasses.get(player.getUniqueId());
	}
	
	public Boolean setKit(Player player, String string) {
		if(string == null) {
			get(player).setKitName("None");
			player.getInventory().clear();
			return true;
		}
		
		if(!Main.plugin.getKitHandler().getKits().containsKey(string)) {
			return false;
		}
		
		Kit kit = Main.plugin.getKitHandler().getKit(string);
		
		get(player).setKitName(kit.getName());
		Main.plugin.getKitHandler().giveKit(player, string);
			
		return true;
	}
	
//	public OnlinePlayerClass get(UUID uuid) {
//		if(Bukkit.getPlayer(uuid) != null) {
//			return onlinePlayerClasses.get(uuid);
//		}
//		else {
//			
//		}
//		
//		return onlinePlayerClasses.get(player.getUniqueId());
//	}
	
	public String getDeathMessage(Player dead, DamageCause deathCause) {
		String cause;
		
		switch (deathCause) {
			case BLOCK_EXPLOSION:
				cause = dead.getName() + " [" + get(dead).getKit() + "] exploded."; break;
			case CONTACT:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was pricked to death."; break;
			case DRAGON_BREATH:
				cause = dead.getName() + " [" + get(dead).getKit() + "] roasted in dragon breath."; break;
			case DROWNING:
				cause = dead.getName() + " [" + get(dead).getKit() + "] drowned."; break;
			case ENTITY_EXPLOSION:
				cause = dead.getName() + " [" + get(dead).getKit() + "] exploded."; break;
			case ENTITY_SWEEP_ATTACK:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was collateralled."; break;
			case FALL:
				cause = dead.getName() + " [" + get(dead).getKit() + "] fell off a cliff."; break;
			case FALLING_BLOCK:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was smushed by an anvil."; break;
			case FIRE:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was incinerated."; break;
			case FIRE_TICK:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was burnt to a crisp."; break;
			case FLY_INTO_WALL:
				cause = dead.getName() + " [" + get(dead).getKit() + "] faceplanted into a wall."; break;
			case HOT_FLOOR:
				cause = dead.getName() + " [" + get(dead).getKit() + "] tried walking on hot coals."; break;
			case LAVA:
				cause = dead.getName() + " [" + get(dead).getKit() + "] fell in a lava hot-tub."; break;
			case LIGHTNING:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was smited by Zeus."; break;
			case MAGIC:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was cursed."; break;
			case POISON:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was poisoned to death."; break;
			case PROJECTILE:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was shot to death."; break;
			case STARVATION:
				cause = dead.getName() + " [" + get(dead).getKit() + "] starved to death."; break;
			case SUFFOCATION:
				cause = dead.getName() + " [" + get(dead).getKit() + "] sufficated."; break;
			case SUICIDE:
				cause = dead.getName() + " [" + get(dead).getKit() + "] committed suicide."; break;
			case THORNS:
				cause = dead.getName() + " [" + get(dead).getKit() + "]'s attack bounced off his target and they died from it."; break;
			case VOID:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was banished to the nether realm."; break;
			case WITHER:
				cause = dead.getName() + " [" + get(dead).getKit() + "] withered away."; break;
			default: 
				cause = dead.getName() + " [" + get(dead).getKit() + "] died."; break;
		}
		
		return cause;
	}
	
	public String getDeathMessage(Player killer, Player dead, DamageCause deathCause) {
		String cause;
		
		switch (deathCause) {
			case BLOCK_EXPLOSION:
				cause = dead.getName() + " [" + get(dead).getKit() + "] exploded while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case CONTACT:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was pricked to death while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case DRAGON_BREATH:
				cause = dead.getName() + " [" + get(dead).getKit() + "] roasted in dragon breath while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case DROWNING:
				cause = dead.getName() + " [" + get(dead).getKit() + "] drowned while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case ENTITY_EXPLOSION:
				cause = dead.getName() + " [" + get(dead).getKit() + "] exploded by " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case ENTITY_SWEEP_ATTACK:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was collateralled by " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case FALL:
				cause = dead.getName() + " [" + get(dead).getKit() + "] fell off a cliff while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case FALLING_BLOCK:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was smushed by an anvil while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case FIRE:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was incinerated while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case FIRE_TICK:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was burnt to a crisp while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case FLY_INTO_WALL:
				cause = dead.getName() + " [" + get(dead).getKit() + "] faceplanted into a wall while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case HOT_FLOOR:
				cause = dead.getName() + " [" + get(dead).getKit() + "] tried walking on hot coals while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case LAVA:
				cause = dead.getName() + " [" + get(dead).getKit() + "] fell in a lava hot-tub while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case LIGHTNING:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was smited by Zeus while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case MAGIC:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was cursed by " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case POISON:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was poisoned to death by " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case PROJECTILE:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was shot to death by " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case STARVATION:
				cause = dead.getName() + " [" + get(dead).getKit() + "] starved to death while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case SUFFOCATION:
				cause = dead.getName() + " [" + get(dead).getKit() + "] sufficated while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case SUICIDE:
				cause = dead.getName() + " [" + get(dead).getKit() + "] committed suicide to get away from " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case THORNS:
				cause = dead.getName() + " [" + get(dead).getKit() + "]'s attack bounced off " + killer.getName() + " [" + get(dead).getKit() + "] and he died from it."; break;
			case VOID:
				cause = dead.getName() + " [" + get(dead).getKit() + "] was banished to the nether realm by " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			case WITHER:
				cause = dead.getName() + " [" + get(dead).getKit() + "] withered away while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
			default: 
				cause = dead.getName() + " [" + get(dead).getKit() + "] died while fighting " + killer.getName() + " [" + get(killer).getKit() + "]"; break;
		}
		
		return cause;
	}
	
	public Collection<Entity> dropInventory(Player player) {
		Inventory inventory = player.getInventory();
		World world = player.getWorld();
		Location loc = player.getLocation();
		
		HashMap<Integer, ? extends ItemStack> all = inventory.all(Material.MUSHROOM_STEW);
		Collection<Entity> droppedItems = new ArrayList<Entity>();
		
		for(ItemStack item : all.values()) {
			Location newLoc = new Location(world, loc.getX() + ((Math.random() - 1)), loc.getY(), loc.getZ() + ((Math.random() - 1)));
			Entity droppedItem = world.dropItemNaturally(newLoc, item);
			droppedItems.add(droppedItem);
		}
		
		return droppedItems;
	}
	
}
