package com.reque.here.core.anchor.model;

import android.os.Parcel;

public class WifiHotspot extends Anchor {
	public static final int DESC_WIFI = 1;
	public String mac;
	public String ssid;
	public int signalLevel;
	public int level;

	@Override
	public String getUniqueId() {
		return mac;
	}

	@Override
	public String getMacAddress() {
		return mac;
	}

	@Override
	public int describeContents() {
		return DESC_WIFI;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
		dest.writeInt(level);
		dest.writeInt(signalLevel);
		dest.writeString(mac);
		dest.writeString(ssid);
	}

	@Override
	public void readFromParcel(Parcel source) {
		level = source.readInt();
		signalLevel = source.readInt();
		mac = source.readString();
		ssid = source.readString();
	}

}
