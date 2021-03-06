package com.crowdpp.nagisa.crowdppui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagisa on 4/30/17.
 */

public class LogFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private List<Object> mCallSMSList;
    private LogAdapter mCallSMSAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View logView = inflater.inflate(R.layout.log_fragment, container, false);
        mRecyclerView = (RecyclerView) logView.findViewById(R.id.smsCallLog);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        feed();
        return logView;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Log");

        Toolbar toolbar = ((MainActivity) getActivity()).toolbar;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
            }
        });
    }

    public void feed() {
        mCallSMSAdapter = new LogAdapter(getContext());
        mRecyclerView.setAdapter(mCallSMSAdapter);
        mCallSMSList = new ArrayList<>();

        mCallSMSList.add(new Call("John", "9:30 AM", "2"));
        mCallSMSList.add(new Call("Rob", "9:40 AM", "2"));
        mCallSMSList.add(new Sms("Sandy", "Hey, what's up?", "9:42 AM"));
        mCallSMSList.add(new Call("Peter", "9:45 AM", "2"));
        mCallSMSList.add(new Sms("John", "Are you writing blog?", "9:48 AM"));
        mCallSMSList.add(new Call("Jack", "9:50 AM", "2"));
        mCallSMSList.add(new Call("Bob", "9:55 AM", "2"));
        mCallSMSList.add(new Sms("Kora", "Thanks dude", "9:57 AM"));
        mCallSMSList.add(new Call("Sandy", "10:00 AM", "2"));
        mCallSMSList.add(new Call("Kate", "10:05 AM", "2"));
        mCallSMSList.add(new Sms("Nick", "Let's hang up", "10:10 AM"));
        mCallSMSList.add(new Call("Roger", "10:15 AM", "2"));
        mCallSMSList.add(new Call("Sid", "10:20 AM", "2"));
        mCallSMSList.add(new Call("Kora", "10:25 AM", "2"));
        mCallSMSList.add(new Call("Nick", "10:30 AM", "2"));
        mCallSMSList.add(new Sms("Rose", "Bring me some chocolates", "1035:10 AM"));
        mCallSMSList.add(new Call("Mia", "10:40 AM", "2"));
        mCallSMSList.add(new Call("Scott", "10:45 AM", "2"));
        // Set items to adapter
        mCallSMSAdapter.setCallSMSFeed(mCallSMSList);
        mCallSMSAdapter.notifyDataSetChanged();
    }
}
