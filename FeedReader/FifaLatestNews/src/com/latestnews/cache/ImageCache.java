/**
 * 
 */
package com.latestnews.cache;

import android.graphics.Bitmap;

/**
 * ImageCache to cache the Image.
 * 
 * @author rohit
 *
 */
public interface ImageCache {

	/**
	 * Put Image and url in cache
	 * @param url
	 * @param bitmap
	 */
	public void cache(String url, Bitmap bitmap);
	
	/**
	 * Get Image from cache
	 * @param url
	 * @return
	 */
	public Bitmap get(String url);
}
