package com.kyler.mockup.adapter;

import com.kyler.mockup.fragments.Test1;
import com.kyler.mockup.fragments.Test2;
import com.kyler.mockup.fragments.Test3;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MockupAdapter extends FragmentPagerAdapter {

	final int PAGE_COUNT = 3;
	// Tab Titles
	private String tabtitles[] = new String[] { "Test 1", "Test 2", "Test 3" };
	Context context;

	public MockupAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

		case 0:
			Test1 test1 = new Test1();
			return test1;

		case 1:
			Test2 test2 = new Test2();
			return test2;

		case 2:
			Test3 test3 = new Test3();
			return test3;

		}
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabtitles[position];
	}
}