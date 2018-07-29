/*
 *  Copyright (C) 2017 Zombie_Striker
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU General Public License as published by the Free Software Foundation; either version 2 of
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with this program;
 *  if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 *  02111-1307 USA
 */
package me.zombie_striker.pluginconstructor;

import java.awt.image.BufferedImage;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class MapWallUtil {

	/**
	 * Remember: The image has to be a multiple of 128
	 * 
	 * @param whole
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static ItemStack[][] getMaps(BufferedImage[] whole) {
		int frames = whole.length;
		int width = 0;
		int height = 0;
		for (int i = 0; i < whole.length; i++) {
			if (width < whole[i].getWidth())
				width = whole[i].getWidth();
			if (height < whole[i].getHeight())
				height = whole[i].getHeight();
		}
		int wd1 = (int) (0.999999999 + (((double) width) / 128));
		int hd1 = (int) (0.999999999+(((double) height) / 128));
		ItemStack[][] stacks = new ItemStack[wd1][hd1];
		if(wd1==0||hd1==0) {
			Bukkit.broadcast("Image is invalid. Width="+wd1+" Height="+hd1+".", "pluginconstructorapi.detectImage");
		}
		for (int x = 0; x < wd1; x++) {
			for (int y = 0; y < hd1; y++) {
				MapView mv = Bukkit.createMap(Bukkit.getWorlds().get(0));
				short mapIds = mv.getId();
				ItemStack is = new ItemStack(Material.MAP, 1, (short) mapIds);
				stacks[x][y] = is;
				for (MapRenderer mr : mv.getRenderers()) {
					mv.removeRenderer(mr);
				}
				BufferedImage[] bip = new BufferedImage[frames];
				for (int frame = 0; frame < frames; frame++) {
					if (x * 128 >= whole[frame].getWidth()) {
						continue;
					}
					int cW = 127;
					int cH = 127;
					//if ((x * 128) + cW == whole[frame].getWidth())
					//	continue;
					if ((x * 128) + cW > whole[frame].getWidth())
						cW = whole[frame].getWidth()-((x * 128));
					if ((y * 128) + cH > whole[frame].getHeight())
						cH = whole[frame].getHeight()-((y * 128)) ;
					if(cH<=0||cW<=0)
						continue;
					bip[frame] = whole[frame].getSubimage(x * 128, y * 128, cW, cH);
				}
				mv.addRenderer(new CustomImageRenderer(bip, ((frames > 1) ? 0 : CustomImageRenderer.TICK_FOR_STILLS)));

			}
		}
		return stacks;
	}

	public static void setBlockAt(Direction dir, final Player p, int height, int width, final ItemStack is) {
		Location loc = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY(),
				p.getLocation().getBlockZ());
		final Location frame_loc;
		final BlockFace bf;
		final Material type = Material.GLASS;
		switch (dir) {
		case UP_EAST:
			loc.add(width, height, 0);
			loc.getBlock().setType(type);
			frame_loc = loc.clone();
			frame_loc.setZ(loc.getZ() + 1);
			bf = BlockFace.EAST;
			break;
		case UP_WEST:
			loc.add(-width, height, 0);
			loc.getBlock().setType(type);
			frame_loc = loc.clone();
			frame_loc.setZ(loc.getZ() - 1);
			bf = BlockFace.WEST;
			break;
		case UP_NORTH:
			loc.add(0, height, -width);
			loc.getBlock().setType(type);
			frame_loc = loc.clone();
			frame_loc.setX(loc.getX() + 1);
			bf = BlockFace.NORTH;
			break;
		default:
			loc.add(0, height, width);
			loc.getBlock().setType(type);
			frame_loc = loc.clone();
			frame_loc.setX(loc.getX() - 1);
			bf = BlockFace.SOUTH;
			break;
		}
		if (frame_loc.getBlock().getType() != Material.AIR)
			frame_loc.getBlock().setType(Material.AIR);
		if (is != null)
			Bukkit.getScheduler().scheduleSyncDelayedTask(PluginConstructorAPI.getInstance(), new Runnable() {
				public void run() {
					ItemFrame i = (ItemFrame) p.getWorld().spawnEntity(frame_loc, EntityType.ITEM_FRAME);// .spawn(frame_loc,
																											// ItemFrame.class);
					i.setFacingDirection(bf);
					i.setItem(is);
				}
			}, 20);
	}
}
