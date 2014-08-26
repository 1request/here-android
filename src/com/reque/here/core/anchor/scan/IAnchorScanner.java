package com.reque.here.core.anchor.scan;

import java.util.List;

import com.reque.here.core.anchor.model.Anchor;

public interface IAnchorScanner {
	void startScan(int interval);

	void stopScan();

	void setScanListener(OnAnchorScanListener l);

	public interface OnAnchorScanListener {
		void onAnchorScanned(List<Anchor> anchors);
	}
}
