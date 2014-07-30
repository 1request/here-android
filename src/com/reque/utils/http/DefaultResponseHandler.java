/*
 * @project :MaiTii
 * @author  :huqiming 
 * @date    :2014-7-23
 */
package com.reque.utils.http;

import org.apache.http.Header;

import com.reque.utils.http.async.AsyncHttpResponseHandler;

/**
 *
 */
public class DefaultResponseHandler extends AsyncHttpResponseHandler {
	private static final String TAG = "DefaultResponseHandler";
	private IDataParser mDataParser;
	private OnResponseListener mListener;

	/**
	 * 
	 */
	public DefaultResponseHandler(IDataParser parser) {
		mDataParser = parser;
	}

	public void setResponseListener(OnResponseListener listener) {
		mListener = listener;
	}

	@Override
	public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
		Object obj = mDataParser.parse(responseBody);
		mListener.onSuccess(statusCode, headers, obj);
	}

	@Override
	public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
	}

}
