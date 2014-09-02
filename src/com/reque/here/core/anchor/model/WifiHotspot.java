package com.reque.here.core.anchor.model;

import android.os.Parcel;

public class WifiHotspot extends Anchor {
	public static final int DESC_WIFI = 1;
	private String mac;
	private String ssid;
	private int rssi;

	public void setMac(String mac) {
		this.mac = mac;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public void setRssi(int rssi) {
		this.rssi = rssi;
	}

//	@Override
//	public String getUniqueId() {
//		return mac;
//	}
//
//	@Override
//	public String getMacAddress() {
//		return mac;
//	}

	public int getRssi() {
		return rssi;
	}

	public String getSsid() {
		return ssid;
	}

	@Override
	public int describeContents() {
		return DESC_WIFI;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
		dest.writeInt(rssi);
		dest.writeString(mac);
		dest.writeString(ssid);
	}

//	@Override
//	public void readFromParcel(Parcel source) {
//		rssi = source.readInt();
//		mac = source.readString();
//		ssid = source.readString();
//	}

}
