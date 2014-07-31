/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-7-20
 */
package com.reque.utils;

import java.security.MessageDigest;

/**
 * MD5工具类
 */
public class MD5Util {
	private static final String TAG = "MD5Util";

	private static final String CODE_TYPE = "MD5";
	
	/**
	 * 静态加密方法
	 * @param content 传入加密的内容
	 * @return 返回加密的结果
	 * */
	public static String encode(String content){
		if (content == null || content.length() == 0) {
			return null;
		}
		try {
			MessageDigest digest = MessageDigest.getInstance(CODE_TYPE);
			digest.reset();
			digest.update(content.getBytes());
			StringBuilder builder = new StringBuilder();
			for (byte b : digest.digest()) {
				builder.append(Integer.toHexString((b >> 4) & 0xf));
				builder.append(Integer.toHexString(b & 0xf));
			}
			return builder.toString();
		} catch (Exception e) {
			Log.e(TAG, "getEncode error!");
			return null;
		}
	}
}
