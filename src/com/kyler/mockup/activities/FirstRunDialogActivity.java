package com.kyler.mockup.activities;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.kyler.mockup.R;
import com.kyler.mockup.SimpleMockup;

public class FirstRunDialogActivity extends Activity {

	Button okayButton;

	@SuppressLint("InlinedApi")
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
				WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window w = getWindow();

			/*
			 * w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
			 * WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			 */

			w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

		}

		setContentView(R.layout.first_run_dialog);

		// requestWindowFeature(Window.FEATURE_NO_TITLE); <--- causes a force
		// close ;D

		getWindow().setLayout(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		getWindow().setGravity(Gravity.CENTER);

		Button okayButton = (Button) findViewById(R.id.okButton);

		okayButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent activityChangeIntent = new Intent(
						FirstRunDialogActivity.this, SimpleMockup.class);

				FirstRunDialogActivity.this.startActivity(activityChangeIntent);
				FirstRunDialogActivity.super.finish();
			}
		});
	}
}