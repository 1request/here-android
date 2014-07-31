/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-31
 */
package com.reque.here.ui.activity.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.reque.here.R;
import com.reque.here.ui.activity.BaseFragment;

/**
 * 留言界面
 */
public class MessageFragment extends BaseFragment implements OnClickListener {
	private static final String TAG = "MessageFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return setupView(inflater);
	}

	private View setupView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.fragment_message, null);
		Button start = (Button) view.findViewById(R.id.start);
		start.setOnClickListener(this);
		Button finish = (Button) view.findViewById(R.id.finish);
		finish.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.start:
			start();
			break;
		case R.id.finish:
			finishRecord();
		default:
			break;
		}
	}

	private void start() {

	}

	private void finishRecord() {

	}
}
