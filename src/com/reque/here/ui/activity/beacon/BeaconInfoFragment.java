package com.reque.here.ui.activity.beacon;

import com.reque.here.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BeaconInfoFragment extends Fragment {
	private static final String TAG = "BeaconInfoFragment";
	private BeaconModel mBeacon;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return setupView(inflater);
	}

	private View setupView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_beacon, null);
		return view;
	}

	public void setBeaconModel(BeaconModel beacon) {

	}

}
