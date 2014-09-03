/*
 * 版    权：深圳市快播科技有限公司
 * 描    述: 
 * 创建人: HuQiming
 * 创建时间: 2014-4-20
 * 
 */
package com.reque.here.core.anchor.scan.wifi;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;

import com.reque.utils.Log;

/**
 * @author HuQiming
 * @date 2014-4-20
 * 
 */
public class WifiScanner {
	private static final String TAG = "WifiScanner";
	private static final long DEFAULT_SCAN_INTERVAL = 30000;
	private static final long DEFAULT_NOTIFY_INTERVAL = 30000;
	private Context mContext;
	private WifiManager mWifiManager;
	private WifiScanListener mWifiScanListener;
	private long mScanInterval = DEFAULT_SCAN_INTERVAL;
	private long mNotifyInterval = DEFAULT_NOTIFY_INTERVAL;
	private WifiReceiver mReceiver;
	private Handler mWorkHandler;
	private HandlerThread mWorkThread;
	private volatile boolean mScanning = false;
	private volatile long mLastNotifyTime = 0;

	public WifiScanner(Context ctx) {
		mContext = ctx;
		mWifiManager = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
	}

	public void startScan() {
		Log.d(TAG, "startScan: " + mScanning);
		if (mScanning) {
			return;
		}
		mScanning = false;
		initWorkHandler();
		registerReceiver();
		scanSchedule();
	}

	public void stopScan() {
		Log.d(TAG, "stopScan: " + mScanning);
		mScanning = false;
		unRegisterReceiver();
		releaseWorkHandler();
	}

	private void scanSchedule() {
		Log.d(TAG, "scanSchedule mScanning: " + mScanning);
		if (!mScanning) {
			return;
		}
		mWifiManager.startScan();
		mWorkHandler.postDelayed(new Runnable() {

			@Override
			public void run() {
				scanSchedule();
			}
		}, mScanInterval);
	}

	public List<ScanResult> getScanResult() {
		return mWifiManager.getScanResults();
	}

	/**
	 * 设置扫描间隔，单位：毫秒
	 * 
	 * @param interval
	 */
	public void setScanInterval(long interval) {
		if (interval > 0) {
			mScanInterval = interval;
		}
	}

	/**
	 * 设置通知间隔，单位：毫秒
	 * 
	 * @param interval
	 */
	public void setHandleInterval(long interval) {
		if (interval > 0) {
			mScanInterval = interval;
		}
	}

	public void setWifiScanListener(WifiScanListener l) {
		mWifiScanListener = l;
	}

	private void initWorkHandler() {
		releaseWorkHandler();
		mWorkThread = new HandlerThread(TAG);
		mWorkThread.start();
		mWorkHandler = new Handler(mWorkThread.getLooper());
	}

	private void releaseWorkHandler() {
		if (mWorkHandler != null) {
			mWorkHandler.removeCallbacksAndMessages(null);
			mWorkHandler = null;
		}

		if (mWorkThread != null) {
			mWorkThread.quit();
			mWorkThread = null;
		}
	}

	private void registerReceiver() {
		if (mReceiver == null) {
			mReceiver = new WifiReceiver();
		}
		IntentFilter filter = new IntentFilter();
		filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
		mContext.registerReceiver(mReceiver, filter);
	}

	private void unRegisterReceiver() {
		if (mReceiver != null) {
			mContext.unregisterReceiver(mReceiver);
			mReceiver = null;
		}
	}

	/**
	 * 通知扫描结果
	 */
	private void notifyScanResult() {
		if (mWifiScanListener == null) {
			return;
		}
		long currTime = System.currentTimeMillis();
		if (currTime - mLastNotifyTime < mNotifyInterval) {
			Log.d(TAG, "notifyScanResult 通知时间间隔太短: " + currTime);
			return;
		}
		mLastNotifyTime = currTime;
		mWifiScanListener.onWifiScanResult(mWifiManager.getScanResults());
	}

	private class WifiReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
				notifyScanResult();
			}
		}
	}

	public interface WifiScanListener {
		void onWifiScanResult(List<ScanResult> result);
	}
}
