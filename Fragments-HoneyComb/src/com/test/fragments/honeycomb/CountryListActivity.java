package com.test.fragments.honeycomb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CountryListActivity extends Activity implements
		CountryListFragment.OnCountrySelectedListener {
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_list_fragment);
		
	}

	@Override
	public void onCountrySelected(int position) {
		CountryInfoFragment viewer = (CountryInfoFragment) getFragmentManager()
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