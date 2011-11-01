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
package com.social.services.managers;

import java.util.ArrayList;
import java.util.List;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.Twitter.User;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.social.Setting;
import com.social.model.OAuthTokens;
import com.social.model.Twit;

/**
 * @author rohit
 * 
 */
public class FeedManager
{

	Context context = null;


	/**
	 * 
	 */
	public FeedManager(final Context context)
	{
		this.context = context;
	}


	/**
	 * 
	 * @return twitter feed refresh interval
	 */
	public long getTwitterFeedRefreshInterval()
	{
		long refreshInterval = 60000;
		final SharedPreferences settings = context.getSharedPreferences(Setting.SETTING_VALUES, 0);

		refreshInterval = settings.getLong(Setting.REFRESH_INTERVAL, 60000);

		return refreshInterval;
	}


	/**
	 * Set refresh interval value in shared preferences
	 * 
	 * @param interval
	 */
	public void setTwitterFeedRefreshInterval(final long interval)
	{
		final SharedPreferences settings = context.getSharedPreferences(Setting.SETTING_VALUES, Context.MODE_PRIVATE);
		final Editor editor = settings.edit();
		editor.putLong(Setting.REFRESH_INTERVAL, interval * 60000);
		editor.commit();
	}


	/**
	 * Get Twitter feed
	 * 
	 * @param tokens
	 * @return
	 */
	public List<Twit> getSocialFeed(final OAuthTokens tokens)
	{
		List<Twit> twits = null;
		final OAuthSignpostClient client = new OAuthSignpostClient(OAuthAuthenticatonMgr.TWITTER_KEY,
				OAuthAuthenticatonMgr.TWITTER_SECRET, tokens.getAccessToken(), tokens.getAccessSecret());
		final Twitter twitter = new Twitter("saurabh", client);

		final List<Twitter.Status> statues = twitter.getHomeTimeline();
		twits = new ArrayList<Twit>(statues.size());
		for ( final Twitter.Status status : statues )
		{
			final User user = status.getUser();

			final String twitText = status.getText();
			twits
					.add(new Twit(status.getId().longValue(), user.getName(), user.getProfileImageUrl().toString(), twitText));
		}
		return twits;

	}


	/**
	 * set status on twitter
	 * 
	 * @param tweet
	 * @param tokens
	 */
	public void tweet(final String tweet, final OAuthTokens tokens)
	{
		final OAuthSignpostClient client = new OAuthSignpostClient(OAuthAuthenticatonMgr.TWITTER_KEY,
				OAuthAuthenticatonMgr.TWITTER_SECRET, tokens.getAccessToken(), tokens.getAccessSecret());
		final Twitter twitter = new Twitter("saurabh", client);
		twitter.setStatus(tweet);
	}
}
