package com.kyler.mockup.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyler.mockup.R;

public class AboutFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.about_fragment, container, false);
		// setHasOptionsMenu(true);

		/*
		 * getActivity().getActionBar().setTitle(R.string.about);
		 * getActivity().getActionBar().setSubtitle("Just testing");
		 */

		return view;

	}
}
