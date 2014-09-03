/**
 * 
 */
package com.reque.here.core.service;

import java.util.List;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.reque.here.core.anchor.AnchorMediator;
import com.reque.here.core.anchor.model.Anchor;
import com.reque.here.core.message.model.AbsMessage;

/**
 * @author huqiming
 *
 */
public class CoreService extends Service {
	private static final String TAG = "CoreService";
	private AnchorMediator mAnchorMediator;

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
		mAnchorMediator = new AnchorMediator(this);
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

	private ICoreService.Stub mServiceStub = new ICoreService.Stub() {
		@Override
		public List<Anchor> getCurrentAnchors() throws RemoteException {
			return null;
		}

		/* 
		 */
		@Override
		public void setAnchorCallback(IAnchorCallback callback) throws RemoteException {
			mAnchorMediator.setAnchorCallback(callback);
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

	};
}
