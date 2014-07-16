package com.kyler.mockup.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;

import com.kyler.mockup.R;

public class TranslucentExample extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.translucent_example);
		
		getActionBar().setTitle(R.string.mockup_blank);

		getActionBar().setIcon(R.drawable.invisible);

		SpannableString s = new SpannableString("         ");
		s.setSpan(new TypefaceSpan("sans-serif-thin"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		getActionBar().setHomeButtonEnabled(true);		
	}

}
