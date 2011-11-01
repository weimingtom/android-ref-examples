/**
 * Copyright 2011 Saurabh Gangarde & Rohit Ghatol (http://code.google.com/p/droidtwit/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License.
 * 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.tutorial.listactivity.manager;

import java.util.ArrayList;
import java.util.List;

import com.tutorial.listactivity.model.Twit;

import android.content.Context;

/**
 * @author rohit
 * 
 */
public class FeedManager {

	private static String[] name = { "Rohit", "Amit", "John", "Suresh",
			"Saurabh", "Praveen", "Hemant", "Abhay", "Amol", "Harman", "Atul",
			"Nitin", "Sumant","Ketan","Rahul","Priya","Tejaswini","Babu","Vaibhav","Harish" };
	private static String[] messages = {"Hi my name is Rohit","Hi I am Amit","What a fine day?","Today is a lovely weather",
		"Nice crowd","Baba Ramdev hmm, interesting...","Someone is political today","Its rains heavy in Pune","Saurabh is funny person","Man Rohit talks fast","Synerzip I wonder what the full form is?",
		"Wonder whether I can give a talk here","Everyone is welcome","Hello all, I am Ketan","Hi I am Rahul, I am a Geek","Its chilly, I need a coffee","Mee too ","Need a vadapav","Me to if it is hot","Chai Garam Chai"};

	private Context context = null;

	/**
	 * 
	 */
	public FeedManager(final Context context) {
		this.context = context;
	}

	/**
	 * Get Twitter feed
	 * 
	 * @param tokens
	 * @return
	 */
	public List<Twit> getSocialFeed(String userName) {
		//Lets ignore userName for sake of this demo
		
		List<Twit> twits = new ArrayList<Twit>();
		//Lets simulate we are fetching things from server and thats why 3 second delay
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int index = 0; index < 20; index++) {
			Twit twit = new  Twit(index, null, name[index], messages[index]);
			twits.add(twit); 
		}

		return twits;
	}

}
