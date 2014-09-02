package com.reque.here.core.anchor.model;

import android.os.Parcel;

public class Beacon extends Anchor {
	public static final int DESC_BEACON = 2;
	private String uuid;
	private String major;
	private String minor;
	private String mac;
	private int power;
	private int rssi;

//	@Override
//	public String getUniqueId() {
//		return uuid;
//	}
//
//	@Override
//	public String getMacAddress() {
//		return mac;
//	}

	public String getMajor() {
		return major;
	}

	public String getMinor() {
		return minor;
	}

	public int getPower() {
		return power;
	}

	public int getRssi() {
		return rssi;
	}

	public String getUuid() {
		return uuid;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setRssi(int rssi) {
		this.rssi = rssi;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

//	@Override
//	public void readFromParcel(Parcel source) {
//		this.power = source.readInt();
//		this.rssi = source.readInt();
//		this.uuid = source.readString();
//		this.mac = source.readString();
//		this.major = source.readString();
//		this.minor = source.readString();
//	}

}
