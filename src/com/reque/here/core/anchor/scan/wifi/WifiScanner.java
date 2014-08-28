package com.reque.here.core.anchor.scan.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.reque.here.core.anchor.scan.IAnchorScanner;

public class WifiScanner implements IAnchorScanner {
	private static final String TAG = "WifiScanner";
	private OnAnchorScanListener mListener;
	private WifiManager mWifiManager;
	private Context mContext;
	private boolean mStartScan = false;
	private int mScanInterval;
	private WifiBroadcastReceiver mBroadcastReceiver;

	public WifiScanner(Context context) {
		mContext = context;
		mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
	}

	private void regBroadcast() {
		mBroadcastReceiver = new WifiBroadcastReceiver();
		IntentFilter filter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
		filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
		mContext.registerReceiver(mBroadcastReceiver, filter);
	}

	private void unRegBroadcast() {
		if (mBroadcastReceiver != null) {
			mContext.unregisterReceiver(mBroadcastReceiver);
		}
	}

	@Override
	public void startScan(int interval) {
		mStartScan = true;
		mScanInterval = interval;
		if (mWifiManager.isWifiEnabled()) {
			performScan();
		}
	}

	private void performScan() {
		mWifiManager.startScan();
	}

	@Override
	public void stopScan() {
		mStartScan = false;
	}

	@Override
	public void setScanListener(OnAnchorScanListener l) {
		mListener = l;
	}

	private void wifiStateChange() {

	}

	private void wifiScanResults() {

	}

	private class WifiBroadcastReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			Log.d(TAG, "WifiBroadcastReceiver action: " + action);
			if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)) {
				wifiStateChange();
			} else if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
				wifiScanResults();
			}
		}
	}

}
