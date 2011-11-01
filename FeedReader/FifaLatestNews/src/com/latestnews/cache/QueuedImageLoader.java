/**
 * 
 */
package com.latestnews.cache;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.latestnews.R;
import com.latestnews.service.IHttpService;



/**
 * Loads the Images Queued in this class 
 * @author rohit
 * 
 */
public class QueuedImageLoader implements ImageLoader {

	/**
	 * Http Service to load inputstream of imate
	 */
	private IHttpService httpService = null;
	/**
	 * Delegating caching to Image Cache
	 */
	private ImageCache imageCache = null;
	/**
	 * A Blocking queue to queue up PhoneToLoad Task
	 */
	private BlockingQueue<PhotoToLoad> photoQueue = new LinkedBlockingQueue<PhotoToLoad>();

	/**
	 * Map for image url and its matching image view
	 */
	private final Map<ImageView, String> imageViews = Collections.synchronizedMap(new WeakHashMap<ImageView, String>());
	
	/**
	 * Default Constructor. Also starts the thread which polls the queue to
	 * fetch the image
	 */
	public QueuedImageLoader() {
		Runnable runnable = new Runnable() {

			public void run() {

				try {

					while (true) {
						// Blocking call
						final PhotoToLoad photoToLoadTask = photoQueue.take();
						Log.d("FifaLatestNews", "Loaded "+photoToLoadTask );
						final Bitmap bitmap = getBitmap(photoToLoadTask
								.getUrl());
						imageCache.cache(photoToLoadTask.getUrl(),bitmap);
						String url = imageViews.get(photoToLoadTask.getImageView());
						if ( url != null && url.equals(photoToLoadTask.getUrl()) )
						{
							photoToLoadTask.getImageView().post(new Runnable() {

								public void run()
								{
									photoToLoadTask.getImageView().setImageBitmap(bitmap);

								}
							});
						}

					}
				} catch (InterruptedException iex) {
					Log.d("FifaLastestNews","Caught Exception while loading queue bitmap "+iex);
				} finally {

				}

			}
		};
		Thread imageLoadThread = new Thread(runnable);
		imageLoadThread.start();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.latestnews.cache.ImageLoader#queueImage(java.lang.String,
	 * android.widget.ImageView)
	 */
	public void queueImage(final String url, final ImageView imageView) {
		// FIXME we are not checking for null for imagecache here

		final Bitmap cachedBitMap = imageCache.get(url);
		imageViews.put(imageView, url);
		if ( null != cachedBitMap )
		{
			imageView.setImageBitmap(cachedBitMap);
		}
		else
		{
			photoQueue.add(new PhotoToLoad(url, imageView));
			imageView.setImageResource(R.drawable.loading);
		}

	}

	public void setImageCache(ImageCache imageCache) {
		this.imageCache = imageCache;

	}

	/**
	 * 
	 * @param url
	 * @return Bitmap read from url
	 */
	private Bitmap getBitmap(String url) {
		Bitmap bitmap = null;
		try {

			
			InputStream is = httpService.fetchResponse(url);
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 3;
			return BitmapFactory.decodeStream(is, null,
					options); 

		} catch (Exception ex) {
			Log.d("FifaLatestNews",
					"Caught Exception while reading bitmap from url " + url +" "+ex);

		}
		return bitmap;
	}

	public void setHttpService(IHttpService httpService) {
		this.httpService=httpService;
		
	}

	

	

}
