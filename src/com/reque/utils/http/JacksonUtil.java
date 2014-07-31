/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-20
 */
package com.reque.utils.http;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reque.utils.Log;

/**
 *
 */
public class JacksonUtil {
	public static final String TAG = "JacksonUtil";

	public static ObjectMapper mObjectMapper = new ObjectMapper();

	public static String objToJson(Object obj) {
		if (obj == null) {
			return null;
		}
		Log.d(TAG, "begin");
		String result = null;
		try {
			result = mObjectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		Log.d(TAG, "finish");
		return result;
	}

	public static <T> T jsonToObj(String json, Class T) {
		if (json == null) {
			return null;
		}
		Log.d(TAG, "begin");
		T obj = null;
		try {
			obj = (T) mObjectMapper.readValue(json.getBytes(), T);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.d(TAG, "finish");
		return obj;
	}
}
