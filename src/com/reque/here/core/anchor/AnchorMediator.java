/**
 * 
 */
package com.reque.here.core.anchor;

import java.util.List;

import android.content.Context;

import com.reque.here.core.anchor.model.Anchor;
import com.reque.here.core.anchor.scan.IAnchorScanner.OnAnchorScanListener;
import com.reque.here.core.anchor.scan.wifi.WifiAnchorScanner;
import com.reque.here.core.service.IAnchorCallback;

/**
 * @author huqiming
 *
 */
public class AnchorMediator implements OnAnchorScanListener {
	private static final String TAG = "AnchorMediator";
	private IAnchorCallback mAnchorCallback;
	private WifiAnchorScanner mWifiScanner;
	private Context mContext;

	/**
	 * 
	 */
	public AnchorMediator(Context context) {
		mContext = context;
	}

	public void init() {
		mWifiScanner = new WifiAnchorScanner(mContext);
	}

	public void release() {
	}

	public void setAnchorCallback(IAnchorCallback callback) {
		mAnchorCallback = callback;
	}

	public List<Anchor> getCurrentAnchors() {
		return null;
	}

	/* 
	 */
	@Override
	public <T extends Anchor> void onAnchorScanned(List<T> anchors) {
	}

}
