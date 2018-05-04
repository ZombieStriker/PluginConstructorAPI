package me.zombie_striker.pluginconstructor.privateshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.plugin.Plugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import me.zombie_striker.pluginconstructor.DependencyDownloader;
import me.zombie_striker.pluginconstructor.DependencyDownloader.Channel;

public class PluginShop {
	HashMap<String, Integer> supportedPlugins = new HashMap<String, Integer>();
	private String downloadURL;

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
		supportedPlugins.put("WorldChangeScreenRemover", 289776);
	}

	public Set<String> getAllPlugins() {
		return supportedPlugins.keySet();
	}

	public Collection<Integer> getAllPluginsIDS() {
		return supportedPlugins.values();
	}

	public void downloadPlugin(Plugin p, String plugin) {
		new DependencyDownloader(p, supportedPlugins.get(plugin));
	}

	private static final String HOST = "https://api.curseforge.com";
	private static final String QUERY = "/servermods/files?projectIds=";
	private static final String AGENT = "Mozilla/5.0 Dependency Downloader by Zombie_Striker";

	private List<Channel> allowedChannels = Arrays.asList(Channel.ALPHA, Channel.BETA, Channel.RELEASE);

	public void pingSite(int id) {
		String target = HOST + QUERY + id;
		try {
			URL url = new URL(target);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.addRequestProperty("User-Agent", AGENT);
			connection.connect();
			BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseBuffer = new StringBuilder();
			String line;
			while ((line = responseReader.readLine()) != null) {
				responseBuffer.append(line);
			}
			responseReader.close();
			String response = responseBuffer.toString();
			int counter = 1;
			if (connection.getResponseCode() == 200) {

				try {
					while (true) {
						JSONParser parser = new JSONParser();
						JSONArray json = (JSONArray) parser.parse(response);
						if (json.size() - counter < 0) {
							break;
							// :Should never happen, but keep it here just
							// in case
						}
						JSONObject latest = (JSONObject) json.get(json.size() - counter);
						String channel = (String) latest.get("releaseType");
						// String name = (String) latest.get("name");
						if (allowedChannels.contains(Channel.matchChannel(channel.toUpperCase()))
						/* && !hasTag(name) */) {
							downloadURL = ((String) latest.get("downloadUrl")).replace(" ", "%20");
							// downloadName = (String) latest.get("fileName");
							break;
						} else
							counter++;
					}
				} catch (ParseException e) {
					// p.getLogger().log(Level.SEVERE,
					// "Could not parse API Response for " + target, e);
				}
			}
		} catch (IOException e) {
		}

		try {
			downloadIsSeperateBecauseGotoGotRemoved();
		} catch (IOException e) {
			return;
		}
	}

	/**
	 * God damn it Gosling,
	 * <a href="http://stackoverflow.com/a/4547764/3809164">reference here.</a>
	 */
	private void downloadIsSeperateBecauseGotoGotRemoved() throws IOException {
		URL url = null;
		try {
			url = new URL(downloadURL);
		} catch (Exception e) {
			url = new URL("https://dev.bukkit.org/projects/pluginconstructorapi/files/2473165/download");
		}
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.addRequestProperty("User-Agent", AGENT);
		connection.connect();
		if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 400) {
			downloadURL = connection.getHeaderField("Location");
			downloadIsSeperateBecauseGotoGotRemoved();
		} else {
			// debug(connection.getResponseCode() + " "
			// + connection.getResponseMessage() + " when requesting "
			// + downloadURL);
			// IOUtils.readfu.readFully(connection.getInputStream(),new
			// byte[connection.lengt]);
			StringBuilder textBuilder = new StringBuilder();
			try (Reader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),
					Charset.forName(StandardCharsets.UTF_8.name())))) {
				int c = 0;
				while ((c = reader.read()) != -1) {
					textBuilder.append((char) c);
				}
			}
		}
	}
}
