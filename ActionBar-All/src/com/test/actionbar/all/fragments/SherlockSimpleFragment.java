/**
 * 
 */
package com.test.actionbar.all.fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.Menu;

import android.support.v4.view.MenuItem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.test.actionbar.all.R;


import android.view.MenuInflater;




/**
 * @author rohit
 * 
 */
public class SherlockSimpleFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedStateInstance){

		setHasOptionsMenu(true);
		
		return inflater.inflate(R.layout.main, container);

	}

	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
		System.out.println("onCreateOptionsMenu()");
		inflater.inflate(R.menu.shapemenu, menu);

		super.onCreateOptionsMenu(menu, inflater);

	}
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	        	Toast.makeText(this.getActivity().getApplicationContext(), "Clicked Home", Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.circle:
	        	Toast.makeText(this.getActivity().getApplicationContext(), "Clicked Circle", Toast.LENGTH_SHORT).show();
	        	break;
	        case R.id.rect:
	        	Toast.makeText(this.getActivity().getApplicationContext(), "Clicked Rect", Toast.LENGTH_SHORT).show();
	        	break;

	        case R.id.star:
	        	Toast.makeText(this.getActivity().getApplicationContext(), "Clicked Star", Toast.LENGTH_SHORT).show();
	        	break;

	        case R.id.triangle:
	        	Toast.makeText(this.getActivity().getApplicationContext(), "Clicked Triangle", Toast.LENGTH_SHORT).show();
	        	break;

	        default:
	            return super.onOptionsItemSelected((android.support.v4.view.MenuItem) item);
	    }
		return false;
	}

}




