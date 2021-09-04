package me.TheCamZone.Extras;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SpongeLauncher {
	
	ArrayList<Block> connectedBlocks = new ArrayList<Block>();
	public void getConnectedBlocks(Block b1, final int x1, final int y1, final int z1, Material type, int maxSize) {
	    int searchCubeSize = 7;
	    if (connectedBlocks.size() >= maxSize) {
	        return;
	    }
	    for (int x = -1; x <= 1; x++) { //These 3 for loops check a 3x3x3 cube around the block in question
	        for (int y = -1; y <= 1; y++) {
	            for (int z = -1; z <= 1; z++) {
	                if (x == 0 && y == 0 && z == 0) { //We can skip the 0,0,0 case because that is the block in question
	                    continue;
	                }
	                
	                Block b2 = b1.getRelative(x, y, z);
	                int blockX = b2.getX();
	                int blockY = b2.getY();
	                int blockZ = b2.getZ();
	                if (blockX == x1 && blockY == y1 && blockZ == z1) { //Makes sure the original block is never added to veinOres
	                    continue;
	                }
	                
	                if (b2.getType().equals(type)) {
	                    if (blockX > x1 + searchCubeSize || blockX < x1 - searchCubeSize || blockY > y1 + searchCubeSize || blockY < y1 - searchCubeSize || blockZ > z1 + searchCubeSize || blockZ < z1 - searchCubeSize) {
	                        break;
	                    }
	                    
	                    else if (!(connectedBlocks.contains(b2))) {
	                        if (connectedBlocks.size() >= maxSize) {
	                            return;
	                        }
	                        
	                        connectedBlocks.add(b2);
                            this.getConnectedBlocks(b2, x1, y1, z1, type, maxSize);
	                    }
	                }
	            }
	        }
	    }
	}
	
	public void launch(Player player) {
		if(connectedBlocks.isEmpty()) {
			Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
			
			getConnectedBlocks(block, block.getX(), block.getY(), block.getZ(), Material.SPONGE, 100);
			
			Location loc1 = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
			Location loc2 = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 2, player.getLocation().getZ());
			
			Vector direction = loc2.toVector().subtract(loc1.toVector());
			
			player.setVelocity(direction.normalize().multiply(1));
		} else {
			Location loc1 = connectedBlocks.get(0).getLocation();
			Location loc2 = connectedBlocks.get(connectedBlocks.size() - 1).getLocation();
			
			Vector direction = loc1.toVector().subtract(loc2.toVector());
			
			player.setVelocity(direction.multiply(connectedBlocks.size() / 1.5));
			
			connectedBlocks.clear();
		}
		
	}
	
}
