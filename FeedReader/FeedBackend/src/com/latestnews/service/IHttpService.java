/**
 * 
 */
package com.latestnews.service;

import java.io.InputStream;

/**
 * HttpService (platform independent) to fetch XML feed from a URL
 * @author rohit
 *
 */
public interface IHttpService {

	/**
	 * Fetches XML from a URL - typically RSS Feed
	 * @param url The url to read xml from
	 * @return String if able to read data, else returns null
	 */
	public String fetchGZIPXMLResponse(String url);
	
	
	/**
	 * 
	 * @param url Load resource from URL
	 * @return InputStream for the given URL
	 */
	public InputStream fetchResponse(String url);
	
	/**
	 * 
	 * @param url Load resource from URL
	 * @return GZip InputStream for the given URL
	 */
	public InputStream fetchGZIPResponse(String url);
	
}
