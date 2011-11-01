package com.sparklytix.factoreal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.sparklytix.factoreal.mgr.AccountManager;
import com.sparklytix.factoreal.mgr.AccountPreferences;
import com.sparklytix.factoreal.mgr.InvalidCredentialsException;
import com.sparklytix.factoreal.mgr.NetworkException;

public class LoginActivity extends Activity {

	private static final int SIGNUP_CODE = 100;
	
	private EditText userNameEditText = null;
	private EditText passwordEditText = null;
	private Button loginButton = null;
	private Button cancelButton = null;
	
	private Button signupRequired = null;
	
	private AccountPreferences prefs = new AccountPreferences();
	private AccountManager acctMgr = new AccountManager(prefs);
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("SocialMe","LoginActivity.onCreate()");
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.login);
		
		userNameEditText = (EditText)findViewById(R.id.username);
		passwordEditText = (EditText)findViewById(R.id.password);
		
		userNameEditText.setText(prefs.getUserName(getApplicationContext()));
		passwordEditText.setText(prefs.getPassword(getApplicationContext()));
		
		loginButton = (Button)findViewById(R.id.login);
		cancelButton = (Button)findViewById(R.id.cancel);
		
		signupRequired = (Button) findViewById(R.id.signup_required);
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d("SocialMe","Login Button Clicked");
				String userName = userNameEditText.getText().toString();
				String password = passwordEditText.getText().toString();
				
				try {
					acctMgr.login(getApplicationContext(), userName, password);
					finish();
				} catch (InvalidCredentialsException e) {
					Dialog dialog = new Dialog(LoginActivity.this);
					dialog.setTitle("Login Failed");
					dialog.setCancelable(true);
					dialog.show();
				} catch (NetworkException e) {
					Dialog dialog = new Dialog(LoginActivity.this);
					dialog.setTitle("Retry, Network Issues");
					dialog.setCancelable(true);
					dialog.show();
				}
				
				
				finish();
				
			}
		});
		
		cancelButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d("SocialMe","Cancel Button Clicked");
				userNameEditText.setText("");
				passwordEditText.setText("");
				finish();
			}
		});
		
		signupRequired.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent navIntent = new Intent(getApplicationContext(),SignUpActivity.class);
				startActivityForResult(navIntent,SIGNUP_CODE);
				
			}
		});
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(SIGNUP_CODE == requestCode){
			
			try {
				Log.d("LoginActivity","onActivityResult calling AccountManager.login() method");
				acctMgr.login(getApplicationContext(), prefs.getUserName(getApplicationContext()), prefs.getPassword(getApplicationContext()));
			} catch (InvalidCredentialsException e) {
				Dialog dialog = new Dialog(LoginActivity.this);
				dialog.setTitle("Login Failed");
				dialog.setCancelable(true);
				dialog.show();
			} catch (NetworkException e) {
				Dialog dialog = new Dialog(LoginActivity.this);
				dialog.setTitle("Retry, Network Issues");
				dialog.setCancelable(true);
				dialog.show();
			}
			finish();
		}
	}
	
	

}
