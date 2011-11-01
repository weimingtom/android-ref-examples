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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceExample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button simpleService = (Button)findViewById(R.id.simple_service);
        simpleService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent navIntent = new Intent(getApplicationContext(), SimpleServiceExample.class);
				startActivity(navIntent);
				
			}
		});
        
        
        Button simpleBindService = (Button)findViewById(R.id.bind_service_simple);
        simpleBindService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent navIntent = new Intent(getApplicationContext(), SimpleBindServiceExample.class);
				startActivity(navIntent);
				
			}
		});
        
        
        Button complexBindService = (Button)findViewById(R.id.bind_service_complex);
        complexBindService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent navIntent = new Intent(getApplicationContext(), ComplexBindServiceExample.class);
				startActivity(navIntent);
				
			}
		});
    }
}