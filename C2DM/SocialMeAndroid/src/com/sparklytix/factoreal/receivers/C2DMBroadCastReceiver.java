/**
 * 
 */
package com.sparklytix.factoreal.receivers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sparklytix.factoreal.R;
import com.sparklytix.factoreal.SocialMeActivity;
import com.sparklytix.factoreal.mgr.AccountManager;
import com.sparklytix.factoreal.mgr.AccountPreferences;
import com.sparklytix.factoreal.mgr.NetworkException;

/**
 * @author rohit
 * 
 */
public class C2DMBroadCastReceiver extends BroadcastReceiver {

	private static final String REGISTRATION_ACTION = "com.google.android.c2dm.intent.REGISTRATION";
	private static final String RECEIVE_ACTION = "com.google.android.c2dm.intent.RECEIVE";
	private static final String JSON = "{\"firstName\":\"{0}\",\"lastName\":\"{1}\",\"username\":\"{2}\",\"registrationId\":\"{3}\"}";

	private static final String TYPE1_NOTIFICATION = "New Scraps!";
	private static final String TYPE2_NOTIFICATION = "Please Upgrade!";

	private AccountPreferences prefs = new AccountPreferences();
	private AccountManager acctMgr = new AccountManager(prefs);

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context,
	 * android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("C2DMBroadCastReceiver", "onReceive()");
		String action = intent.getAction();

		if (REGISTRATION_ACTION.equals(action)) {
			Log.d("C2DMBroadCastReceiver", "Received registration ID");
			handleC2DMRegistrationSuccessful(context, intent);
		} else if (RECEIVE_ACTION.equals(action)) {
			Log.d("C2DMBroadCastReceiver", "Received CLoud Intent");
			handleC2DMCloudIntent(context, intent);
		}

	}

	private void handleC2DMRegistrationSuccessful(final Context context,
			Intent intent) {
		Log.d("C2DMBroadCastReceiver", "handleC2DMRegistrationSuccessful()");
		final String registrationId = intent.getStringExtra("registration_id");
		String error = intent.getStringExtra("error");

		Log.d("C2DMBroadCastReceiver", "dmControl: registrationId = "
				+ registrationId + ", error = " + error);

		if (intent.getStringExtra("error") != null) {
			// Registration failed, should try again later.
		} else if (intent.getStringExtra("unregistered") != null) {
			// unregistration done, new messages from the authorized sender
			// will be rejected
		} else if (registrationId != null) {
			// Send the registration ID to the 3rd party site that is
			// sending the messages.
			// This should be done in a separate thread.
			// When done, remember that all registration is done.
			Runnable runnable = new Runnable() {

				public void run() {
					try {
						acctMgr.sendC2DMRegistrationId(context,
								prefs.getSocialUserJSON(context),
								registrationId);
					} catch (NetworkException nex) {
						nex.printStackTrace();
					}

				}
			};
			Thread thread = new Thread(runnable);
			Log.d("C2DMBroadCastReceiver",
					"Running thread to send registration to the server");
			thread.start();

		}
	}

	private void handleC2DMCloudIntent(Context context, Intent intent) {
		Log.d("C2DMBroadCastReceiver", "handleC2DMCloudIntent()");
		String payload = intent.getStringExtra("payload");
		if (TYPE2_NOTIFICATION.equals(payload)) {
			createNotification(context, payload);
		} else if (TYPE1_NOTIFICATION.equals(payload)) {
			// TOOD Create a service and a database, invoke the service, service
			// will fetch only latest scraps and append it to the database.
			// Then Service will create notification to open the view which
			// reads from the database.
		}

	}

	private void createNotification(Context context, String payload) {
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.icon,
				"Message received", System.currentTimeMillis());
		// Hide the notification after its selected
		notification.flags |= Notification.FLAG_AUTO_CANCEL;

		Intent intent = new Intent(context, SocialMeActivity.class);
		intent.putExtra("payload", payload);
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
				intent, 0);
		notification.setLatestEventInfo(context, "Message",
				"New message received", pendingIntent);
		notificationManager.notify(0, notification);

	}

	private String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		is.close();
		return sb.toString();
	}
}
