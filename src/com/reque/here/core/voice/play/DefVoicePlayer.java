/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.core.voice.play;

import java.io.IOException;

import com.reque.utils.Log;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/**
 * 系统原生的播放器
 */
public class DefVoicePlayer implements IVoicePlayer {
	private static final String TAG = "DefVoicePlayer";
	private MediaPlayer mMediaPlayer;
	private OnVoicePlayListener mPlayListener;

	@Override
	public void play(String path) {
		Log.d(TAG, "playRecord mediaPlayer path: " + path);
		if (path == null) {
			return;
		}
		MediaPlayer mediaPlayer = new MediaPlayer();
		mediaPlayer.setAuxEffectSendLevel(1.0f);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				Log.d(TAG, "playRecord mediaPlayer onCompletion ");
				mp.release();
				if (mPlayListener != null) {
					mPlayListener.onPlayCompleted();
				}
			}
		});
		try {
			mediaPlayer.setDataSource(path);
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

	@Override
	public void stop() {
	}

	@Override
	public void setVoicePlayListener(OnVoicePlayListener listener) {
		mPlayListener = listener;
	}

}
