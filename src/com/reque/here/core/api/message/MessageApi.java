package com.reque.here.core.api.message;

import java.io.IOException;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

import android.util.Log;

import com.reque.here.core.settings.HttpSetting;
import com.reque.utils.http.async.AsyncHttpClient;
import com.reque.utils.http.async.AsyncHttpResponseHandler;
import com.reque.utils.http.async.RequestParams;
import com.reque.utils.http.async.ResponseHandlerInterface;

public class MessageApi {
	private static final String TAG = "MessageApi";

	public static void uploadMessage(String uuid, String major, String minor, String deviceId, int deviceType,
			String audioPath) {
	}

	public static void requestMessage(String uuid, String major, String minor, String deviceId) {
		Log.d(TAG, "requestMessage");
		AsyncHttpClient client = new AsyncHttpClient();
		RequestParams params = new RequestParams();
		params.put("uuid", uuid);
		params.put("major", major);
		params.put("minor", minor);
		params.put("deviceId", deviceId);

		client.addHeader(
				"User-Agent",
				"Mozilla/5.0 (Linux; U; Android 2.2; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
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
