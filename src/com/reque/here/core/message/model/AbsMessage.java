/**
 * 
 */
package com.reque.here.core.message.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author huqiming
 *
 */
public abstract class AbsMessage implements Parcelable {
	
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}

	public static final Parcelable.Creator<AbsMessage> CREATOR = new Parcelable.Creator<AbsMessage>() {

		@Override
		public AbsMessage createFromParcel(Parcel source) {
			return new AbsMessage() {
			};
		}

		@Override
		public AbsMessage[] newArray(int size) {
			return new AbsMessage[size];
		}
	};
}
