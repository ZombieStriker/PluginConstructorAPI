package me.zombie_striker.pluginconstructor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ProxieHelper {
	HashMap<String, Integer> proxies = new HashMap<>();

	public ProxieHelper(Plugin c) {
		new BukkitRunnable() {
			public void run() {
				Pattern IP_PATTERN = Pattern
						.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
				List<String> list = WebsiteParserer
						.getHRefs("http://proxy-daily.com/");
				for (String urlpages : list) {
					// We should not have to worry about updating the code for
					// the next century
					if (urlpages.contains("/20")) {
						System.out.println(urlpages);
						List<String> textOnPages = WebsiteParserer
								.getTextPreserveLines(urlpages);
						boolean containsIPs = false;
						for (String eachLine : textOnPages) {
							Matcher matcher = IP_PATTERN.matcher(eachLine);
							boolean lineContainsIP = matcher.find();
							if (lineContainsIP) {
								// The split will remove the extra text the
								// comes after the last IP.
								String ip = eachLine.split("</p")[0];
								try{
								proxies.put(ip.split(":")[0],Integer.parseInt(ip.split(":")[1]));
								}catch(Exception e){}
								containsIPs = true;
							}
						}
						if (!containsIPs) {
							// None lines on the page contains an IP.
							System.out.println("empty link");
						}
						if(proxies.size() > 100)break;
					}

				}
			}
		}.runTaskLaterAsynchronously(c, 1);
	}
	
	@SuppressWarnings("unchecked")
	public HttpURLConnection connect(URL url,int entry,String agent){
		//Proxy instance, proxy ip = 123.0.0.1 with port 8080
		Entry<String, Integer> ip = (Entry<String, Integer>) proxies.entrySet().toArray()[entry];			
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip.getKey(), ip.getValue()));
		try {
		HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
		uc.addRequestProperty("User-Agent", agent);
		uc.connect();
		return uc;
		} catch (IOException e) {
			e.printStackTrace();
		}return null;
	}
}
