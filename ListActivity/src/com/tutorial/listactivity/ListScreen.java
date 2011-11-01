/**
 * Copyright 2011 Saurabh Gangarde & Rohit Ghatol (http://code.google.com/p/droidtwit/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.tutorial.listactivity;

import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import com.tutorial.listactivity.adapter.TwitAdapter;
import com.tutorial.listactivity.manager.FeedManager;
import com.tutorial.listactivity.model.Twit;

public class ListScreen extends ListActivity { 
	
	private FeedManager mgr;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mgr = new FeedManager(getApplicationContext());
		loadData();
	}

	private void loadData() {
		AsyncTask<String, Void, List<Twit>> asyncTask = new AsyncTask<String, Void, List<Twit>>() {
			private ProgressDialog progressDialog = new ProgressDialog(ListScreen.this);
			

			/* (non-Javadoc)
			 * @see android.os.AsyncTask#onPreExecute()
			 */
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				progressDialog.setTitle("Loading Tweets");
				if(!progressDialog.isShowing()){
					progressDialog.show();
				}
			}

			@Override
			protected List<Twit> doInBackground(String... params) {
				//Following actions will be done in background
				return mgr.getSocialFeed(params[0]);
			}
			
			/* (non-Javadoc)
			 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
			 */
			@Override
			protected void onPostExecute(List<Twit> result) {
				super.onPostExecute(result);
				if(progressDialog.isShowing()){
					progressDialog.hide();
				}
				TwitAdapter listAdapter = new TwitAdapter(getApplicationContext(), result);
				setListAdapter(listAdapter);

			}
		};
		asyncTask.execute("Saurabh");
	}
}