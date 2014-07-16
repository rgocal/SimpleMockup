package com.kyler.mockup.activities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kyler.mockup.R;

public class RequestByEmail extends Activity {

	private EditText recipient;
	private EditText subject;
	private EditText body;

	@SuppressLint("InflateParams")
	@TargetApi(Build.VERSION_CODES.KITKAT)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		getActionBar().setHomeButtonEnabled(true);

		setContentView(R.layout.request);

		getActionBar().setIcon(R.drawable.invisible);

		SpannableString s = new SpannableString("Request");
		s.setSpan(new TypefaceSpan("sans-serif-thin"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		// Update the action bar title with the TypefaceSpan instance
		ActionBar actionBar = getActionBar();
		actionBar.setTitle(s);

		recipient = (EditText) findViewById(R.id.recipient);
		subject = (EditText) findViewById(R.id.subject);
		body = (EditText) findViewById(R.id.body);

		Button sendBtn = (Button) findViewById(R.id.sendEmail);
		sendBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				sendEmail();
				// after sending the email, clear the fields
				recipient.setText("MBQSniper@hotmail.com");
				subject.setText("Feature Request");
				body.setText("");
			}
		});
	}

	protected void sendEmail() {

		String[] recipients = { recipient.getText().toString() };
		Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
		// prompts email clients only
		email.setType("message/rfc822");

		email.putExtra(Intent.EXTRA_EMAIL, recipients);
		email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
		email.putExtra(Intent.EXTRA_TEXT, body.getText().toString());

		try {
			// the user can choose the email client
			startActivity(Intent.createChooser(email,
					"Please choose an Email Client"));

		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(this, "No email client installed.",
					Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();

		inflater.inflate(R.menu.request_menu, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.extraInformation:
			// A Dialog may go here in the future

			break;

		case android.R.id.home:
			super.onBackPressed();
			overridePendingTransition(R.anim.activity_open_enter,
					R.anim.activity_open_exit);
			break;

		default:

		}
		;

		return super.onOptionsItemSelected(item);
	}

}
