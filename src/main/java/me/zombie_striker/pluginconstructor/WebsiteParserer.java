package me.zombie_striker.pluginconstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebsiteParserer {

	public static List<String> getHRefs(String url) {
		List<String> list = new ArrayList<>();
		Scanner s = null;
		StringBuilder sb;
		Pattern pattern;
		Matcher matcher;
		try {

			URL downloadFrom = new URL(url);
			s = new Scanner(downloadFrom.openStream());
			sb = new StringBuilder();

			while (s.hasNext()) {
				sb.append(s.nextLine());
			}

			pattern = Pattern.compile("href=\"(.*?)\"", Pattern.DOTALL);
			matcher = pattern.matcher(sb.toString());

			while (matcher.find()) {
				list.add(matcher.group(1));
			}
			//In case the webpage using single quotes
			pattern = Pattern.compile("href='(.*?)'", Pattern.DOTALL);
			matcher = pattern.matcher(sb.toString());

			while (matcher.find()) {
				list.add(matcher.group(1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}			
		return list;
	}

	public static List<String> getHRefs2(String url) {
		List<String> list = new ArrayList<>();
		Scanner s = null;
		StringBuilder sb;
		Pattern pattern;
		Matcher matcher;
		try {

			URL downloadFrom = new URL(url);
			s = new Scanner(downloadFrom.openStream());
			sb = new StringBuilder();

			while (s.hasNext()) {
				sb.append(s.nextLine());
			}

			pattern = Pattern.compile("href=\"([^\"]*)\"", Pattern.DOTALL);
			matcher = pattern.matcher(sb.toString());

			while (matcher.find()) {
				list.add(matcher.group(1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}			
		return list;
	}

	public static List<String> getTextPreserveLines(String url) {
		List<String> list = new ArrayList<>();
		try {
			URL downloadList = new URL(url);
			URLConnection yc = downloadList.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					yc.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				String[] brbreaks = inputLine.split("<br />");
				for(String s2 : brbreaks)
				list.add(s2);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String getText(String url) {
		try {
			URL downloadList;
			downloadList = new URL(url);
			URLConnection yc = downloadList.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					yc.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine);
				sb.append("\n");
			}
			in.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
