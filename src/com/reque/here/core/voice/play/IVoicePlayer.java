/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.core.voice.play;

/**
 *
 */
public interface IVoicePlayer {
	void play(String path);

	void stop();

	void setVoicePlayListener(OnVoicePlayListener listener);

	interface OnVoicePlayListener {
		void onPlayCompleted();

		void onError(int code, String detail);
	}
}
