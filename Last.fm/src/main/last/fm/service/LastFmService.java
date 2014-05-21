package main.last.fm.service;

import android.app.IntentService;
import android.app.Service;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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
import java.security.Provider;

import main.last.fm.content.provider.LastFmMainData;
import main.last.fm.processor.LoginProcessor;
import main.last.fm.webservice.RestExecutor;

/**
 * Created by step on 17.04.14.
 */
public class LastFmService extends IntentService {
    private static final String LOG_TAG = "LastFmService";
    String REQUEST_URL = "https://ws.audioscrobbler.com/2.0/?method=";
    String API_K = "544aa2e6717625cc3fd72da91fcfa7df";
    public ServiceProcessor sp = new ServiceProcessor();


    public LastFmService () {
        super("LastFmService");

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        int ID = intent.getIntExtra("id",0);
        String urlParams = "";
        String PostParams="";

        boolean isPost = false;
      //  method = new String("auth.getMobileSession");
        switch (ID)
        {
            case 0:
                PostParams = intent.getStringExtra("PostAuth");
                sp.ProcessLogin(PostParams);
        }
      //  Log.i(LOG_TAG,response);
        switch(ID) {
            case 0:
        /*        LoginProcessor processor = new LoginProcessor(response);
                if (processor.getSessionKey() != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(LastFmMainData.UsersColumns.LOGIN, processor.getUniName());
                    contentValues.put(LastFmMainData.UsersColumns.PASSWORD, "password");
                    contentValues.put(LastFmMainData.UsersColumns.MOBILE_SESSION, processor.getSessionKey());
                    getContentResolver().insert(Uri.parse("content://" + LastFmMainData.CONTENT_AUTHORITY + "/" + LastFmMainData.PATH_USERS), contentValues);
                }*/
        }
        //LoginProcessor processor = new LoginProcessor(response);
    }
}





