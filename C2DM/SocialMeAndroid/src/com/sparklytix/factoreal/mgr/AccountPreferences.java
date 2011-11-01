/**
 * 
 */
package com.sparklytix.factoreal.mgr;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

/**
 * @author rohit
 *
 */
public class AccountPreferences {

	private static final String ACCOUNT_SHARED_PREFERENCE = "ACCOUNT";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String FIRSTNAME = "firstName";
	private static final String LASTNAME = "lastName";
	
	private static final String C2DM_REGISTRATION_ID = "C2DM_REGISTRATION_ID";
	private static final String SOCIALUSER_JSON = "socialuser_json";
	
	
	
	
	public void storeSignUpInfo(Context context, String firstName,String lastName,String userName,String password){
		Log.d("AccountPreferences","login()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		Editor editor = pref.edit();
		editor.putString(USERNAME, userName);
		editor.putString(PASSWORD, password);
		editor.putString(FIRSTNAME, firstName);
		editor.putString(LASTNAME, lastName);
		editor.commit();
	}
	
	public void storeLoginInfo(Context context, String userName,String password){
		Log.d("AccountPreferences","login()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		Editor editor = pref.edit();
		editor.putString(USERNAME, userName);
		editor.putString(PASSWORD, password);
		editor.commit();
	}
	
	public void storeSocialUserJSON(Context context, String socialUserJSON){
		Log.d("AccountPreferences","storeSocailUser()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		Editor editor = pref.edit();
		editor.putString(SOCIALUSER_JSON, socialUserJSON);
		editor.commit();
	}
	
	public void storeC2DMRegistrationId(Context context, String c2dmRegistrationId){
		Log.d("AccountPreferences","storeC2DMRegistrationId()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		Editor editor = pref.edit();
		editor.putString(C2DM_REGISTRATION_ID, c2dmRegistrationId);
		editor.commit();
	}
	
	public String getUserName(Context context){
		Log.d("AccountPreferences","getUserName()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		return pref.getString(USERNAME, null);
	}
	
	public String getPassword(Context context){
		Log.d("AccountPreferences","getPassword()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		return pref.getString(PASSWORD, null);
		
	}
	
	
	public String getFirstName(Context context){
		Log.d("AccountPreferences","getFirstName()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		return pref.getString(FIRSTNAME, null);
		
	}
	
	public String getLastName(Context context){
		Log.d("AccountPreferences","getLastName()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		return pref.getString(LASTNAME, null);
		
	}
	
	public String getSocialUserJSON(Context context){
		Log.d("AccountPreferences","getSocialUserJSON()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		return pref.getString(SOCIALUSER_JSON, null);
	}
	
	public String getC2DMRegistrationId(Context context){
		Log.d("AccountPreferences","getC2DMRegistrationId()");
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		return pref.getString(C2DM_REGISTRATION_ID, null);
	}
	
	public void clearAll(Context context){
		SharedPreferences pref = context.getSharedPreferences(ACCOUNT_SHARED_PREFERENCE, 0);
		
		Editor editor = pref.edit();
		editor.putString(AccountPreferences.C2DM_REGISTRATION_ID, null);
		editor.putString(AccountPreferences.FIRSTNAME, null);
		editor.putString(AccountPreferences.LASTNAME, null);
		editor.putString(AccountPreferences.PASSWORD, null);
		editor.putString(AccountPreferences.SOCIALUSER_JSON, null);
		editor.putString(AccountPreferences.USERNAME, null);
		
		editor.commit();
	}
	
}
