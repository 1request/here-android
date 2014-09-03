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
import com.reque.utils.FileUtil;
import com.reque.utils.Log;

/**
 * @author HuQiming
 * 
 */
public class AnchorNotification {
	private static final String TAG = "AnchorNotification";
	private static final int NOTIFACTION_ID_FREE_WIFI = 8001;
	private static final int TYPE_SCAN_ANCHOR = 0x101;
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
//		mNotification.tickerText = mContext.getString(R.string.freewifi_notification);
//		mNotification.contentView = new RemoteViews(mContext.getPackageName(), R.layout.notification_freewifi);
	}

	public void showAutoScan() {
//		mNotification.contentView.setTextViewText(R.id.notify_title, mContext.getString(R.string.freewifi_title));
//		mNotification.contentView.setTextViewText(R.id.notify_content,
//				mContext.getString(R.string.freewifi_found_possiable));
//		Intent clickIntent = new Intent(KeyConstants.ACTION_MANUAL_SCAN_WIFI);
//		// 注明跳转到手动扫描界面的来源来源
//		clickIntent.putExtra(KeyConstants.EXTRA_MANUAL_SCAN_WIFI_SOURCE, KeyConstants.SOURCE_FROM_NOTIFICATION);
//		PendingIntent pendingClickIntent = PendingIntent.getActivity(mContext, 0, clickIntent, 0);
//		PendingIntent pendingDeleteIntent = PendingIntent.getBroadcast(mContext, 0, new Intent(
//				KeyConstants.ACTION_CLEAR_SCAN_WIFI_NOTIFY), 0);
//		mNotification.contentIntent = pendingClickIntent;
//		mNotification.deleteIntent = pendingDeleteIntent;
//		mNotificationManager.notify(TYPE_SCAN_ANCHOR, NOTIFACTION_ID_FREE_WIFI, mNotification);
	}

	public void cancelAutoScan() {
//		mNotificationManager.cancel(TYPE_SCAN_ANCHOR, NOTIFACTION_ID_FREE_WIFI);
	}

	public void release() {
		cancelAutoScan();
	}
}
