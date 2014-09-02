/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.core.message;

import android.util.Log;

import com.reque.here.core.api.message.MessageApi;
import com.reque.here.core.settings.AppSetting;
import com.reque.here.core.voice.play.DefVoicePlayer;
import com.reque.here.core.voice.play.IVoicePlayer;
import com.reque.here.core.voice.recorder.DefVoiceRecorder;
import com.reque.here.core.voice.recorder.IVoiceRecorder;
import com.reque.here.core.voice.recorder.RecorderHelper;

/**
 *
 */
public class MessageController {
	private static final String TAG = "MessageController";
	private IVoicePlayer mVoicePlayer;
	private IVoiceRecorder mVoiceRecorder;
	private String mCurrVoicePath = null;

	/**
	 * 
	 */
	public MessageController() {
		mVoicePlayer = new DefVoicePlayer();
		mVoiceRecorder = new DefVoiceRecorder();
	}

	public void startRecord() {
		mCurrVoicePath = RecorderHelper.createRecordPath(AppSetting.APP_PATH);
		mVoiceRecorder.startRecord(mCurrVoicePath);
	}

	public void finishRecord() {
		mVoiceRecorder.stopRecord();
	}

	public void playRecord() {
		mVoicePlayer.play(mCurrVoicePath);
	}

	public void uploadRecord() {
		Log.d(TAG, "uploadRecord mCurrVoicePath: " + mCurrVoicePath);
		MessageApi.uploadMessage(AppSetting.TEST_MAC, AppSetting.TEST_ACCESS_ID, AppSetting.TEST_DEVICE_ID,
				AppSetting.TEST_DEVICE_TYPE, mCurrVoicePath);
	}

	public void testGetRecord() {
		MessageApi.requestMessage(AppSetting.TEST_MAC, AppSetting.TEST_ACCESS_ID, AppSetting.TEST_DEVICE_ID,
				AppSetting.TEST_DEVICE_TYPE);
	}
}
