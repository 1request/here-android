/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-31
 */
package com.reque.here.ui.activity.message;

import java.io.File;
import java.io.IOException;

import android.media.MediaRecorder;
import android.media.MediaRecorder.AudioEncoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.reque.here.R;
import com.reque.here.ui.activity.BaseFragment;
import com.reque.utils.Log;

/**
 * 留言界面
 */
public class MessageFragment extends BaseFragment implements OnClickListener {
	private static final String TAG = "MessageFragment";
	private MediaRecorder mRecorder;

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
			startRecord();
			break;
		case R.id.finish:
			finishRecord();
		default:
			break;
		}
	}

	private void startRecord() {
		Log.d(TAG, "start begin");
		mRecorder = new MediaRecorder();
		mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		File file = new File("/sdcard/" + String.valueOf(System.currentTimeMillis()) + ".amr");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String path = file.getAbsolutePath();
		Log.d(TAG, "start path: " + path);
		mRecorder.setOutputFile(path);
		try {
			mRecorder.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.d(TAG, "start prepare");
		mRecorder.start();
		Log.d(TAG, "start finish");
	}

	private void finishRecord() {
		Log.d(TAG, "finishRecord begin");
		mRecorder.stop();
		mRecorder.release();
		Log.d(TAG, "finishRecord finish");
	}
	
	private void playRecord(){
		
		
	}
}
