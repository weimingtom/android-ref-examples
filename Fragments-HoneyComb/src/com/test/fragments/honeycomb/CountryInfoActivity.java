/**
 * 
 */
package com.test.fragments.honeycomb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author rohit
 * 
 */
public class CountryInfoActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_info_fragment);
		
		 
	    Intent launchingIntent = getIntent();
	    
	    int position =launchingIntent.getExtras().getInt("position");
	 
	    CountryInfoFragment viewer = (CountryInfoFragment) getFragmentManager()
	            .findFragmentById(R.id.country_info_fragment);
	 
	    viewer.updateInfo(position);
	}
}
