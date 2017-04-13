package com.crowdpp.nagisa.crowdppui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

            default:
                break;
        }

    }
}
