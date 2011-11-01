/**
 * 
 */
package com.latestnews.parser;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.latestnews.model.FeedItem;

/**
 * DefaultHandler implementation to parse FeedItems.
 * 
 * @author yuvrajp
 * 
 */
public class FeedItemHandler extends DefaultHandler {

	public static final String ITEM_TAG = "item";
	public static final String ENCLOSURE_TAG = "enclosure";
	public static final String TITLE_TAG = "media:title";
	public static final String URL_ATTR = "url";

	// boolean value to determine whether it's in a enclosure tag or not
	private boolean enclosureFlag;

	// boolean value to determine whether it's in a title tag or not
	private boolean titleFlag;

	// Data models.
	private List<FeedItem> feedItems;

	FeedItem feedItem;

	/**
	 * This gets called when the xml document is first opened
	 * 
	 * @throws SAXException
	 */
	@Override
	public void startDocument() throws SAXException {
		feedItems = new LinkedList<FeedItem>();

	}

	/**
	 * This gets called at the start of an element. Here we're also setting the
	 * booleans to true if it's at that specific tag. (so we know where we are)
	 * 
	 * @param namespaceURI
	 * @param localName
	 * @param qName
	 * @param atts
	 * @throws SAXException
	 */
	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		

		if(qName.equals(ITEM_TAG)){
			feedItem = new FeedItem();
		}
		else if (qName.equals(ENCLOSURE_TAG)) {
			
			enclosureFlag = true;
			feedItem.setEnclosure(atts.getValue(URL_ATTR));
			feedItems.add(feedItem);
		} else if (qName.equals(TITLE_TAG)) {
			titleFlag = true;
		}
	}

	/**
	 * Called at the end of the element. Setting the booleans to false, so we
	 * know that we've just left that tag.
	 * 
	 * @param namespaceURI
	 * @param localName
	 * @param qName
	 * @throws SAXException
	 */
	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		// Log.i("endElement", localName);

		if (qName.equals(ENCLOSURE_TAG)) {
			enclosureFlag = false;
		} else if (qName.equals(TITLE_TAG)) {
			titleFlag = false;
		}
	}

	/**
	 * Calling when we're within an element. Here we're checking to see if there
	 * is any content in the tags that we're interested in and populating it in
	 * the Config object.
	 * 
	 * @param ch
	 * @param start
	 * @param length
	 */
	@Override
	public void characters(char ch[], int start, int length) {
		String chars = new String(ch, start, length);
		chars = chars.trim();

		if (titleFlag) {
			feedItem.setTitle(chars);
		}
	}

	/**
	 * @return the feedItem
	 */
	public List<FeedItem> getFeedItem() {
		return feedItems;
	}
}
