/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.core.voice.recorder;

import java.io.IOException;

import android.media.MediaRecorder;

import com.reque.utils.Log;

/**
 *
 */
public class DefVoiceRecorder implements IVoiceRecorder {
	private static final String TAG = "DefVoiceRecorder";
	private MediaRecorder mRecorder;
	private boolean mRecording = false;

	@Override
	public void startRecord(String path) {
		Log.d(TAG, "start begin path: " + path);
		mRecording = true;
		mRecorder = new MediaRecorder();
		mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
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

	@Override
	public void stopRecord() {
		Log.d(TAG, "stopRecord begin mRecording: " + mRecording);
		if (mRecording) {
			mRecording = false;
			mRecorder.stop();
			mRecorder.release();
			Log.d(TAG, "finishRecord finish");
		}
	}

	@Override
	public boolean isRecording() {
		return mRecording;
	}

}
