package com.reque.here.core.anchor.model;

/**
 * 标示地理位置的锚点，可以是WiFi热点，也可以是beacon设备
 * 
 * @author huqiming
 *
 */
public abstract class Anchor {
	public abstract String getUniqueId();

	public abstract String getMacAddress();
}
