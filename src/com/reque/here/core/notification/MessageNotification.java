/*
 * 版    权：深圳市快播科技有限公司
 * 描    述: 
 * 创建人: HuQiming
 * 创建时间: 2014-5-18
 * 
 */
package com.reque.here.core.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.widget.RemoteViews;

import com.reque.here.R;
import com.reque.utils.Log;

/**
 * @author HuQiming
 * @date 2014-5-18
 * 
 */
public class MessageNotification {
	private static final String TAG = "FreeWifiNotification";
	private static final int NOTIFACTION_ID_FREE_WIFI = 8001;
	private static final String TAG_AUTO_SCAN = "TAG_AUTO_SCAN";
	private static final String TAG_TRAFFIC_INSUFFICIENT = "TAG_TRAFFIC_INSUFFICIENT";
	private static final String TAG_LAST_USED_TRAFFIC = "TAG_LAST_USED_TRAFFIC";
	private NotificationManager mNotificationManager;
	private Notification mNotification;
	private Context mContext;

	public MessageNotification(Context context) {
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
//		mNotification.contentIntent = pendingClickIntent;
//		mNotification.deleteIntent = pendingDeleteIntent;
//		mNotificationManager.notify(TAG_AUTO_SCAN, NOTIFACTION_ID_FREE_WIFI, mNotification);
	}

	public void cancelAutoScan() {
		mNotificationManager.cancel(TAG_AUTO_SCAN, NOTIFACTION_ID_FREE_WIFI);
	}


	public void release() {
		cancelAutoScan();
	}
}
