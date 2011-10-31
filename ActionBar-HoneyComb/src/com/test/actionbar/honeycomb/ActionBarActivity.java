package com.test.actionbar.honeycomb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

public class ActionBarActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.shapemenu, menu);
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		searchView.setOnSearchClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Lets Search", Toast.LENGTH_SHORT);
				
			}
		});
		searchView.setOnQueryTextListener(new OnQueryTextListener() {
			
			@Override
			public boolean onQueryTextSubmit(String query) {
				Toast.makeText(getApplicationContext(), "onQueryTextSubmit "+query, Toast.LENGTH_SHORT);
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String newText) {
				Toast.makeText(getApplicationContext(), "onQueryTextSubmit "+newText, Toast.LENGTH_SHORT);
				return false;
			}
		});
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPrepareOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	        	Toast.makeText(getApplicationContext(), "Clicked Home", Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.circle:
	        	Toast.makeText(getApplicationContext(), "Clicked Circle", Toast.LENGTH_SHORT).show();
	        	break;
	        case R.id.rect:
	        	Toast.makeText(getApplicationContext(), "Clicked Rect", Toast.LENGTH_SHORT).show();
	        	break;

	        case R.id.star:
	        	Toast.makeText(getApplicationContext(), "Clicked Star", Toast.LENGTH_SHORT).show();
	        	break;

	        case R.id.triangle:
	        	Toast.makeText(getApplicationContext(), "Clicked Triangle", Toast.LENGTH_SHORT).show();
	        	break;

	        default:
	            return super.onOptionsItemSelected(item);
	    }
		return false;
	}

}