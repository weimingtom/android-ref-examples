/**
 * 
 */
package com.sparklytix.factoreal.mgr;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.util.Log;

import com.sparklytix.factoreal.c2dm.C2DMProcessor;
import com.sparklytix.factoreal.utils.StringUtils;

/**
 * @author rohit
 * 
 */
public class AccountManager {

	private static final String URI_SOCIALUSER = "http://10.0.2.2:8080/socialme/socialusers";
	private static final String CREATE_SOCIALUSER_JSON = "{\"emailAddress\":\"{0}\",\"firstName\":\"{1}\",\"lastName\":\"{2}\",\"password\":\"{3}\",\"version\":0}";

	private static final String URI_SOCIALUSER_REGISTRATIONID = "http://10.0.2.2:8080/socialme/socialuserregistrations";
	private static final String UPDATE_SOCIALUSER_REGISTRATIONID = "{\"registrationId\":\"{0}\",\"socialUser\":{1},\"version\":0}";

	private static final String URI_LOGIN_SOCIALUSER = "http://10.0.2.2:8080/socialme/socialusers?find=ByEmailAddressEqualsAndPasswordEquals&emailAddress={0}&password={1}";

	private AccountPreferences prefs;
	private C2DMProcessor c2dmProcessor = new C2DMProcessor();

	public AccountManager(AccountPreferences prefs) {
		this.prefs = prefs;
	}

	public void signUp(Context context, String firstName, String lastName,
			String userName, String password) throws UserAlreadyExists,
			NetworkException {

		Log.d("AccountManager", "signUp(context," + firstName + "," + lastName
				+ "," + userName + "," + password);
		HttpClient client = new DefaultHttpClient();
		HttpPut put = new HttpPut(URI_SOCIALUSER);
		put.addHeader("Accept", "application/json");
		put.addHeader("Content-Type", "application/json");
		String jsonPacket = CREATE_SOCIALUSER_JSON.replace("{0}", userName);
		jsonPacket = jsonPacket.replace("{1}", firstName);
		jsonPacket = jsonPacket.replace("{2}", lastName);
		jsonPacket = jsonPacket.replace("{3}", password);
		Log.d("AccountManager", "signUp - Sending " + jsonPacket);
		try {
			put.setEntity(new StringEntity(jsonPacket));
			HttpResponse response = client.execute(put);
			String responseText = StringUtils.from(response.getEntity()
					.getContent());
			Log.d("AccountManager", "signUp - Got Response " + jsonPacket);
			if (null != responseText && responseText.trim().length() != 0) {
				throw new UserAlreadyExists();
			}
			// Every thing is fine store info in shared preference
			prefs.storeSignUpInfo(context, firstName, lastName, userName,
					password);

		} catch (IOException ioex) {
			throw new NetworkException(ioex);
		}
		// prefs.storeLoginInfo(context, userName, password);
	}

	public void login(Context context, String userName, String password)
			throws InvalidCredentialsException, NetworkException {
		Log.d("AccountManager", "login(context," + userName + "," + password);
		HttpClient client = new DefaultHttpClient();
		String url = URI_LOGIN_SOCIALUSER.replace("{0}", userName);
		url = url.replace("{1}", password);
		Log.d("AccountManager", "login - Sending to url " + url);
		HttpPost post = new HttpPost(url);
		post.addHeader("Accept", "application/json");
		post.addHeader("Content-Type", "application/json");

		try {

			HttpResponse response = client.execute(post);
			String responseText = StringUtils.from(response.getEntity()
					.getContent());
			Log.d("AccountManager", "login - Got Response " + responseText);
			if (null == responseText || responseText.trim().length() == 2) {
				throw new InvalidCredentialsException();
			}
			// Every thing is fine store info in shared preference
			prefs.storeLoginInfo(context, userName, password);
			String socialUserJSON = responseText.substring(1,
					responseText.length() - 2);
			Log.d("AccountManager", "login - socialUserJSON= " + socialUserJSON);
			prefs.storeSocialUserJSON(context, socialUserJSON);

			Log.d("SocialMeActivity", "c2dmProcessor.register()");
			// if (null != prefs.getC2DMRegistrationId(context)) {
			c2dmProcessor.register(context, prefs.getUserName(context));
			// }

		} catch (Exception ex) {
			throw new NetworkException(ex);
		}
	}

	public void sendC2DMRegistrationId(Context context, String socialUserJSON,
			String registrationId) throws NetworkException {
		Log.d("AccountManager", "sendC2DMRegistrationId(context,"
				+ socialUserJSON + "," + registrationId);
		try {

			// Step 1 - Delete old registration id
			String oldRegistrationId = prefs.getC2DMRegistrationId(context);
			HttpClient client1 = new DefaultHttpClient();
			HttpDelete delete = new HttpDelete(URI_SOCIALUSER_REGISTRATIONID
					+ "?registrationId=" + oldRegistrationId);
			delete.addHeader("Accept", "application/json");
			delete.addHeader("Content-Type", "application/json");
			client1.execute(delete);

			// Step 2- Add new registration id
			HttpClient client2 = new DefaultHttpClient();
			HttpPut put = new HttpPut(URI_SOCIALUSER_REGISTRATIONID);

			put.addHeader("Accept", "application/json");
			put.addHeader("Content-Type", "application/json");
			String jsonPacket = UPDATE_SOCIALUSER_REGISTRATIONID.replace("{0}",
					registrationId);
			jsonPacket = jsonPacket.replace("{1}", socialUserJSON);
			Log.d("AccountManager", "sendC2DMRegistrationId - Sending "
					+ jsonPacket);

			put.setEntity(new StringEntity(jsonPacket));
			HttpResponse response = client2.execute(put);
			String responseText = StringUtils.from(response.getEntity()
					.getContent());
			Log.d("AccountManager", "sendC2DMRegistrationId - Got Response "
					+ jsonPacket);
			prefs.storeC2DMRegistrationId(context, registrationId);
		} catch (IOException ex) {
			throw new NetworkException(ex);
		}

	}

}
