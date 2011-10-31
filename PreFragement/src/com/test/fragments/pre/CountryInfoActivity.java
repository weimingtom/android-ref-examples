/**
 * 
 */
package com.test.fragments.pre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author rohit
 * 
 */
public class CountryInfoActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_info_view);
		final String[] countryInfos = getResources().getStringArray(R.array.country_info);
		Intent launchingIntent = getIntent();
		int position = launchingIntent.getExtras().getInt("position");

		TextView countryInfoTextView = (TextView) findViewById(R.id.country_info_view);
		countryInfoTextView.setText(countryInfos[position]);
		
	}
}
