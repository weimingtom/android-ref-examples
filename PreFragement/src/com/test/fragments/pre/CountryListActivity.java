package com.test.fragments.pre;

import android.app.ListActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class CountryListActivity extends ListActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
				R.array.country_names, R.layout.list_item));

		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Intent showContent = new Intent(getApplicationContext(),
						CountryInfoActivity.class);
				showContent.putExtra("position", position);
				startActivity(showContent);
			}
		});
	}
}