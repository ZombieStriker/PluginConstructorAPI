/*
 *  Copyright (C) 2016 Zombie_Striker
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

import org.bukkit.entity.Player;
import org.bukkit.map.*;

public class CustomImageRenderer extends MapRenderer {

	private BufferedImage[] image;
	private int frameCount = 0;
	private int cTicks = 550;
	private int ticks = 0;
	public static int TICK_FOR_STILLS = 500;

	public CustomImageRenderer(BufferedImage[] bi, int ticks) {
		super(true);
		this.image = bi;
		this.ticks = ticks;
	}

	public CustomImageRenderer(BufferedImage bi, int ticks) {
		super(true);
		this.image = new BufferedImage[1];
		image[0] = bi;
		this.ticks = ticks;
	}

	// maps update multiple times per second.
	// for still images, set ticks to 100;
	@Override
	public void render(MapView view, MapCanvas canvas, Player player) {
		if (cTicks >= ticks) {
			if (image != null && image[frameCount] != null)
				canvas.drawImage(0, 0, image[frameCount]);
			frameCount = (frameCount + 1);// % image.length;
			if (frameCount >= image.length)
				frameCount = 0;
			cTicks = 0;
		}
		cTicks++;
	}

}
