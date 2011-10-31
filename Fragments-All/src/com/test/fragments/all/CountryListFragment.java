/**
 * 
 */
package com.test.fragments.all;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author rohit
 * 
 */
public class CountryListFragment extends ListFragment {
	
	public interface OnCountrySelectedListener {
		public void onCountrySelected(int position);
	}

	private OnCountrySelectedListener countrySelectedListener;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.ListFragment#onListItemClick(android.widget.ListView,
	 * android.view.View, int, long)
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		if (null != countrySelectedListener) {
			countrySelectedListener.onCountrySelected(position);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(ArrayAdapter.createFromResource(getActivity()
				.getApplicationContext(), R.array.country_names,
				R.layout.list_item));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Fragment#onAttach(android.app.Activity)
	 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof OnCountrySelectedListener) {
			this.countrySelectedListener = (OnCountrySelectedListener) activity;
		}
	}

	
	

	
}
