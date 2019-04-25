package com.wifi.server.receiver;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wifi.server.R;
import com.wifi.server.base.BaseFragment;
import com.wifi.server.dialogs.AnimationView;
import com.wifi.server.utils.Utils;


public class ReceiverFragment extends BaseFragment {

    private View connectView, hotspotView;
    private AnimationView connectGif, hotspotGif;
    private TextView connectTxtView, hotspotTxtView;

    public static ReceiverFragment newInstance() {
        ReceiverFragment fragment = new ReceiverFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_receiver, container, false);

        connectView = rootView.findViewById(R.id.scan_progress);
        connectGif = rootView.findViewById(R.id.gif1);
        connectTxtView = rootView.findViewById(R.id.progress_txt);

        hotspotView = rootView.findViewById(R.id.scan_hotspot);
        hotspotGif = rootView.findViewById(R.id.gif2);
        hotspotTxtView = rootView.findViewById(R.id.progress_hotspot_txt);

        return rootView;
    }

    public void onServerConnectFailed() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Utils.showMessage(activity, activity.getString(R.string.receiver_error_in_connecting));
                connectView.setVisibility(View.VISIBLE);
                connectTxtView.setText(getString(R.string.receiver_init));
            }
        });
    }


}