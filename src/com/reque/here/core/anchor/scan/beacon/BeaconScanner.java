package com.reque.here.core.anchor.scan.beacon;

import java.util.List;

import com.reque.here.core.anchor.model.Anchor;
import com.reque.here.core.anchor.scan.IAnchorScanner;

public class BeaconScanner implements IAnchorScanner {

	@Override
	public void startScan(int interval) {
		
	}

	@Override
	public void stopScan() {
		
	}

	@Override
	public void setScanListener(OnAnchorScanListener l) {
		
	}

	/* 
	 */
	@Override
	public <T extends Anchor> List<T> getCurrentAnchors() {
		return null;
	}

}
