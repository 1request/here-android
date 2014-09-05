/**
 * 
 */
package com.reque.here.core.service;

import java.util.List;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.reque.here.core.anchor.model.Anchor;
import com.reque.utils.Log;

/**
 * @author huqiming
 *
 */
public class CoreClient {
	private static final String TAG = "CoreClient";

	private Context mContext;
	private ICoreService mCoreService;
	private ServiceConnection mServiceConnection;
	private static CoreClient mInstance;

	public static CoreClient getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new CoreClient(context);
		}
		return mInstance;
	}

	/**
	 * 
	 */
	private CoreClient(Context context) {

	}

	public static void release() {
		if (mInstance != null) {
			mInstance.performRelease();
		}
	}

	private void performRelease() {
		unBindService(false);
	}

	private void bindService() {
		Log.d(TAG, "bindService mServiceConnection: " + mServiceConnection);
		if (mServiceConnection != null) {
			// 已经绑定过了，不需要再绑定
			return;
		}

		Intent intent = new Intent(mContext, CoreService.class);
		mServiceConnection = new CoreServiceConnection();
		mContext.startService(intent);
		mContext.bindService(intent, mServiceConnection, 0);
	}

	public List<Anchor> getCurrentAnchors() {
		if (mCoreService != null) {
			try {
				return mCoreService.getCurrentAnchors();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 解绑服务
	 * 
	 * @param stopService
	 *            是否需要停止服务
	 */
	private void unBindService(boolean stopService) {
		Log.d(TAG, "unBindService stopServic: " + stopService + " mServiceConnection: " + mServiceConnection);
		if (mServiceConnection != null) {
			mContext.unbindService(mServiceConnection);
			mServiceConnection = null;
		}

		if (stopService) {
			Intent intent = new Intent(mContext, CoreService.class);
			mContext.stopService(intent);
		}
	}

	class CoreServiceConnection implements ServiceConnection {

		/* 
		 */
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(TAG, "onServiceConnecteds name: " + name);
			mCoreService = ICoreService.Stub.asInterface(service);
		}

		/* 
		 */
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(TAG, "onServiceDisconnected name: " + name);
			mCoreService = null;
		}

	}
}
