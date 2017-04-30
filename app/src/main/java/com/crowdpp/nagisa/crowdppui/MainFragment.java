package com.crowdpp.nagisa.crowdppui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by nagisa on 4/4/17.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Activity Logger");

        Button mSettingBtn = (Button) rootView.findViewById(R.id.setting_btn);
        mSettingBtn.setOnClickListener(this);

        Button mHelpBtn = (Button) rootView.findViewById(R.id.help_btn);
        mHelpBtn.setOnClickListener(this);

        Button maaa = (Button) rootView.findViewById(R.id.aaa);
        maaa.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.setting_btn: {
                SettingFragment settingFragment = new SettingFragment();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, settingFragment)
                        .addToBackStack(null)
                        .commit();

                break;
            }

            case R.id.help_btn: {
                HelpFragment helpFragment = new HelpFragment();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, helpFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            }

            case R.id.aaa: {

                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
                // list
                String duration = sharedPref.getString("duration", "1");
                String selected = getResources().getStringArray(R.array.DurationArrays)[Integer.parseInt(duration)];

                // switch
                boolean b = sharedPref.getBoolean("upload", true);

                // dialog
                String period = sharedPref.getString("period", "9,21");
                Toast.makeText(getContext(), selected + (b ? " true" : " false") + period, Toast.LENGTH_LONG).show();
                break;
            }

            default:
                break;
        }

    }
}
