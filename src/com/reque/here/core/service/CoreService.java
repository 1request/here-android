/**
 * 
 */
package com.reque.here.core.service;

import com.reque.here.core.anchor.model.Anchor;
import com.reque.here.core.message.model.AbsMessage;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * @author huqiming
 *
 */
public class CoreService extends Service {
	private static final String TAG = "CoreService";
	private CoreServiceStub mServiceStub;

	/* 
	 */
	@Override
	public IBinder onBind(Intent intent) {
		return mServiceStub;
	}

	/* 
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		mServiceStub = new CoreServiceStub();
	}

	/* 
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	/* 
	 */
	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
	}

	/* 
	 */
	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	private static class CoreServiceStub extends ICoreService.Stub {

		/* 
		 */
		@Override
		public void setAnchorCallback(IAnchorCallback callback) throws RemoteException {
		}

		/* 
		 */
		@Override
		public void sendMessage(AbsMessage msg) throws RemoteException {
		}

		/* 
		 */
		@Override
		public void queryMessagesByAnchor(Anchor anchor) throws RemoteException {
		}

		/* 
		 */
		@Override
		public void setMessageCallbck(IMessageCallback callback) throws RemoteException {
		}

	}
}
