/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.core.voice.recorder;

/**
 *
 */
public interface IVoiceRecorder {
	void startRecord(String path);

	void stopRecord();

	boolean isRecording();
}
