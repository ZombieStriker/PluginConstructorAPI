package me.zombie_striker.pluginconstructor;

import java.io.File;
import java.lang.reflect.Field;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.zombie_striker.pluginconstructor.privatemetrics.Metrics;
import me.zombie_striker.pluginconstructor.privateshop.PluginShop;

public class PluginConstructorAPI extends JavaPlugin {

	static Plugin instance;

	@Override
	public void onEnable() {
		instance = this;

		//If there was no update for github, check bukkitdev.
		if (! GithubUpdater.autoUpdate(this, "ZombieStriker", "PluginConstructorAPI", "PluginConstructorAPI.jar"))
			new Updater(this, 276723, getConfig().getBoolean("auto-update"));

		Metrics met = new Metrics(this);
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

	@SuppressWarnings("deprecation")
	public static int registerGlow() {
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int id = 334;
		try {
			while (true) {
				id++;
				if (Enchantment.getById(id) == null) {
					InWorldGlowEnchantment glow = new InWorldGlowEnchantment(id);
					if (Enchantment.getByName(glow.getName()) == null) {
						Enchantment.registerEnchantment(glow);
						return id;
					} else {
						return Enchantment.getByName(glow.getName()).getId();
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 334;

	}

	public static void loadCustomTextures(File resoucepackFolder) {
		RGBBlockColor.activateBlocks();
		RGBBlockColor.loadResourcepackTextures(resoucepackFolder);
	}
}
