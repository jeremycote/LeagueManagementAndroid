package com.manager.admin.leaguemanagementandroid;

import android.content.Intent;
import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetPlayers extends AsyncTask {
    public static final String EXTRA_MESSAGE = "com.example.LeagueManagementAndroid.MESSAGE";

    @Override
    protected Object doInBackground(Object[] objects) {
        URL WebServer = null;
        try {
            WebServer = new URL("http://192.168.1.14:8080");
            HttpURLConnection myConnection = (HttpURLConnection) WebServer.openConnection();
            if (myConnection.getResponseCode() == 200) {
                InputStream responseBody = myConnection.getInputStream();
                String connectionPrint = IOUtils.toString(responseBody, "UTF-8");

                //InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                //JsonReader jsonReader = new JsonReader(responseBodyReader);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Intent intent = new Intent(MainActivity.this, MessageDisplay.class);
        intent.putExtra(EXTRA_MESSAGE, "Failed To Connect");
        startActivity(intent);
    }
}
