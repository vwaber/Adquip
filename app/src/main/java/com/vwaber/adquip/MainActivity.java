package com.vwaber.adquip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.vwaber.quipstage.QuipParcelable;
import com.vwaber.quipstage.StageActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.TaskListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void tellJoke(View view) {
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onTaskFinished(QuipParcelable data) {

        if(data == null){
            String message = getString(R.string.backend_error);
            Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putParcelable(QuipParcelable.EXTRA_KEY, data);
        Intent intent = new Intent(this, StageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
