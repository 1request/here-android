package com.reque.here.core.anchor.model;

import android.os.Parcel;

public class Beacon extends Anchor {
	public static final int DESC_BEACON = 2;
	public String uuid;
	public String major;
	public String minor;
	public String mac;
	public int power;
	public int rssi;

	@Override
	public String getUniqueId() {
		return uuid;
	}

	@Override
	public String getMacAddress() {
		return mac;
	}

	@Override
	public int describeContents() {
		return DESC_BEACON;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
		dest.writeInt(power);
		dest.writeInt(rssi);
		dest.writeString(uuid);
		dest.writeString(mac);
		dest.writeString(major);
		dest.writeString(minor);
	}

	@Override
	public void readFromParcel(Parcel source) {
		this.power = source.readInt();
		this.rssi = source.readInt();
		this.uuid = source.readString();
		this.mac = source.readString();
		this.major = source.readString();
		this.minor = source.readString();
	}

}
