package com.latestnews.service;

import java.util.List;

import com.latestnews.model.FeedItem;
import com.latestnews.parser.IFeedParser;

/**
 * POJO Service Interface to fetch fifa feeds synchronously.
 * @author rohit
 *
 */
public interface IFeedService{

	public void setHttpService(IHttpService httpServer);
	
	public void setFeedParser(IFeedParser feedParser);
	
	public List<FeedItem> fetchLatestFeeds();
}
