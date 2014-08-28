package com.reque.here.core.api.message;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.http.Header;

import android.content.Context;
import android.util.Log;

import com.reque.here.core.settings.HttpSetting;
import com.reque.utils.http.async.AsyncHttpClient;
import com.reque.utils.http.async.AsyncHttpResponseHandler;
import com.reque.utils.http.async.RequestParams;

public class MessageApi {
	private static final String TAG = "MessageApi";

	public static void uploadMessage(String mac, String accessId, String deviceId, int deviceType, String audioPath) {
		Log.d(TAG, "uploadMessage audioPath: " + audioPath);
		String contentType = "multipart/form-data";
		RequestParams params = new RequestParams();
		params.put("deviceId", deviceId);
		params.put("deviceType", deviceType);
		params.put("macAddr", mac);
		params.put("accessId", accessId);
		
		try {
			params.put("audio", new File(audioPath), contentType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		AsyncHttpClient client = new AsyncHttpClient();
		client.post(HttpSetting.UPLOAD_MSG_URL, params, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				Log.d(TAG, "uploadMessage onSuccess: " + statusCode + " statusCode: " + statusCode + " responseBody: "
						+ new String(responseBody));
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
				Log.d(TAG, "uploadMessage onSuccess: " + statusCode + " statusCode: " + statusCode + " responseBody: "
						+ new String(responseBody));
			}
		});
	}

	public static void requestMessage(String mac, String accessId, String deviceId, int deviceType) {
		Log.d(TAG, "requestMessage");
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams params = new RequestParams();
		params.put("mac_address", mac);
		params.put("access_id", accessId);
		params.put("deviceId", deviceId);

		client.get(HttpSetting.REQUEST_MSG_URL, params, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				Log.d(TAG, "requestMessage onSuccess: " + statusCode + " statusCode: " + statusCode + " responseBody: "
						+ new String(responseBody));
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
				Log.d(TAG, "requestMessage onFailure: " + statusCode + " statusCode: " + statusCode + " responseBody: "
						+ new String(responseBody));
			}
		});
	}
}
