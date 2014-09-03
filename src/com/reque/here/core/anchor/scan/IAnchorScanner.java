package com.reque.here.core.anchor.scan;

import java.util.List;

import com.reque.here.core.anchor.model.Anchor;

public interface IAnchorScanner {
	<T extends Anchor> List<T> getCurrentAnchors();

	void startScan(int interval);

	void stopScan();

	void setScanListener(OnAnchorScanListener l);

	public interface OnAnchorScanListener {
		<T extends Anchor> void onAnchorScanned(List<T> anchors);
	}
}
