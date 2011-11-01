/**
 * 
 */
package com.latestnews.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

/**
 * @author rohit
 *
 */
public class ApacheHttpService implements IHttpService {

	/* (non-Javadoc)
	 * @see com.latestnews.service.IHttpService#fetchResponse(java.lang.String)
	 */
	public InputStream fetchResponse(String url) {
		InputStream is= null;
		HttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse response = client.execute(getRequest);
			
			is =  response.getEntity().getContent();
		} catch (ClientProtocolException e) {
			Log.d("FifaLatestNews", "Got Exception while reading "+url+" :"+e.getMessage());
		} catch (IOException e) {
			Log.d("FifaLatestNews", "Got Exception while reading "+url+" :"+e.getMessage());
		}
		return is;
	}
	
	/* (non-Javadoc)
	 * @see com.latestnews.service.IHttpService#fetchGZIPResponse(java.lang.String)
	 */
	public InputStream fetchGZIPResponse(String url) {
		InputStream is= null;
		HttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse response = client.execute(getRequest);
			getRequest.setHeader("Accept-Encoding", "gzip,deflate,sdch");
			is =  response.getEntity().getContent();
		} catch (ClientProtocolException e) {
			Log.d("FifaLatestNews", "Got Exception while reading "+url+" :"+e.getMessage());
		} catch (IOException e) {
			Log.d("FifaLatestNews", "Got Exception while reading "+url+" :"+e.getMessage());
		}
		return is;
	}
	
	/* (non-Javadoc)
	 * @see com.latestnews.service.IHttpService#fetchXMLResponse(java.lang.String)
	 */
	public String fetchGZIPXMLResponse(String url) {
		String xmlData= null;
		HttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		getRequest.setHeader("Accept-Encoding", "gzip,deflate,sdch");
		try {
			HttpResponse response = client.execute(getRequest);
			
			xmlData = convertStreamToString(new GZIPInputStream(response.getEntity().getContent()));
		} catch (ClientProtocolException e) {
			Log.d("FifaLatestNews", "Got Exception while reading "+url+" :"+e.getMessage());
		} catch (IOException e) {
			Log.d("FifaLatestNews", "Got Exception while reading "+url+" :"+e.getMessage());
		}
		return xmlData;
	}

	/**
	 * Convert InputStream to String
	 * @param is InputStream which is the source
	 * @return String read from InputStream
	 * @throws IOException If unable to read the input stream.
	 */
	private String convertStreamToString(InputStream is) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();
	    String line = null;
	    while ((line = reader.readLine()) != null) {
	      sb.append(line + "\n");
	    }
	    is.close();
	    return sb.toString();
	  }
}
