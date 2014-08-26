package com.reque.here.ui.activity.beacon;

import com.reque.here.R;
import com.reque.here.core.api.message.MessageApi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BeaconInfoFragment extends Fragment {
	private static final String TAG = "BeaconInfoFragment";
	private BeaconModel mBeacon;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		MessageApi.requestMessage("e2c56db5dffb48d2b060d0f5a71096e0", "323", "212", "123455");
	}

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
