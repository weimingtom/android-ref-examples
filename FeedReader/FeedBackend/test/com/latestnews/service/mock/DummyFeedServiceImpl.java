/**
 * 
 */
package com.latestnews.service.mock;

import java.util.ArrayList;
import java.util.List;

import com.latestnews.model.FeedItem;
import com.latestnews.parser.IFeedParser;
import com.latestnews.service.IFeedService;
import com.latestnews.service.IHttpService;

/**
 * @author rohit
 * 
 */
public class DummyFeedServiceImpl implements IFeedService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.latestnews.service.FeedService#fetchLatestFeeds()
	 */
	public List<FeedItem> fetchLatestFeeds() {
		
		//Simulate a server delay
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			//Ignore this
		}
		
		List<FeedItem> feedList = new ArrayList<FeedItem>();

		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/62/76/1506276%5fsmall.jpg",
				"Title1"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/62/76/1506276%5fsmall.jpg",
				"Title2"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/62/75/1506275%5fsmall.jpg",
				"Title3"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/62/72/1506272%5fsmall.jpg",
				"Title4"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/62/60/1506260%5fsmall.jpg",
				"Title5"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/62/56/1506256%5fsmall.jpg",
				"Title6"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/62/54/1506254%5fsmall.jpg",
				"Title7"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/62/53/1506253%5fsmall.jpg",
				"Title8"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/62/42/1506242%5fsmall.jpg",
				"Title9"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/62/33/1506233%5fsmall.jpg",
				"Title10"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/62/30/1506230%5fsmall.jpg",
				"Title11"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/62/18/1506218%5fsmall.jpg",
				"Title12"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/61/63/1506163%5fsmall.jpg",
				"Title13"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/61/57/1506157%5fsmall.jpg",
				"Title14"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/61/53/1506153%5fsmall.jpg",
				"Title15"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/61/44/1506144%5fsmall.jpg",
				"Title16"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/61/41/1506141%5fsmall.jpg",
				"Title17"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/60/78/1506078%5fsmall.jpg",
				"Title18"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/clubfootball/01/50/60/76/1506076%5fsmall.jpg",
				"Title19"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/60/75/1506075%5fsmall.jpg",
				"Title20"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/60/73/1506073%5fsmall.jpg",
				"Title21"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/60/71/1506071%5fsmall.jpg",
				"Title22"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/66/77/1506677%5fsmall.jpg",
				"Title23"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/66/70/1506670%5fsmall.jpg",
				"Title24"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/66/70/1506670%5fsmall.jpg",
				"Title25"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/66/59/1506659%5fsmall.jpg",
				"Title26"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/tournament/competition/01/50/65/82/1506582%5fsmall.jpg",
				"Title27"));
		feedList.add(new FeedItem(
				"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/62/79/1506279%5fsmall.jpg",
				"Title28"));

		return feedList;
	}

	@Override
	public void setHttpService(IHttpService httpServer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFeedParser(IFeedParser feedParser) {
		// TODO Auto-generated method stub
		
	}
}
