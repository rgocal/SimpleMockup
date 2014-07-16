package com.kyler.mockup;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.kyler.mockup.activities.About;
import com.kyler.mockup.activities.FirstRunDialogActivity;
import com.kyler.mockup.activities.RequestByEmail;
import com.kyler.mockup.activities.TranslucentExample;
import com.kyler.mockup.adapter.MockupAdapter;
import com.kyler.mockup.fragments.DrawerFragment1;
import com.kyler.mockup.fragments.DrawerFragment2;
import com.kyler.mockup.fragments.DrawerFragment3;
import com.kyler.mockup.fragments.DrawerFragment4;

public class SimpleMockup extends FragmentActivity {
	private DrawerLayout mDrawerLayout;

	private ListView mDrawerList;

	private ActionBarDrawerToggle mDrawerToggle;

	@SuppressWarnings("unused")
	private CharSequence mDrawerTitle;

	private CharSequence mTitle;

	private String[] mCategories;

	Fragment item1 = new DrawerFragment1();
	Fragment gh = new DrawerFragment2();
	Fragment item3 = new DrawerFragment3();
	Fragment item4 = new DrawerFragment4();

	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		SharedPreferences first = PreferenceManager
				.getDefaultSharedPreferences(this);

		if (getIntent().getBooleanExtra("EXIT", false)) {
			finish();
		}

		if (!first.getBoolean("firstTime", false)) {

			Intent intent = new Intent(this, FirstRunDialogActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			finish();

			SharedPreferences.Editor editor = first.edit();

			editor.putBoolean("firstTime", true);
			editor.commit();

		}

		ActionBar actionBar = getActionBar();

		getActionBar().setTitle(R.string.mockup_blank);

		getActionBar().setIcon(R.drawable.ic_drawer);

		SpannableString s = new SpannableString("");
		s.setSpan(new TypefaceSpan("sans-serif-thin"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		actionBar.setTitle(s);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		getActionBar().setHomeButtonEnabled(true);

		ImageView view = (ImageView) findViewById(android.R.id.home);
		view.setPadding(50, 0, 0, 0);

		setContentView(R.layout.activity_main);

		mTitle = mDrawerTitle = getTitle();

		mCategories = getResources().getStringArray(
				R.array.navigation_main_sections);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mCategories));

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		LayoutInflater inflater = getLayoutInflater();
		final ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header,
				mDrawerList, false);
		mDrawerList.addHeaderView(header, null, false); // See below if you want
														// to make the Header
														// clickable...

		/*
		 * mDrawerList.addHeaderView(header, null, true); ^^^ This makes the
		 * Header clickable. It will be position 0 in your case break on line
		 * 186 (already commented with // Header)
		 */

		final ViewGroup footer = (ViewGroup) inflater.inflate(R.layout.footer,
				mDrawerList, false);
		mDrawerList.addFooterView(footer, null, true);

		mDrawerToggle = new ActionBarDrawerToggle(

		this, mDrawerLayout, R.drawable.invisible, R.string.drawer_open,
				R.string.drawer_close)

		{
			public void onDrawerClosed(View view) {

				getActionBar().setTitle(R.string.mockup_blank);
				getActionBar().setIcon(R.drawable.ic_drawer);

				invalidateOptionsMenu();

			}

			public void onDrawerOpened(View drawerView) {

				getActionBar().setTitle(R.string.mockup_blank);
				getActionBar().setIcon(R.drawable.ic_drawer);

				invalidateOptionsMenu();

			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {

			selectItem(0);
		}

		// mDrawerLayout.openDrawer(mDrawerList);

		ViewPager viewPager = (ViewPager) findViewById(R.id.welcome);

		viewPager.setAdapter(new MockupAdapter(getSupportFragmentManager()));
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		/*
		 * MenuInflater inflater = getMenuInflater();
		 * 
		 * inflater.inflate(R.menu.mockup_example_menu, menu);
		 */

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (mDrawerToggle.onOptionsItemSelected(item)) {

			return true;
		}
		switch (item.getItemId()) {

		default:

		}
		;

		return super.onOptionsItemSelected(item);
	}

	private void selectItem(int position) {

		FragmentTransaction ft = getFragmentManager().beginTransaction();
		switch (position) {

		case 0:
			// Header

			break;

		case 1:
			Intent request = new Intent(this, RequestByEmail.class);

			/*
			 * We would use Intent.FLAG_ACTIVITY_NO_ANIMATION if you wanted an
			 * extremely smooth transition, or for whatever various reason you
			 * May have.
			 * 
			 * request.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			 */

			startActivity(request);
			overridePendingTransition(R.anim.activity_open_enter,
					R.anim.activity_open_exit);
			break;

		case 2:
			Intent translucent = new Intent(this, TranslucentExample.class);
			startActivity(translucent);
			overridePendingTransition(R.anim.activity_open_enter,
					R.anim.activity_open_exit);
			break;

		case 3:
			ft.replace(R.id.content_frame, item3);
			break;

		case 4:
			ft.replace(R.id.content_frame, item4);
			break;

		case 5:
			// Footer

			Intent footer = new Intent(this, About.class);
			startActivity(footer);
			overridePendingTransition(R.anim.activity_open_enter,
					R.anim.activity_open_exit);
			break;

		}

		ft.commit();

		mDrawerList.setItemChecked(position, true);

		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {

		super.onPostCreate(savedInstanceState);

		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);

		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	public static class CategoriesFragment extends Fragment {

		public static final String ARG_CATEGORY = "category";

		public CategoriesFragment() {

		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.fragment_categories,
					container, false);

			int i = getArguments().getInt(ARG_CATEGORY);

			String List = getResources().getStringArray(
					R.array.navigation_main_sections)[i];

			getActivity().setTitle(List);

			return rootView;

		}
	}
}
