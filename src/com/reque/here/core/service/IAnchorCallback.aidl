/**
 * 
 */
package com.reque.here.core.service;

import java.util.List;
import com.reque.here.core.anchor.model.Anchor;

/**
 * @author huqiming
 *
 */
 
interface IAnchorCallback {
	void onAnchorScanned(out List<Anchor> anchors);
}
