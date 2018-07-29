package me.zombie_striker.pluginconstructor;

import java.io.File;
import java.lang.reflect.Field;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.zombie_striker.pluginconstructor.privatemetrics.Metrics;
import me.zombie_striker.pluginconstructor.privateshop.PluginShop;

public class PluginConstructorAPI extends JavaPlugin {

	static Plugin instance;
	
	static Enchantment glowEffect =null;

	@Override
	public void onEnable() {
		instance = this;

		Plugin thi = this;

		// RGBBlockColor.printOutLineFor(doorAc, Material.ACACIA_DOOR, 0);

		// We are no longer using bukkitdev. Github should be the main updater
		new BukkitRunnable() {

			@Override
			public void run() {
				if (GithubUpdater.autoUpdate(thi, "ZombieStriker", "PluginConstructorAPI", "PluginConstructorAPI.jar"))
					cancel();
			}
		}.runTaskTimer(this, 1, 20 * 60 * 60 * 24);
		// new Updater(this, 276723, getConfig().getBoolean("auto-update"));

		/* Metrics met = */ new Metrics(this);
		// shopcheck();
	}

	@Override
	public void onDisable() {
		instance = null;
	}

	public static Plugin getInstance() {
		return instance;
	}

	private PluginShop shop = new PluginShop();

	private String prefix = ChatColor.BLUE + "[PluginConstructorAPI]" + ChatColor.WHITE;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			sendHelp(sender);
		} else {
			if (args[0].equalsIgnoreCase("shop")) {
				if (sender.hasPermission("pluginconstructorapi.download")) {
					if (args.length == 1) {
						sender.sendMessage(prefix + " Please specify a plugin: ");
						StringBuilder sb = new StringBuilder();
						for (String s : shop.getAllPlugins())
							sb.append(s + ", ");
						sender.sendMessage(sb.toString());
						return true;
					}

					boolean exists = false;
					String gg = null;
					for (String g : shop.getAllPlugins())
						if (g.equalsIgnoreCase(args[1])) {
							exists = true;
							gg = g;
							break;
						}

					if (!exists) {
						sender.sendMessage(prefix + " The plugin \"" + args[1] + "\" does not exist");
						return true;
					}

					shop.downloadPlugin(this, gg);
					sender.sendMessage(prefix
							+ " Attempting to download the plugin. You may take a minute and may need a restart for the plugin to load correctly.");

				} else {
					sender.sendMessage(
							ChatColor.RED + " You do not have permission to download plugins for this server.");
				}
			}

			else {
				sendHelp(sender);
			}
		}
		return true;
	}

	public void sendHelp(CommandSender sender) {
		sender.sendMessage("---===+ PluginConstructorAPI +===---");
		sender.sendMessage("/PCAPI shop: Access all plugins that the server can download");
	}

	@SuppressWarnings("unused")
	private void shopcheck() {
		int k = 0;
		for (int i : shop.getAllPluginsIDS()) {
			k++;
			new BukkitRunnable() {
				@Override
				public void run() {
					shop.pingSite(i);
				}
			}.runTaskTimerAsynchronously(PluginConstructorAPI.instance, (15 * 60 * 20) + (k * 40), 30 * 60 * 20);
		}
	}
	@Deprecated
	public static int registerGlow() {
		return 0;
	}

	@SuppressWarnings("deprecation")
	public static Enchantment registerGlowEnchantment() {
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(glowEffect!=null) {
			return glowEffect;
		}
		try {
			try {
				InWorldGlowEnchantment glow = new InWorldGlowEnchantment(
						new NamespacedKey(instance, "PluginConstructorAPI:Glow"));
				if (Enchantment.getByName(glow.getName()) == null) {
					Enchantment.registerEnchantment(glow);
				}
				glowEffect = glow;
				return glow;
			} catch (Error
					| Exception e45) {/*
										 * if (Enchantment.getById(id) == null) { InWorldGlowEnchantmentPre13 glow = new
										 * InWorldGlowEnchantmentPre13(id); if (Enchantment.getByName(glow.getName()) ==
										 * null) { Enchantment.registerEnchantment(glow); return id; } else { return
										 * Enchantment.getByName(glow.getName()).getId(); } }
										 */
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Enchantment.PROTECTION_ENVIRONMENTAL;

	}

	public static void loadCustomTextures(File resoucepackFolder) {
		RGBBlockColor.activateBlocks();
		RGBBlockColor.loadResourcepackTextures(resoucepackFolder);
	}
}
