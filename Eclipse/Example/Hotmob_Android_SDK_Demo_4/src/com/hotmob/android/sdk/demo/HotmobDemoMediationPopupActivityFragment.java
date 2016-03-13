package com.hotmob.android.sdk.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.hotmob.sdk.manager.HotmobManager;

/**
 * A placeholder fragment containing a simple view.
 */
public class HotmobDemoMediationPopupActivityFragment extends Fragment {

    private BroadcastReceiver mBroadcastReceiver;

    public HotmobDemoMediationPopupActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotmob_demo_mediation_popup, container, false);

        Button mImagePopupButton = (Button) view.findViewById(R.id.hotmob_popup_mediation_normal_button);
        mImagePopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup("/13648685/hotmob_android_example_image_popup");
            }
        });


        Button mVideoAdsPopupButton = (Button) view.findViewById(R.id.hotmob_popup_mediation_videoads_button);
        mVideoAdsPopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup("/13648685/hotmob_android_example_videoads_popup");
            }
        });

        createLocalBroadcastReceiver();

        return view;
    }

    private void showPopup(String adCode) {
        final PublisherInterstitialAd mPublisherInterstitialAd = new PublisherInterstitialAd(HotmobDemoMediationPopupActivityFragment.this.getActivity());
        mPublisherInterstitialAd.setAdUnitId(adCode);
        mPublisherInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
            }

            @Override
            public void onAdLoaded() {
                mPublisherInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
            }
        });

        HotmobManager.setCurrentActivity(HotmobDemoMediationPopupActivityFragment.this.getActivity());
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherInterstitialAd.loadAd(adRequest);
    }

    private void destroyLocalBroadcastManager() {
        LocalBroadcastManager.getInstance(this.getActivity().getApplicationContext()).unregisterReceiver(mBroadcastReceiver);
        mBroadcastReceiver = null;
    }

    private void createLocalBroadcastReceiver() {
        IntentFilter filter = new IntentFilter(HotmobManager.HotmobVideoPlayerMuteNotification);
        filter.addAction(HotmobManager.HotmobVideoPlayerUnmuteNotification);

        if (mBroadcastReceiver == null) {
            mBroadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    String actionName = intent.getAction();
                    if (actionName.equals(HotmobManager.HotmobVideoPlayerMuteNotification)) {
                        Toast.makeText(context, "Popup Mediation: Mute!", Toast.LENGTH_SHORT).show();
                    } else if (actionName.equals(HotmobManager.HotmobVideoPlayerUnmuteNotification)) {
                        Toast.makeText(context, "Popup Mediation: Unmute!", Toast.LENGTH_SHORT).show();
                    }
                }
            };
        }

        LocalBroadcastManager.getInstance(this.getActivity().getApplicationContext()).registerReceiver(mBroadcastReceiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        destroyLocalBroadcastManager();
    }
}
