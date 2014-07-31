/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-23
 */
package com.reque.utils.http;

/**
 *
 */
public class JsonDataParser implements IDataParser {
	private static final String TAG = "JsonDataParser";
	private Class mCls;

	/**
	 * 
	 */
	public JsonDataParser(Class cls) {
		mCls = cls;
	}

	@Override
	public Object parse(byte[] data) {
		String json = new String(data);
		Object obj = JacksonUtil.jsonToObj(json, mCls);
		return obj;
	}

}
