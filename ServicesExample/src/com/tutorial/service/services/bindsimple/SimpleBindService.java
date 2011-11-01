/**
 * 
 */
package com.tutorial.service.services.bindsimple;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * @author rohit
 *
 */
public class SimpleBindService extends Service {

	private int value=0;
	
	private final ICalcService.Stub mBinder = new ICalcService.Stub() {

		@Override
		public int add(int data) throws RemoteException {
			return (value = value+data);
		}

		@Override
		public int substract(int data) throws RemoteException {
			return (value = value - data);
		}
	
	};
	
	
	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	/* (non-Javadoc)
	 * @see android.app.Service#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}
	

	/* (non-Javadoc)
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	
	
	

}
