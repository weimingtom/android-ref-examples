package org.android.examples.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HelloWorldActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final TextView myTextView = (TextView) findViewById(R.id.mytextview);
		final Button mybutton = (Button) findViewById(R.id.mybutton);

		mybutton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				myTextView.setText(R.string.bye);

			}
		});
		final Button navigate = (Button) findViewById(R.id.navigate);
		navigate.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent navIntent = new Intent(getApplicationContext(),
						SecondActivity.class);
				startActivityForResult(navIntent, 100);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onActivityResult(int, int,
	 * android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 100 && resultCode == RESULT_OK) {
			String returnValue = data.getExtras().getString("returnValue");
			Toast.makeText(getApplicationContext(),
					"ReturnValue=" + returnValue, Toast.LENGTH_LONG).show();

		}
	}

}