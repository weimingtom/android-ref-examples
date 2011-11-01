/**
 * 
 */
package com.latestnews.cache;

import com.latestnews.service.IHttpService;

import android.widget.ImageView;

/**
 * Loads Images in a sequential manner and also caches it
 * 
 * @author rohit
 * 
 */
public interface ImageLoader {

	/**
	 * 
	 * @param imageCache
	 *            Setting the ImageCache used by this Image Loader (Dependency
	 *            Inject)
	 */
	public void setImageCache(ImageCache imageCache);

	
	/**
	 * Set the Http Service to be used to fetch images
	 * @param httpService
	 */
	public void setHttpService(IHttpService httpService);
	/**
	 * Queue up Image for Loading in given imageView
	 * 
	 * @param url
	 *            The url from where Image has to be loaded
	 * @param imageView
	 *            The ImageView in which the image has to be displayed
	 */
	public void queueImage(String url, ImageView imageView);
	
	
	

}
