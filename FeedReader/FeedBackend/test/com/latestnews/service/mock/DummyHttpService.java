/**
 * 
 */
package com.latestnews.service.mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.latestnews.service.IHttpService;

/**
 * @author rohit
 * 
 */
public class DummyHttpService implements IHttpService {

	private static final String dummyData = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><rss version=\"2.0\" xmlns:media=\"http://search.yahoo.com/mrss/\"><channel><title><![CDATA[FIFA.com - Latest Photos]]></title><link>http://www.fifa.com/index.html</link><description>The latest football photos from across the globe provided to you by FIFA.com. Tags: football photo, soccer photo, photo, pics, world cup, fifa world cup, fifa, soccer, football, sport</description>"
			+ "<language>en</language><copyright>Copyright ©1994 - 2011 FIFA. All rights reserved</copyright><pubDate>Wed, 07 Sep 2011 15:03:00 GMT</pubDate><lastBuildDate>Wed, 07 Sep 2011 15:03:50 GMT</lastBuildDate><category>FIFA.com</category><image><title>FIFA.com</title><url>http://www.fifa.com/imgml/rssheader.gif</url><link>http://www.fifa.com/index.html</link><width>139</width><height>28</height><description>FIFA.com RSS</description></image><item><title><![CDATA[Alexander Hleb, new signing of Wolfsburg]]></title><link>http://www.fifa.com/worldfootball/photo/photolist.html?cid=rssfeed&amp;att=#1506850</link><guid isPermaLink=\"false\">1506850</guid><description><![CDATA[<table><tr><td><a href=\"http://www.fifa.com/worldfootball/photo/photolist.html?cid=rssfeed&amp;att=#1506850\" alt=\"Alexander Hleb, new signing of Wolfsburg\"><img src=\"http://www.fifa.com/mm/photo/worldfootball/clubfootball/01/50/68/50/1506850%5fsmall.jpg\"></img></a></td><td>Alexander Hleb, new signing of the German first division Bundesliga football club VfL Wolfsburg, poses for photographers with his jersey at the club's stadium in Wolfsburg on September 7, 2011. Hleb has come from FC Birmingham where he was on loan from FC Barcelona.</td></table>]]></description><enclosure length=\"150\" url=\"http://www.fifa.com/mm/photo/worldfootball/clubfootball/01/50/68/50/1506850%5fsmall.jpg\" type=\"image/jpeg\" /><media:title><![CDATA[Alexander Hleb, new signing of Wolfsburg]]></media:title><media:description><![CDATA[Alexander Hleb, new signing of the German first division Bundesliga football club VfL Wolfsburg, poses for photographers with his jersey at the club's stadium in Wolfsburg on September 7, 2011. Hleb has come from FC Birmingham where he was on loan from FC Barcelona.]]></media:description><media:thumbnail url=\"http://www.fifa.com/mm/photo/worldfootball/clubfootball/01/50/68/50/1506850%5fsmall.jpg\" /><media:content url=\"http://www.fifa.com/mm/photo/worldfootball/clubfootball/01/50/68/50/1506850%5ffull-lnd.jpg\" width=\"652\" height=\"354\" type=\"image/jpeg\" /><media:credit>© AFP</media:credit><pubDate>Wed, 07 Sep 2011 15:03:00 GMT</pubDate><category>Area=World Football</category><category>Section=Club Football</category><category>Kind=Photo</category></item><item><title><![CDATA[Germany's midfielder Mario Goetze celebrates]]></title><link>http://www.fifa.com/worldfootball/photo/photolist.html?cid=rssfeed&amp;att=#1506847</link><guid isPermaLink=\"false\">1506847</guid><description><![CDATA[<table><tr><td><a href=\"http://www.fifa.com/worldfootball/photo/photolist.html?cid=rssfeed&amp;att=#1506847\" alt=\"Germany's midfielder Mario Goetze celebrates\"><img src=\"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/68/47/1506847%5fsmall.jpg\"></img></a></td><td>Germany's midfielder Mario Goetze celebrates scoring during the Germany vs Brazil international friendly football match at the Mercedes-Benz Arena in Stuttgart, southern Germany, on August 10, 2011. Germany won the match 3-2.</td></table>]]></description><enclosure length=\"150\" url=\"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/68/47/1506847%5fsmall.jpg\" type=\"image/jpeg\" /><media:title><![CDATA[Germany's midfielder Mario Goetze celebrates]]></media:title><media:description><![CDATA[Germany's midfielder Mario Goetze celebrates scoring during the Germany vs Brazil international friendly football match at the Mercedes-Benz Arena in Stuttgart, southern Germany, on August 10, 2011. Germany won the match 3-2.]]></media:description><media:thumbnail url=\"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/68/47/1506847%5fsmall.jpg\" /><media:content url=\"http://www.fifa.com/mm/photo/worldfootball/nationalteams/01/50/68/47/1506847%5ffull-prt.jpg\" width=\"384\" height=\"512\" type=\"image/jpeg\" /><media:credit>© AFP</media:credit><pubDate>Wed, 07 Sep 2011 14:59:00 GMT</pubDate><category>Area=World Football</category><category>Section=National Teams</category><category>Kind=Photo</category></item></channel></rss>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.latestnews.service.IHttpService#fetchXMLResponse(java.lang.String)
	 */
	@Override
	public String fetchGZIPXMLResponse(String url) {

		return dummyData;
	}

	@Override
	public InputStream fetchResponse(String url) {
		InputStream is = null;
		try {
			is =   new ByteArrayInputStream(dummyData.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public InputStream fetchGZIPResponse(String url) {
		//FIXME To be implemented
		return null;
	}

}
