package com.reque.here.ui.activity.beacon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.reque.here.R;
import com.reque.here.core.api.message.MessageApi;

public class BeaconInfoFragment extends Fragment {
	private static final String TAG = "BeaconInfoFragment";
	private BeaconModel mBeacon;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return setupView(inflater);
	}

	private View setupView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_beacon, null);
		View head = view.findViewById(R.id.head);
		head.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				testApi();
			}
		});
		return view;
	}
	
	private void testApi(){
//		MessageApi.uploadMessage(null, null, null, "1232344", 0, "");
	}
	
	public void setBeaconModel(BeaconModel beacon) {

	}

}
