/**
 * 
 */
package com.reque.here.core.anchor;

import java.util.List;

import android.content.Context;
import android.util.Log;

import com.reque.here.core.anchor.model.Anchor;
import com.reque.here.core.anchor.scan.IAnchorScanner.OnAnchorScanListener;
import com.reque.here.core.anchor.scan.wifi.WifiAnchorScanner;
import com.reque.here.core.notification.AnchorNotification;

/**
 * @author huqiming
 *
 */
public class AnchorMediator implements OnAnchorScanListener {
	private static final String TAG = "AnchorMediator";
	private static final int SCAN_INTERVAL = 1000 * 30;
	private WifiAnchorScanner mWifiScanner;
	private Context mContext;
	private AnchorNotification mNotification;

	/**
	 * 
	 */
	public AnchorMediator(Context context) {
		mContext = context;
	}

	public void init() {
		mWifiScanner = new WifiAnchorScanner(mContext);
		mWifiScanner.setScanListener(this);
		mWifiScanner.startScan(SCAN_INTERVAL);

		mNotification = new AnchorNotification(mContext);
	}

	public void release() {
		mWifiScanner.stopScan();
	}

	public List<? extends Anchor> getCurrentAnchors() {
		return mWifiScanner.getCurrentAnchors();
	}

	private void handleScannedAnchor() {
		Log.d(TAG, "handleScannedAnchor");
		mNotification.showScanAnchor();
		mWifiScanner.stopScan();
	}

	/* 
	 */
	@Override
	public void onAnchorScanned(List<? extends Anchor> anchors) {
		Log.d(TAG, "onAnchorScanned anchors: " + anchors);
		if (anchors != null && anchors.size() > 0) {
			handleScannedAnchor();
		}
	}
}
