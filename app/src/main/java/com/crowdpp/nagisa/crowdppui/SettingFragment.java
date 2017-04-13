package com.crowdpp.nagisa.crowdppui;


import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import android.preference.PreferenceFragment;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.zip.Inflater;

/**
 * Created by nagisa on 4/4/17.
 */

public class SettingFragment extends PreferenceFragmentCompat {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingFragment()).commit();
//    }
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        // Load the Preferences from the XML file
        addPreferencesFromResource(R.xml.preferences);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Setting");

//            FragmentManager fm = getFragmentManager();
//            Log.d("click", Integer.toString(fm.getBackStackEntryCount()));

        Toolbar toolbar = ((MainActivity) getActivity()).toolbar;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
            }
        });
    }

//        @Override
//        public void onCreate(final Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            addPreferencesFromResource(R.xml.preferences);
//            ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            ((MainActivity)getActivity()).getSupportActionBar().setTitle("Setting");
//
////            FragmentManager fm = getFragmentManager();
////            Log.d("click", Integer.toString(fm.getBackStackEntryCount()));
//
//            Toolbar toolbar = ((MainActivity) getActivity()).toolbar;
//            toolbar.setNavigationOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View view) {
//                    FragmentManager fm = getFragmentManager();
//                    fm.popBackStack();
//                }
//            });
//
//        }

    @Override
    public void onDisplayPreferenceDialog(Preference preference) {

        // Try if the preference is one of our custom Preferences
        DialogFragment dialogFragment = null;
        if (preference instanceof TimePreference) {
            // Create a new instance of TimePreferenceDialogFragment with the key of the related
            // Preference
            dialogFragment = TimePreferenceDialogFragmentCompat.newInstance(preference.getKey());
        }


        if (dialogFragment != null) {
            // The dialog was created (it was one of our custom Preferences), show the dialog for it
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(this.getFragmentManager(), "android.support.v7.preference" +
                    ".PreferenceFragment.DIALOG");
        } else {
            // Dialog creation could not be handled here. Try with the super method.
            super.onDisplayPreferenceDialog(preference);
        }

    }

}
