package com.latestnews.parser;

import java.io.InputStream;
import java.util.List;

import com.latestnews.model.FeedItem;

/**
 * 
 * 
 * @author rohit
 *
 */
public interface IFeedParser {
	List<FeedItem> parseNewsFeed(String data);
	
	List<FeedItem> parseNewsFeed(InputStream in);
}
