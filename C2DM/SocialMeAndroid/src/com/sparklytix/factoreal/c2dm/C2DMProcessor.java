/**
 * 
 */
package com.sparklytix.factoreal.c2dm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author rohit
 * 
 */
public class C2DMProcessor {

	/**
	 * Register the app and device with C2DM and get registration in the broad cast receiver
	 * @param context 
	 * @param sender
	 */
	public void register(Context context, String sender) {
		Log.d("C2DMProcessor","register()");
		Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
		intent.putExtra("app",
				PendingIntent.getBroadcast(context, 0, new Intent(), 0));
		intent.putExtra("sender",
				sender);
		Log.d("C2DMProcessor","calling com.google.android.c2dm.intent.REGISTER Service");
		context.startService(intent);
	}
	
	/**
	 * 
	 * @param context
	 */
	public void unregister(Context context){
		Intent unregIntent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
		unregIntent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
		context.startService(unregIntent);
	}

}
