/**
 * 
 */
package com.latestnews.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.latestnews.model.FeedItem;

/**
 * Parser to parse news rss feed
 * 
 * @author rohit
 * 
 */
public class FeedParser implements IFeedParser {

	/**
	 * Parse feed from string data
	 */
	@Override
	public List<FeedItem> parseNewsFeed(String data) {
		List<FeedItem> result = null;
		try {
			result =  parseNewsFeed(new ByteArrayInputStream(data.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Caught Exception parsing News Feed Data in UTF-8");
		}
		return result;
	}

	/**
	 * Parse feed from input stream
	 */
	@Override
	public List<FeedItem> parseNewsFeed(InputStream in) {
		List<FeedItem> feedItems = null;

		// sax stuff
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			XMLReader xr = sp.getXMLReader();

			FeedItemHandler feedDataHandler = new FeedItemHandler();
			xr.setContentHandler(feedDataHandler);

			xr.parse(new InputSource(in));

			feedItems = feedDataHandler.getFeedItem();

		} catch (ParserConfigurationException pce) {
			// Log.e("SAX XML", "sax parse error", pce);
		} catch (SAXException se) {
			// Log.e("SAX XML", "sax error", se);
		} catch (IOException ioe) {
			// Log.e("SAX XML", "sax parse io error", ioe);
		}

		return feedItems;
	}

}
