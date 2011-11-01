package com.test.android.twitter.oauth;

import java.net.URI;

import winterwell.jtwitter.OAuthSignpostClient;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TwitterOAuthActivity extends Activity {

	private static final String TWITTER_KEY = "QFgKeMtBipewO4IG0rCNvw";
	private static final String TWITTER_SECRET = "OLUqNsO5oSRrv8MgjAHZ0zgHx60tHzfQ7P3dbzzZPoI";
	private static final String CALLBACK_URL = "TwitOAuth://twitt";

	private Button login;
	private TextView tokenTextView;
	private TextView tokenSecretTextView;

	private OAuthSignpostClient client = new OAuthSignpostClient(TWITTER_KEY,
			TWITTER_SECRET, CALLBACK_URL);

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		login = (Button) findViewById(R.id.login_to_twitter);
		tokenTextView = (TextView) findViewById(R.id.token);
		tokenSecretTextView = (TextView) findViewById(R.id.tokensecret);
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				tokenTextView.setText("....");
				tokenSecretTextView.setText("....");
				AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {

					@Override
					protected String doInBackground(Void... params) {
						String authUrl = null;
						try {

							final URI twitterUrl = client.authorizeUrl();
							authUrl = twitterUrl.toString();
							Log.d("TwitterOAuthActivity", "Got authUrl = "
									+ authUrl);

						} catch (final Exception e) {
							Log.d("TwitterOAuthActivity",
									"Caught exception while creating authUrl "
											+ e.getMessage());
						}

						return authUrl;
					}

					/*
					 * (non-Javadoc)
					 * 
					 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
					 */
					@Override
					protected void onPostExecute(String authUrl) {
						super.onPostExecute(authUrl);
						if (null != authUrl) {
							startActivity(new Intent(Intent.ACTION_VIEW, Uri
									.parse(authUrl)));
						} else {
							Toast.makeText(getApplicationContext(),
									"Unable to create oauth url",
									Toast.LENGTH_SHORT).show();
						}
					}

				};

				asyncTask.execute(null);

			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onNewIntent()
	 */
	@Override
	protected void onNewIntent(Intent intent) {
		super.onResume();
		
		final Uri uri = intent.getData();
		if ((uri != null) && uri.toString().startsWith(CALLBACK_URL)) {
			String verifier = uri.getQueryParameter("oauth_verifier");
			Log.d("TwitterOAuthActivity", "OnResume " + verifier);

			client.setAuthorizationCode(verifier);

			String[] accessTokenAndSecret = client.getAccessToken();

			Log.d("TwitterOAuthActivity", "Access token: "
					+ accessTokenAndSecret[0]);
			Log.d("TwitterOAuthActivity", "Access Token secret: "
					+ accessTokenAndSecret[1]);
			tokenTextView.setText("Access token: " + accessTokenAndSecret[0]);
			tokenSecretTextView.setText("Access Token secret: "
					+ accessTokenAndSecret[1]);
		}

	}

}