/**
 * 
 */
package com.sparklytix.socialme.c2dm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/**
 * @author rohit
 * 
 */
public class C2DMUtil {

	private final static String AUTH = "authentication";

	private static final String UPDATE_CLIENT_AUTH = "Update-Client-Auth";

	public static final String PARAM_REGISTRATION_ID = "registration_id";

	public static final String PARAM_DELAY_WHILE_IDLE = "delay_while_idle";

	public static final String PARAM_COLLAPSE_KEY = "collapse_key";

	private static final String UTF8 = "UTF-8";

	public String getToken(String email, String password) throws IOException {
		// Create the post data
		// Requires a field with the email and the password
		StringBuilder builder = new StringBuilder();
		builder.append("Email=").append(email);
		builder.append("&Passwd=").append(password);
		builder.append("&accountType=GOOGLE");
		builder.append("&source=MyLittleExample");
		builder.append("&service=ac2dm");

		// Setup the Http Post
		byte[] data = builder.toString().getBytes();
		URL url = new URL("https://www.google.com/accounts/ClientLogin");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setUseCaches(false);
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		con.setRequestProperty("Content-Length", Integer.toString(data.length));

		// Issue the HTTP POST request
		OutputStream output = con.getOutputStream();
		output.write(data);
		output.close();

		// Read the response
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String line = null;
		String auth_key = null;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("Auth=")) {
				auth_key = line.substring(5);
			}
		}

		// Finally get the authentication token
		// To something useful with it
		return auth_key;
	}

	public static int sendMessage(String auth_token, String registrationId,
			String message) throws IOException {

		StringBuilder postDataBuilder = new StringBuilder();
		postDataBuilder.append(PARAM_REGISTRATION_ID).append("=")
				.append(registrationId);
		postDataBuilder.append("&").append(PARAM_COLLAPSE_KEY).append("=")
				.append("0");
		postDataBuilder.append("&").append("data.payload").append("=")
				.append(URLEncoder.encode(message, UTF8));

		byte[] postData = postDataBuilder.toString().getBytes(UTF8);

		// Hit the dm URL.

		URL url = new URL("https://android.clients.google.com/c2dm/send");
		HttpsURLConnection
				.setDefaultHostnameVerifier(new CustomizedHostnameVerifier());
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		conn.setRequestProperty("Content-Length",
				Integer.toString(postData.length));
		conn.setRequestProperty("Authorization", "GoogleLogin auth="
				+ auth_token);

		OutputStream out = conn.getOutputStream();
		out.write(postData);
		out.close();

		int responseCode = conn.getResponseCode();
		return responseCode;
	}

	private static class CustomizedHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

}
