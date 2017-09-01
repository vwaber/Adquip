package com.vwaber.quipstage;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        FragmentManager fragmentManager = getSupportFragmentManager();
        StageFragment stageFragment = (StageFragment) fragmentManager.findFragmentById(R.id.fragment_container);

        if(stageFragment == null) {

            stageFragment = new StageFragment();

            Bundle extras = getIntent().getExtras();
            stageFragment.setArguments(extras);

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, stageFragment)
                    .commit();
        }


    }
}
