/**
 * 
 */
package org.android.examples.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author rohit
 *
 */
public class SecondActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		final EditText myeditText = (EditText)findViewById(R.id.myedittext);
		final Button submitButton = (Button)findViewById(R.id.mysubmit);
		submitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String returnValue = myeditText.getText().toString();
				Intent values = new Intent();
				values.putExtra("returnValue", returnValue);
				setResult(RESULT_OK, values);
				finish();
			}
		});
		
	}

	
}
