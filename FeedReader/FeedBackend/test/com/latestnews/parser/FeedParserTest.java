/**
 * 
 */
package com.latestnews.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import junit.framework.TestCase;

import com.latestnews.model.FeedItem;

/**
 * @author rohit
 *
 */
public class FeedParserTest extends TestCase {
	private final String TEST_FILE_PATH = "test//data.xml";
	
	String[] urls= {"http://www.fifa.com/mm/photo/worldfootball/clubfootball/01/50/68/50/1506850%5fsmall.jpg", 
			"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/68/47/1506847%5fsmall.jpg",
			"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/68/46/1506846%5fsmall.jpg"};
	
	String[] titles = {"Alexander Hleb, new signing of Wolfsburg",
			"Germany's midfielder Mario Goetze celebrates",
			"Mario Goetze (R) of Germany celebrates"};
	
	/**
	 * Test method for {@link com.latestnews.parser.FeedParser#parseNewsFeed()}.
	 * @throws IOException 
	 */
	public void testParseNewsFeed() throws IOException {
		
		
		IFeedParser feedParser = new FeedParser();
		
		InputStream in = new FileInputStream(new File (TEST_FILE_PATH));

		
		List<FeedItem> feedItems =  feedParser.parseNewsFeed(in);
		
		assertNotNull(feedItems);
		assertEquals(feedItems.size(), 200);
		for(int i=0; i<urls.length; i++) {
			assertTrue(urls[i].equals(feedItems.get(i).getEnclosure()));
			assertTrue(titles[i].equals(feedItems.get(i).getTitle()));
		}
	}

}
