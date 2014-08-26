package com.reque.here.core.anchor.model;

public class WifiHotspot extends Anchor {
	private String mac;
	private String ssid;

	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	
	@Override
	public String getUniqueId() {
		return mac;
	}

	@Override
	public String getMacAddress() {
		return mac;
	}

}
