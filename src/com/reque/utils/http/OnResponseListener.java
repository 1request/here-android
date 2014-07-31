/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-23
 */
package com.reque.utils.http;

import org.apache.http.Header;

/**
 *
 */
public interface OnResponseListener {
	public void onSuccess(int statusCode, Header[] headers, Object result);

	public void onFailure(int statusCode, Header[] headers, Object result);
}
