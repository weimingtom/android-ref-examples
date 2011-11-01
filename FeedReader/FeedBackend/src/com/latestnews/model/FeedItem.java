package com.latestnews.model;

/**
 * 
 * 
 * @author rohit
 *
 */
public class FeedItem {
	
	/**
	 * Image url
	 */
	private String enclosure;

	/**
	 * Feed Entry Title
	 */
	private String title;

	
	
	/**
	 * 
	 */
	public FeedItem() {
		super();
	}

	/**
	 * @param enclosure
	 * @param title
	 */
	public FeedItem(String enclosure, String title) {
		super();
		this.enclosure = enclosure;
		this.title = title;
	}

	/**
	 * @return the enclosure
	 */
	public String getEnclosure() {
		return enclosure;
	}

	/**
	 * @param enclosure the enclosure to set
	 */
	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
}
