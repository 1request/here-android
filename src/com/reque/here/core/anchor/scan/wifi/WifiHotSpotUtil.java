/*
 * 版    权：深圳市快播科技有限公司
 * 描    述: 
 * 创建人: HuQiming
 * 创建时间: 2014-4-21
 * 
 */
package com.reque.here.core.anchor.scan.wifi;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.reque.here.core.anchor.model.WifiHotspot;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

/**
 * @author HuQiming
 * @date 2014-4-21
 * 
 */
public class WifiHotSpotUtil {
	private static final String TAG = "WifiUtil";

	public static int calSignalLevel(int level) {
		return WifiManager.calculateSignalLevel(level, 4);
	}

	public static WifiHotspot scanResultToWifiHotSpot(ScanResult result) {
		if (result == null) {
			return null;
		}

		WifiHotspot hotSpot = new WifiHotspot();
		hotSpot.signalLevel = calSignalLevel(result.level);
		hotSpot.level = result.level;
		hotSpot.ssid = result.SSID;
		hotSpot.mac = result.BSSID;
		return hotSpot;
	}
}
