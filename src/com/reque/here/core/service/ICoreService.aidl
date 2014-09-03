/**
 * 
 */
package com.reque.here.core.service;
	   
import com.reque.here.core.message.model.AbsMessage;
import com.reque.here.core.anchor.model.Anchor;
import com.reque.here.core.service.IAnchorCallback;
import com.reque.here.core.service.IMessageCallback;

/**
 * @author huqiming
 *
 */
interface ICoreService {
	List<Anchor> getCurrentAnchors();
	
	void setAnchorCallback(IAnchorCallback callback);

	void sendMessage(in AbsMessage msg);
	
	void queryMessagesByAnchor(in Anchor anchor);

	void setMessageCallbck(IMessageCallback callback);
}
