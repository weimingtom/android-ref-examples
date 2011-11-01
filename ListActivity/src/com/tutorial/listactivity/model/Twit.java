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
package com.tutorial.listactivity.model;


/**
 * @author rohit
 * 
 */
public class Twit  {

	private long twitId;
	private String imageUrl;
	private String profileName;
	private String twitMessage;

	
	/**
	 * @param imageUrl
	 * @param profileName
	 * @param twitMessage
	 */
	public Twit(long twitId,String imageUrl, String profileName, String twitMessage) {
		super();
		this.twitId=twitId;
		this.imageUrl = imageUrl;
		this.profileName = profileName;
		this.twitMessage = twitMessage;
	}

	/**
	 * @return the twitId
	 */
	public long getTwitId() {
		return twitId;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * @return the twitMessage
	 */
	public String getTwitMessage() {
		return twitMessage;
	}

	

}
