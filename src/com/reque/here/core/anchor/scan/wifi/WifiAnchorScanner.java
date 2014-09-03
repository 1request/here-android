package com.reque.here.core.anchor.scan.wifi;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.util.Log;

import com.reque.here.core.anchor.model.Anchor;
import com.reque.here.core.anchor.model.WifiHotspot;
import com.reque.here.core.anchor.scan.IAnchorScanner;
import com.reque.here.core.anchor.scan.wifi.WifiScanner.WifiScanListener;

public class WifiAnchorScanner implements IAnchorScanner, WifiScanListener {
	private static final String TAG = "WifiScanner";
	private OnAnchorScanListener mListener;
	private WifiScanner mWifiScanner;

	public WifiAnchorScanner(Context context) {
		mWifiScanner = new WifiScanner(context);
	}
	
	/* 
	 */
	@Override
	public List<Anchor> getCurrentAnchors() {
		List<ScanResult> scanResults = mWifiScanner.getScanResult();
		List<WifiHotspot> anchors = wifisToAnchors(scanResults);
//		return anchors;
		return null;
	}

	@Override
	public void startScan(int interval) {
		mWifiScanner.setScanInterval(interval);
		mWifiScanner.setHandleInterval(interval);
		mWifiScanner.startScan();
	}

	@Override
	public void stopScan() {
		mWifiScanner.stopScan();
	}

	@Override
	public void setScanListener(OnAnchorScanListener l) {
		mListener = l;
	}

	/* 
	 */
	@Override
	public void onWifiScanResult(List<ScanResult> result) {
		Log.d(TAG, "onWifiScanResult result: " + result);
		if (mListener != null) {
			List<WifiHotspot> anchors = wifisToAnchors(result);
			mListener.onAnchorScanned(anchors);
		}
	}

	private List<WifiHotspot> wifisToAnchors(List<ScanResult> scanResults) {
		if (scanResults == null || scanResults.size() <= 0) {
			return null;
		}

		List<WifiHotspot> wifiHotspots = new ArrayList<WifiHotspot>(scanResults.size());
		for (ScanResult item : scanResults) {
			WifiHotspot wifi = WifiHotSpotUtil.scanResultToWifiHotSpot(item);
			wifiHotspots.add(wifi);
		}
		return wifiHotspots;
	}

}
