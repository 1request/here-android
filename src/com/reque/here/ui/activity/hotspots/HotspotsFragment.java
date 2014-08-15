/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.ui.activity.hotspots;

import java.util.Collection;
import java.util.Iterator;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.reque.here.R;
import com.reque.here.ui.activity.BaseFragment;

/**
 *
 */
public class HotspotsFragment extends BaseFragment implements BeaconConsumer {
	private static final String TAG = "HotspotsFragment";
	private BeaconManager beaconManager;
	private static final String ESTIMOTE_PROXIMITY_UUID = "B9407F30-F5F8-466E-AFF9-25556B57FE6D";
	private static final String UUID_1 = "74278bdab64445208f0c720eaf059935";
	private static final String UUID_2 = "e2c56db5dffb48d2b060d0f5a71096e0";
	private EditText mLogText;

	// private static final Region ALL_ESTIMOTE_BEACONS = new
	// Region("maikelong", UUID_2, null, null);

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView");
		View view = inflater.inflate(R.layout.hotspot_layout, null);
		EditText test = (EditText) view.findViewById(R.id.test_text);
		test.setText(TAG);
		mLogText = test;
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
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		release();
	}

	private void initBeacon() {
		beaconManager = BeaconManager.getInstanceForApplication(getActivity().getApplicationContext());
		beaconManager.bind(this);
		beaconManager.debug = true;
	}

	private void release() {
		Log.d(TAG, "onDestroy");
		beaconManager.unbind(this);
	}

	@Override
	public void onBeaconServiceConnect() {
		Log.d(TAG, "onBeaconServiceConnect");
		beaconManager.setRangeNotifier(new RangeNotifier() {
			@Override
			public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
				Log.d(TAG, "didRangeBeaconsInRegion beacons: " + beacons + " region: " + region);
				if (beacons != null && beacons.size() > 0) {
					Iterator<Beacon> it = beacons.iterator();
					while (it.hasNext()) {
						Beacon beacon = it.next();
						logToDisplay("The beacon:" + beacon.toString() + " distance:" + beacon.getDistance()
								+ "m rssi: " + beacon.getRssi() + " power: " + beacon.getTxPower() + " addr:"
								+ beacon.getBluetoothAddress());
					}
				}
			}

		});

		try {
			// beaconManager.startRangingBeaconsInRegion(new Region(UUID_2,
			// null, null, null));
			beaconManager.startRangingBeaconsInRegion(new Region(UUID_1, null, null, null));
			// beaconManager.startMonitoringBeaconsInRegion(null);
		} catch (RemoteException e) {
		}
	}

	private void logToDisplay(final String line) {
		try {
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					mLogText.append(line + "\n");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public Context getApplicationContext() {
		return getActivity().getApplicationContext();
	}

	@Override
	public void unbindService(ServiceConnection connection) {
		Log.d(TAG, "onBeaconServiceConnect");
		getActivity().unbindService(connection);
	}

	@Override
	public boolean bindService(Intent intent, ServiceConnection connection, int mode) {
		Log.d(TAG, "onBeaconServiceConnect");
		return getActivity().bindService(intent, connection, mode);
	}
}
