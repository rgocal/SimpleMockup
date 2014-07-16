package com.kyler.mockup.activities;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuItem;

import com.kyler.mockup.R;

public class About extends Activity {

	@TargetApi(Build.VERSION_CODES.KITKAT)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActionBar actionBar = getActionBar();

		getActionBar().setIcon(R.drawable.invisible);

		SpannableString s = new SpannableString("");
		s.setSpan(new TypefaceSpan("sans-serif-thin"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		actionBar.setTitle(s);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		getActionBar().setHomeButtonEnabled(true);

		setContentView(R.layout.about);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			super.onBackPressed();
			break;

		default:

		}
		;

		return super.onOptionsItemSelected(item);
	}
}
