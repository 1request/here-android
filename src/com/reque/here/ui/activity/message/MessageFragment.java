/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-31
 */
package com.reque.here.ui.activity.message;

import java.io.File;
import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.reque.here.R;
import com.reque.here.core.settings.AppSetting;
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
		Button play = (Button) view.findViewById(R.id.play);
		play.setOnClickListener(this);
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
			break;
		case R.id.play:
			playRecord();
		default:
			break;
		}
	}

	private String voicePath = null;

	private void startRecord() {
		Log.d(TAG, "start begin");
		mRecorder = new MediaRecorder();
		mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		String path = AppSetting.APP_PATH + String.valueOf(System.currentTimeMillis()) + ".amr";
		File file = new File(path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {

			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			Log.e(TAG, "create path error: " + e1.toString());
		}
		voicePath = file.getAbsolutePath();
		Log.d(TAG, "start path: " + voicePath);
		mRecorder.setOutputFile(voicePath);
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

	private void playRecord() {
		Log.d(TAG, "playRecord mediaPlayer path: " + voicePath);
		if (voicePath == null) {
			return;
		}
		MediaPlayer mediaPlayer = new MediaPlayer();
		mediaPlayer.setAuxEffectSendLevel(1.0f);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				Log.d(TAG, "playRecord mediaPlayer onCompletion ");
				mp.release();
			}
		});
		try {
			mediaPlayer.setDataSource(voicePath);
			mediaPlayer.prepare();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.d(TAG, "playRecord mediaPlayer prepared");
		mediaPlayer.start();
		Log.d(TAG, "playRecord mediaPlayer start");

	}
}
