package me.zombie_striker.pluginconstructor;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;

public class MaterialData implements ConfigurationSerializable {

	private Material m;
	private byte data;

	public MaterialData(Material m, byte data) {
		ConfigurationSerialization.registerClass(MaterialData.class);
		this.setMaterial(m);
		this.data = data;
	}

	public MaterialData(Material m) {
		ConfigurationSerialization.registerClass(MaterialData.class);
		this.setMaterial(m);
		this.data = 0;
	}

	public static MaterialData getMatDataByTypes(Material mat, byte data) {
		for (MaterialData key : RGBBlockColor.materialValue.keySet())
			if (key.getData() == data && key.getMaterial() == mat)
				return key;
		return null;
	}

	public byte getData() {
		return data;
	}

	public Material getMaterial() {
		return m;
	}

	public MaterialData(Map<String, Object> data) {
		this.setMaterial(Material.valueOf((String) data.get("m")));
		this.data = Byte.parseByte((String) data.get("data"));
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("m", this.getMaterial().toString());
		data.put("data", this.data + "");
		return data;
	}

	public void setMaterial(Material m) {
		this.m = m;
	}
}
