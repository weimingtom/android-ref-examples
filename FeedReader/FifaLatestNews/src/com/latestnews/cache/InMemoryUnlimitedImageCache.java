/**
 * 
 */
package com.latestnews.cache;

import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;

/**
 * In Memory and unlimited (as much as memory permits) Image Cache
 * @author rohit
 *
 */
public class InMemoryUnlimitedImageCache implements ImageCache {

	
	private Map<String, Bitmap> cache = new HashMap<String, Bitmap>();
	/* (non-Javadoc)
	 * @see com.latestnews.cache.ImageCache#cache(java.lang.String, android.graphics.Bitmap)
	 */
	public void cache(String url, Bitmap bitmap) {
		cache.put(url,bitmap);

	}

	/* (non-Javadoc)
	 * @see com.latestnews.cache.ImageCache#get(java.lang.String)
	 */
	public Bitmap get(String url) {
		return cache.get(url);
	}

}
