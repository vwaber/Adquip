package com.vwaber.adquip;

import android.support.test.runner.AndroidJUnit4;

import com.vwaber.quipstage.QuipParcelable;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class BackendTest implements EndpointsAsyncTask.TaskListener {

    @Test
    public void testResponse() {
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onTaskFinished(QuipParcelable data) {
        assertNotNull(data);
        assertNotNull(data.getSetup());
        assertNotNull(data.getPunchline());
    }
}
