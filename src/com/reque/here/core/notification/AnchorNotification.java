/*
 * 
 */
package com.reque.here.core.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.reque.here.R;
import com.reque.here.core.settings.AppConstants;
import com.reque.utils.FileUtil;
import com.reque.utils.Log;

/**
 * @author HuQiming
 * 
 */
public class AnchorNotification {
	private static final String TAG = "AnchorNotification";
	private static final int NOTIFACTION_ID_ANCHOR = 8001;
	private static final String TYPE_SCAN_ANCHOR = "TYPE_SCAN_ANCHOR";
	private NotificationManager mNotificationManager;
	private Notification mNotification;
	private Context mContext;

	public AnchorNotification(Context context) {
		mContext = context;
		initNotification();
	}

	/**
	 * 初始化通知栏
	 */
	private void initNotification() {
		Log.d(TAG, "--------- initNotification --------------");
		mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotification = new Notification();
		mNotification.flags = Notification.FLAG_AUTO_CANCEL;
		mNotification.icon = R.drawable.ic_launcher;
		mNotification.tickerText = mContext.getString(R.string.scanned_anchor);
	}

	public void showScanAnchor() {
		Intent clickIntent = new Intent(AppConstants.ACTION_SCAN_ANCHOR);
		// 注明跳转到手动扫描界面的来源来源
		PendingIntent pendingClickIntent = PendingIntent.getActivity(mContext, 0, clickIntent, 0);
		mNotification.contentIntent = pendingClickIntent;
		mNotificationManager.notify(TYPE_SCAN_ANCHOR, NOTIFACTION_ID_ANCHOR, mNotification);
	}

	public void dismissScanAnchor() {
		mNotificationManager.cancel(TYPE_SCAN_ANCHOR, NOTIFACTION_ID_ANCHOR);
	}

	public void release() {
		dismissScanAnchor();
	}
}
