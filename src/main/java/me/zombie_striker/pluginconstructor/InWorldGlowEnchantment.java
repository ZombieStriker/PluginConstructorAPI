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

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class InWorldGlowEnchantment extends Enchantment{
	
	  public InWorldGlowEnchantment (NamespacedKey id) {
	      super(id);
	  }
	 
	  @Override
	  public boolean canEnchantItem(ItemStack arg0) {
	      return true;
	  }
	 
	  @Override
	  public boolean conflictsWith(Enchantment arg0) {
	      return false;
	  }
	 
	  @Override
	  public EnchantmentTarget getItemTarget() {
	      return null;
	  }
	 
	  @Override
	  public int getMaxLevel() {
	      return 10;
	  }
	 
	  @Override
	  public String getName() {
	      return ". ";
	  }
	 
	  @Override
	  public int getStartLevel() {
	      return 0;
	  }

	
	public boolean isCursed() {
		return false;
	}

	
	public boolean isTreasure() {
		return false;
	}
}
