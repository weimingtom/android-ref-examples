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
package com.tutorial.service;

import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.tutorial.service.services.bindcomplex.ComplexBindService;
import com.tutorial.service.services.bindcomplex.IComplexService;
import com.tutorial.service.services.bindcomplex.model.Twit;

public class ComplexBindServiceExample extends Activity {

	private IComplexService complexService;
 
	private  ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Toast.makeText(getApplicationContext(), "Service Disconnected",
					Toast.LENGTH_SHORT).show();

			complexService = null;

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Toast.makeText(getApplicationContext(),
					"Service Bind successful", Toast.LENGTH_SHORT).show();
			complexService = IComplexService.Stub.asInterface(service);
			registerUIEventHandlers();
		}
	};
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.complex_service);

		
		Intent serviceIntent = new Intent(getApplicationContext(),
				ComplexBindService.class);
		boolean result = bindService(serviceIntent, connection,
				Context.BIND_AUTO_CREATE);
		Log.d(ComplexBindServiceExample.class.getSimpleName(),
				"Service bind result = " + result);

	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbindService(connection);	
	}

	private void registerUIEventHandlers() {

		Button serviceButton = (Button) findViewById(R.id.add_button);

		serviceButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					List<Twit> result = complexService.getSocialFeed();
					Toast.makeText(getApplicationContext(),
							"Got " + result.size() + " tweets",
							Toast.LENGTH_SHORT).show();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
}