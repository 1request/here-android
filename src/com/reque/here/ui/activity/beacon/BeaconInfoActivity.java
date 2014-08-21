package com.reque.here.ui.activity.beacon;

import com.reque.here.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class BeaconInfoActivity extends ActionBarActivity {
	private static final String TAG = "BeaconInfoActivity";

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_beacon);
		initActionBar();
	}

	private void initActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.bg_titlebar));
		actionBar.setIcon(R.drawable.ic_title_here);
		actionBar.setTitle(null);
	}
}
