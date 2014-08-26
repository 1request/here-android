package com.reque.here.core.anchor.model;

public class Beacon extends Anchor {
	private String uuid;
	private String major;
	private String minor;
	private String mac;

	@Override
	public String getUniqueId() {
		return null;
	}

	@Override
	public String getMacAddress() {
		return null;
	}

}
