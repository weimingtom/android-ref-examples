/**
 * 
 */
package com.tutorial.service.services.simple;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * @author rohit
 *
 */
public class SimpleService extends Service {

	private int value=0;
	
	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		//Simple Service means we will do work in onStart
		return null;
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
		String action = intent.getExtras().getString("Action");
		int data = intent.getExtras().getInt("Data");
		if("add".equalsIgnoreCase(action)){
			Log.d(SimpleService.class.getSimpleName(),"Adding "+data+" to "+value);
			value +=data;
			Log.d(SimpleService.class.getSimpleName(),"New value is "+value);
		}
		else if("substract".equalsIgnoreCase(action)){
			Log.d(SimpleService.class.getSimpleName(),"Substract "+data+" to "+value);
			value -=data;
			Log.d(SimpleService.class.getSimpleName(),"New value is "+value);
		}
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
