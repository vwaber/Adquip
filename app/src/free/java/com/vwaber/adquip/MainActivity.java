package com.vwaber.adquip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.vwaber.quipstage.QuipParcelable;
import com.vwaber.quipstage.StageActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.TaskListener{

    private InterstitialAd mInterstitialAd;
    private QuipParcelable mQuipParcelable;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mProgressBar = findViewById(R.id.pb_loading);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                if(mQuipParcelable != null) loadStageActivity(mQuipParcelable);
            }
        });

    }

    public void tellJoke(View view) {
        mProgressBar.setVisibility(View.VISIBLE);
        if(mInterstitialAd.isLoaded()) mInterstitialAd.show();
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onTaskFinished(QuipParcelable data) {

        mProgressBar.setVisibility(View.INVISIBLE);
        mQuipParcelable = data;

        if(data == null){
            String message = getString(R.string.backend_error);
            Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }

    private void loadStageActivity(QuipParcelable data){
        Bundle bundle = new Bundle();
        bundle.putParcelable(QuipParcelable.EXTRA_KEY, data);
        Intent intent = new Intent(this, StageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
