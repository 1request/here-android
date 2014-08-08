/*
 * @project :Here
 * @author  :huqiming 
 * @date    :2014-8-8
 */
package com.reque.here.core.trans;

/**
 *
 */
public interface ITransfer {
	void pushMsg(String uuid, String path);

	void pullMsg(String uuid);
}
