/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.ui.activity.hotspots;

import java.util.List;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.BeaconManager.MonitoringListener;
import com.estimote.sdk.Region;
import com.reque.here.R;
import com.reque.here.ui.activity.BaseFragment;

/**
 *
 */
public class HotspotsFragment extends BaseFragment {
	private static final String TAG = "HotspotsFragment";
	private BeaconManager mBeaconManager;
	private static final String ESTIMOTE_PROXIMITY_UUID = "B9407F30-F5F8-466E-AFF9-25556B57FE6D";
	private static final String UUID_1 = "74278BDA-B644-4520-8F0C-720EAF059935";
	private static final String UUID_2 = "E2C56DB5-DFFB-48D2-B060-D0F5A71096E0";
	private static final Region ALL_ESTIMOTE_BEACONS = new Region("maikelong", UUID_2, null, null);

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView");
		View view = inflater.inflate(R.layout.test_layout, null);
		TextView test = (TextView) view.findViewById(R.id.test_text);
		test.setText(TAG);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		initBeacon();
	}

	@Override
	public void onStart() {
		super.onStart();
		startScan();
	}

	@Override
	public void onStop() {
		super.onStop();
		stopScan();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		release();
	}

	private void initBeacon() {
		mBeaconManager = new BeaconManager(getActivity());
		mBeaconManager.setRangingListener(new BeaconManager.RangingListener() {
			@Override
			public void onBeaconsDiscovered(Region region, List<Beacon> beacons) {
				Log.d(TAG, "Ranged beacons: " + beacons + " region: " + region);
			}
		});

		mBeaconManager.setMonitoringListener(new MonitoringListener() {

			@Override
			public void onExitedRegion(Region region) {
				Log.d(TAG, "onExitedRegion region: " + region);
			}

			@Override
			public void onEnteredRegion(Region region, List<Beacon> beacons) {
				Log.d(TAG, "onEnteredRegion region: " + region + " beacons: " + beacons);
			}
		});
	}

	private void startScan() {
		mBeaconManager.connect(new BeaconManager.ServiceReadyCallback() {
			@Override
			public void onServiceReady() {
				try {
					Log.d(TAG, "startRanging");
					mBeaconManager.startRanging(ALL_ESTIMOTE_BEACONS);
					mBeaconManager.startMonitoring(ALL_ESTIMOTE_BEACONS);
					// mBeaconManager.startRanging(null);
					// mBeaconManager.startMonitoring(null);
				} catch (RemoteException e) {
					Log.e(TAG, "Cannot start ranging", e);
				}
			}
		});
	}

	private void stopScan() {
		try {
			mBeaconManager.stopRanging(ALL_ESTIMOTE_BEACONS);
			// mBeaconManager.stopMonitoring(null);
		} catch (RemoteException e) {
			Log.e(TAG, "Cannot stop but it does not matter now", e);
		}
	}

	private void release() {
		Log.d(TAG, "onDestroy");
		mBeaconManager.disconnect();
	}
}
