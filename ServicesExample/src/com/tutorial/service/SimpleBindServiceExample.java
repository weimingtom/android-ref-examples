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
import android.widget.EditText;
import android.widget.Toast;

import com.tutorial.service.services.bindsimple.ICalcService;
import com.tutorial.service.services.bindsimple.SimpleBindService;

public class SimpleBindServiceExample extends Activity {

	private ICalcService calcService;

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Toast.makeText(getApplicationContext(), "Service Disconnected",
					Toast.LENGTH_SHORT).show();

			calcService = null;

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Toast.makeText(getApplicationContext(), "Service Bind successful",
					Toast.LENGTH_SHORT).show();
			calcService = ICalcService.Stub.asInterface(service);
			registerUIEventHandlers();
		}
	};
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_service);

		
		
		Intent serviceIntent = new Intent(getApplicationContext(),SimpleBindService.class);
		boolean result = bindService(serviceIntent, connection,Context.BIND_AUTO_CREATE);
		Log.d(SimpleBindServiceExample.class.getSimpleName(),"Service bind result = "+result);

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
		final EditText valueEditText = (EditText) findViewById(R.id.value_edittext);
		Button addButton = (Button) findViewById(R.id.add_button);
		Button substractButton = (Button) findViewById(R.id.substract_button);

		addButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					final int value = Integer.valueOf(valueEditText.getText()
							.toString());
					
					String result = "Result = " + calcService.add(value);
					Toast.makeText(getApplicationContext(), result,
							Toast.LENGTH_SHORT).show();

				} catch (NumberFormatException ex) {
					valueEditText.setText("");

				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		substractButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					final int value = Integer.valueOf(valueEditText.getText()
							.toString());
					String result = "Result = " + calcService.substract(value);
					Toast.makeText(getApplicationContext(), result,
							Toast.LENGTH_SHORT).show();

				} catch (NumberFormatException ex) {
					valueEditText.setText("");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
}