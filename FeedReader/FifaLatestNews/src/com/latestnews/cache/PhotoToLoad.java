/**
 * 
 */
package com.latestnews.cache;

import android.widget.ImageView;
/**
 * A Task to Load the url in the ImageView
 * @author rohit
 *
 */
public class PhotoToLoad {

	private String url;
	private ImageView imageView;
	/**
	 * @param url
	 * @param imageView
	 */
	public PhotoToLoad(String url, ImageView imageView) {
		super();
		this.url = url;
		this.imageView = imageView;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @return the imageView
	 */
	public ImageView getImageView() {
		return imageView;
	}
	@Override
	public String toString() {
		return "PhotoToLoad [url=" + url + ", imageView=" + imageView + "]";
	}
	
	
}
