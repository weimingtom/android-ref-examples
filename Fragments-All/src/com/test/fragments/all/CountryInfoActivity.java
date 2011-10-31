/**
 * 
 */
package com.test.fragments.all;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * @author rohit
 * 
 */
public class CountryInfoActivity extends FragmentActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.country_info_fragment);
		
		 
	    Intent launchingIntent = getIntent();
	    
	    int position =launchingIntent.getExtras().getInt("position");
	 
	    CountryInfoFragment viewer = (CountryInfoFragment) getSupportFragmentManager()
	            .findFragmentById(R.id.country_info_fragment);
	 
	    viewer.updateInfo(position);
	}
}
