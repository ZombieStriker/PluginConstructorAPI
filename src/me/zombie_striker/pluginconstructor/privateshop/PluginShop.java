package me.zombie_striker.pluginconstructor.privateshop;

import java.util.HashMap;
import java.util.Set;

import org.bukkit.plugin.Plugin;

import me.zombie_striker.pluginconstructor.DependencyDownloader;

public class PluginShop {
	HashMap<String, Integer> supportedPlugins = new HashMap<String, Integer>();

	public PluginShop() {
		supportedPlugins.put("BackAgain", 101991);
		supportedPlugins.put("CBH", 91891);
		supportedPlugins.put("CreativeKills", 255131);
		supportedPlugins.put("Econstocks", 91294);
		supportedPlugins.put("Eventsounds", 93528);
		supportedPlugins.put("Landclaiming", 98632);
		supportedPlugins.put("Limitdrops", 101699);
		supportedPlugins.put("Limitspawns", 91185);
		supportedPlugins.put("LobbyAPI", 91206);
		supportedPlugins.put("LobbyAPIBA", 91619);
		supportedPlugins.put("LobbyAPISA", 91389);
		supportedPlugins.put("LobbyAPIWorlds", 91207);
		supportedPlugins.put("Loopcommands", 91944);
		supportedPlugins.put("marrageplus", 91924);
		supportedPlugins.put("mcMMOHorses", 61609);
		supportedPlugins.put("Music", 91836);
		supportedPlugins.put("NeuralNetworkAPI", 280241);
		supportedPlugins.put("NNSwearFilter", 280707);
		supportedPlugins.put("NoMobSuff", 258472);
		supportedPlugins.put("NPCAuctions", 277093);
		supportedPlugins.put("OverrideServer", 92579);
		supportedPlugins.put("PhysicsToggle", 275209);
		supportedPlugins.put("PixelPrinter", 98985);
		supportedPlugins.put("PlayerRecorder", 91724);
		supportedPlugins.put("PlayerTally", 92737);
		// supportedPlugins.put("PluginConstructAPI", 276723);
		// No reason to have a plugin download itself XD
		supportedPlugins.put("PracticePVP", 91795);
		supportedPlugins.put("QualityArmory", 278412);
		supportedPlugins.put("SellHeads", 91053);
		supportedPlugins.put("ServerInfo", 91387);
		supportedPlugins.put("ServerRestorer", 280536);
		supportedPlugins.put("SkyBlockLotto", 270414);
		supportedPlugins.put("TextToSpeech", 103001);
		supportedPlugins.put("TimeZones", 91804);
		supportedPlugins.put("UltimateHeadFinder", 92100);
		supportedPlugins.put("WishingWells", 281062);
	}

	public Set<String> getAllPlugins() {
		return supportedPlugins.keySet();
	}

	public void downloadPlugin(Plugin p, String plugin) {
		new DependencyDownloader(p, supportedPlugins.get(plugin));
	}
}
