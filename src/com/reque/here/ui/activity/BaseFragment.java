/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-25
 */
package com.reque.here.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reque.here.R;

/**
 *
 */
public class BaseFragment extends Fragment {
	private static final String TAG = "BaseFragment";
	private TextView mTestContent;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView");
		View view = inflater.inflate(R.layout.test_layout, null);
		mTestContent = (TextView) view.findViewById(R.id.test_text);
		return view;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
	}

	public void setTestTitle(String title) {
		mTestContent.setText(title);
	}
}
