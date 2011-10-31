/**
 * 
 */
package com.test.fragments.honeycomb;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author rohit
 * 
 */
public class CountryInfoFragment extends Fragment {

	private TextView viewer ;
	private String[] countryInfo;
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
		countryInfo = getResources().getStringArray(R.array.country_info);
	    viewer = (TextView) inflater.inflate(R.layout.country_info_view, container, false);
	 
	    return viewer;
	}

	public void updateInfo(int position) {
	    if (viewer != null) {
	        viewer.setText(countryInfo[position]);
	    }
	}
}
