/**
 * 
 */
package com.sparklytix.factoreal.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;

/**
 * @author rohit
 * 
 */
public class StringUtils {

	public static String from(InputStream is) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));

			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			is.close();
			
		} catch (IOException e) {
			Log.d("StringUtils","StringUtils.from() Got Exception = "+e.getMessage());
		}
		return sb.toString();
	}

}
