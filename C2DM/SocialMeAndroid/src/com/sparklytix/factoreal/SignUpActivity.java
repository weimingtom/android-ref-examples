/**
 * 
 */
package com.sparklytix.factoreal;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.sparklytix.factoreal.mgr.AccountManager;
import com.sparklytix.factoreal.mgr.AccountPreferences;
import com.sparklytix.factoreal.mgr.NetworkException;
import com.sparklytix.factoreal.mgr.UserAlreadyExists;

/**
 * @author rohit
 *
 */
public class SignUpActivity extends Activity {

	
	
	private EditText firstNameEditText = null;
	private EditText lastNameEditText = null;
	private EditText userNameEditText = null;
	private EditText passwordEditText = null;
	private Button signupButton = null;
	private Button cancelButton = null;
	
	private AccountPreferences prefs = new AccountPreferences();
	private AccountManager acctMgr = new AccountManager(prefs);
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("SocialMe","LoginActivity.onCreate()");
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.signup);
		
		firstNameEditText = (EditText)findViewById(R.id.firstName);
		lastNameEditText = (EditText)findViewById(R.id.lastName);
		userNameEditText = (EditText)findViewById(R.id.username);
		passwordEditText = (EditText)findViewById(R.id.password);
		
		firstNameEditText.setText(prefs.getFirstName(getApplicationContext()));
		lastNameEditText.setText(prefs.getLastName(getApplicationContext()));
		userNameEditText.setText(prefs.getUserName(getApplicationContext()));
		passwordEditText.setText(prefs.getPassword(getApplicationContext()));
		
		signupButton = (Button)findViewById(R.id.signup);
		cancelButton = (Button)findViewById(R.id.cancel);
		
		signupButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d("SocialMe","Sign Up Button Clicked");
				String firstName = firstNameEditText.getText().toString();
				String lastName = lastNameEditText.getText().toString();
				String userName = userNameEditText.getText().toString();
				String password = passwordEditText.getText().toString();
				try {
					acctMgr.signUp(getApplicationContext(), firstName, lastName, userName, password);
					finish();
				} catch (UserAlreadyExists e) {
					Dialog dialog = new Dialog(SignUpActivity.this);
					dialog.setTitle("User already exists");
					dialog.setCancelable(true);
					dialog.show();
				} catch (NetworkException e) {
					Dialog dialog = new Dialog(SignUpActivity.this);
					dialog.setTitle("Retry, there is network issues");
					dialog.setCancelable(true);
					dialog.show();
				}
				
				
				
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
	}

}
