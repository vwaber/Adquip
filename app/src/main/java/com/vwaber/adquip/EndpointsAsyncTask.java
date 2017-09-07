package com.vwaber.adquip;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.vwaber.adquip.backend.quipService.QuipService;
import com.vwaber.adquip.backend.quipService.model.QuipData;
import com.vwaber.quipstage.QuipParcelable;

import java.io.IOException;


class EndpointsAsyncTask extends AsyncTask<Void, Void, QuipParcelable> {

    private static final String ROOT_URL = "http://10.0.2.2:8080/_ah/api/";

    private static QuipService mService = null;

    private final TaskListener taskListener;

    interface TaskListener {
        void onTaskFinished(QuipParcelable data);
    }

    EndpointsAsyncTask(TaskListener listener){
        taskListener = listener;
    }


    @Override
    protected QuipParcelable doInBackground(Void... voids) {

        if (mService == null) {

            QuipService.Builder builder =
                    new QuipService.Builder(
                            AndroidHttp.newCompatibleTransport(),
                            new AndroidJsonFactory(),
                            null
                    ).setRootUrl(ROOT_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request)
                                throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            mService = builder.build();
        }

        try {
            QuipData response = mService.getQuip().execute();
            return new QuipParcelable(response);
        } catch (IOException e) {
            return null;
        }

    }

    @Override
    protected void onPostExecute(QuipParcelable result){
        super.onPostExecute(result);
        if(taskListener!=null) taskListener.onTaskFinished(result);
    }
}
