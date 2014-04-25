package main.last.fm.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import org.apache.http.util.ByteArrayBuffer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import main.last.fm.webservice.RestExecutor;

/**
 * Created by step on 17.04.14.
 */
public class LastFmService extends IntentService {
    private static final String LOG_TAG = "LastFmService";
    RestExecutor executor;
    String REQUEST_URL = "https://ws.audioscrobbler.com/2.0/?method=";
    String API_K = "544aa2e6717625cc3fd72da91fcfa7df";


    public LastFmService () {
        super("LastFmService");

    }

    @Override
    public void onCreate() {
        super.onCreate();
        executor = new RestExecutor();
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        int ID = intent.getIntExtra("id",0);
        String method = null;
        String urlParams = "";
        String PostParams="";
        boolean isPost = false;
      //  method = new String("auth.getMobileSession");
        switch (ID)
        {
            case 0:
                method = new String("auth.getmobilesession");
                PostParams = intent.getStringExtra("PostAuth");
                isPost = true;
        }
        String response = executor.exec(method, urlParams, PostParams);

    }
}





