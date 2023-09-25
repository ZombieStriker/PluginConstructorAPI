package me.zombie_striker.pluginconstructor;

import org.bukkit.Location;

public class ObjectRotator {

	/**
	 * Returns a location that is rotated based on the yaw. Note: Yaw=0 or
	 * Yaw=360 points towards the east.
	 * 
	 * @param center
	 *            The center of the object. (If you want the object to rotate around the player, this should be equal to the player's location)
	 * @param xRelative
	 *            The X value relative to the center location
	 * @param yRelative
	 *            The Y value relative to the center location
	 * @param zRelative
	 *            The Z value relative to the center location
	 * @param yaw
	 *            The rotation of the object. Range is 0 to 360.
	 * @return The location that has been rotated
	 */
	public static Location getTranslation(Location center, double xRelative, double yRelative,
			double zRelative, float yaw) {
		Location particle = center.clone();
		double xloc = (xRelative * Math.cos((yaw * Math.PI) / 180)) + (zRelative * Math.sin((yaw * Math.PI) / 180));
		double zloc = (zRelative * Math.sin((yaw * Math.PI) / 180)) + (xRelative * Math.cos((yaw * Math.PI) / 180));
		particle.add(xloc, yRelative, zloc);
		return particle;
	}

}
