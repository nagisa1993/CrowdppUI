package com.crowdpp.nagisa.crowdppui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nagisa on 5/1/17.
 */

public class LogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    ArrayList<Sms> smsList;
    ArrayList<Call> callList;

    public LogAdapter(Context mContext, ArrayList<Sms> smsList, ArrayList<Call> callList) {
        this.mContext = mContext;
        this.smsList = smsList;
        this.callList = callList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case 0: return new smsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.log_sms, null));
            case 2: return new callViewHolder(LayoutInflater.from(mContext).inflate(R.layout.log_call, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        switch (holder.getItemViewType()) {
            case 0:
                smsViewHolder sms = (smsViewHolder) holder;
                ((smsViewHolder) holder).smsName.setText(smsList.get(i).userName);
                ((smsViewHolder) holder).smsBody.setText(smsList.get(i).userMobile);
                ((smsViewHolder) holder).smsDate.setText(smsList.get(i).userEmail);
                break;

            case 2:
                callViewHolder call = (callViewHolder) holder;
                ((callViewHolder) holder).callName.setText(callList.get(i).userName);
                ((callViewHolder) holder).callDuration.setText(callList.get(i).userMobile);
                ((callViewHolder) holder).callDate.setText(callList.get(i).userEmail);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2 * 2;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class smsViewHolder extends RecyclerView.ViewHolder {
        private TextView smsName;
        private TextView smsBody;
        private TextView smsDate;

        public smsViewHolder(View itemView) {
            super(itemView);
            smsName = (TextView) itemView.findViewById(R.id.smsName);
            smsBody = (TextView) itemView.findViewById(R.id.smsBody);
            smsDate = (TextView) itemView.findViewById(R.id.smsDate);
        }
    }

    public static class callViewHolder extends RecyclerView.ViewHolder {
        private TextView callName;
        private TextView callDuration;
        private TextView callDate;

        public callViewHolder(View itemView) {
            super(itemView);
            callName = (TextView) itemView.findViewById(R.id.callName);
            callDuration = (TextView) itemView.findViewById(R.id.callDuration);
            callDate = (TextView) itemView.findViewById(R.id.callDate);
        }
    }
}
