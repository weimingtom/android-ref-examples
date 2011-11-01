package com.sparklytix.factoreal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.sparklytix.factoreal.c2dm.C2DMProcessor;
import com.sparklytix.factoreal.mgr.AccountPreferences;

public class SocialMeActivity extends Activity {

	private static final String NEW_SCRAPS = "new_scraps";
	private AccountPreferences prefs = new AccountPreferences();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		if (!isLoginAvailable()) {
			Intent navIntent = new Intent(getApplicationContext(),
					LoginActivity.class);
			startActivity(navIntent);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		Log.d("SocialMeActivity", "onResume()");
		super.onResume();
		if (isLoginAvailable()) {
			String payload = getIntent().getStringExtra("payload");
			if (null != payload) {
				if (NEW_SCRAPS.equals(payload)) {
					// Fetch lasted scraps from server to show them.
				} else {
					Dialog dialog = new Dialog(SocialMeActivity.this);
					dialog.setCancelable(true);
					dialog.setTitle("Please upgrade Application");
					dialog.show();

				}
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = new MenuInflater(getApplicationContext());
		inflater.inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPrepareOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onPrepareOptionsMenu(menu);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			Intent navIntent = new Intent(getApplicationContext(),
					LoginActivity.class);
			startActivity(navIntent);
			break;
		default:
			break;

		}
		return super.onOptionsItemSelected(item);
	}

	private boolean isLoginAvailable() {
		return null != prefs.getUserName(getApplicationContext());
	}
}