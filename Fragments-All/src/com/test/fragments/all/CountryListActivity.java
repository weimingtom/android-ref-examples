package com.test.fragments.all;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class CountryListActivity extends FragmentActivity implements
		CountryListFragment.OnCountrySelectedListener {
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_list_fragment);
		
	}

	@Override
	public void onCountrySelected(int position) {
		CountryInfoFragment viewer = (CountryInfoFragment) getSupportFragmentManager()
				.findFragmentById(R.id.country_info_fragment);
		
		
		if (viewer == null || !viewer.isInLayout()) {
			Intent showContent = new Intent(getApplicationContext(),
					CountryInfoActivity.class);
			showContent.putExtra("position", position);
			startActivity(showContent); 
		} else {
			viewer.updateInfo(position);
		}

	}
}