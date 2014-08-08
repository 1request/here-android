/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.ui.activity.friends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reque.here.R;
import com.reque.here.ui.activity.BaseFragment;

/**
 *
 */
public class FriendsFragment extends BaseFragment {
	private static final String TAG = "FriendsFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.test_layout, null);
		TextView test = (TextView) view.findViewById(R.id.test_text);
		test.setText(TAG);
		return view;
	}
}
