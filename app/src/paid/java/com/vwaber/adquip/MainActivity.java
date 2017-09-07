package com.vwaber.adquip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vwaber.quipstage.QuipParcelable;
import com.vwaber.quipstage.StageActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.TaskListener{

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mProgressBar = findViewById(R.id.pb_loading);
    }

    public void tellJoke(View view) {
        mProgressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onTaskFinished(QuipParcelable data) {

        mProgressBar.setVisibility(View.INVISIBLE);

        if(data == null){
            String message = getString(R.string.backend_error);
            Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }

        loadStageActivity(data);

    }

    private void loadStageActivity(QuipParcelable data){
        Bundle bundle = new Bundle();
        bundle.putParcelable(QuipParcelable.EXTRA_KEY, data);
        Intent intent = new Intent(this, StageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
