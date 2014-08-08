/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.core.voice.recorder;

import java.io.File;
import java.io.IOException;

import com.reque.here.core.settings.AppSetting;
import com.reque.utils.Log;

/**
 *
 */
public class RecorderHelper {
	private static final String TAG = "RecorderHelper";

	public static String createRecordPath(String parentPath) {
		if (parentPath == null) {
			return null;
		}
		String path = parentPath + String.valueOf(System.currentTimeMillis()) + ".amr";
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
		return file.getAbsolutePath();
	}
}
