package com.reque.here.core.anchor.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 标示地理位置的锚点，可以是WiFi热点，也可以是beacon设备
 * 
 * @author huqiming
 *
 */
public class Anchor implements Parcelable {

//	public abstract String getUniqueId();
//
//	public abstract String getMacAddress();
//
//	public abstract void readFromParcel(Parcel source);
	
	/**
	 * 
	 */
	public Anchor() {
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(describeContents());
	}

	public static final Parcelable.Creator<Anchor> CREATOR = new Parcelable.Creator<Anchor>() {

		@Override
		public Anchor createFromParcel(Parcel source) {
			int desc = source.readInt();
//			switch (desc) {
//			case Beacon.DESC_BEACON:
//				Beacon beacon = new Beacon();
//				beacon.readFromParcel(source);
//				return beacon;
//			case WifiHotspot.DESC_WIFI:
//				WifiHotspot wifi = new WifiHotspot();
//				wifi.readFromParcel(source);
//				return wifi;
//			default:
//				return null;
//			}
			return new Anchor();
		}

		@Override
		public Anchor[] newArray(int size) {
			return new Anchor[size];
		}
	};
}
