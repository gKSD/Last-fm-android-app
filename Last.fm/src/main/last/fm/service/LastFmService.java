package main.last.fm.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
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

/**
 * Created by step on 17.04.14.
 */
public class LastFmService extends IntentService {
    private static final String LOG_TAG = "LastFmService";
    String REQUEST_URL = "https://ws.audioscrobbler.com/2.0/?method=";
    String API_K = "544aa2e6717625cc3fd72da91fcfa7df";


    public LastFmService () {
        super("LastFmService");
    }

    public void onCreate() {
        super.onCreate();
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        int ID = intent.getIntExtra("id",0);
        String method = null;
        String urlParams = "";
        String PostParams="";
        boolean isPost;
      //  method = new String("auth.getMobileSession");
        switch (ID)
        {
            case 0:
                method = new String("auth.getmobilesession");
                PostParams = intent.getStringExtra("PostAuth");
                isPost = true;
            default:

        }
        URL url = null;
        try {
           // url = new URL(REQUEST_URL+method+"&"+urlParams+"&format=json");
            url = new URL(REQUEST_URL+method +urlParams +"&format=json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setInstanceFollowRedirects(false);

        try {
            connection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        connection.setFixedLengthStreamingMode(
                PostParams.getBytes().length);
        PrintWriter out = null;
        try {
            out = new PrintWriter(connection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print(PostParams);
        out.close();
        DataOutputStream wr = null;
        try {
            wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParams);
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream response = null;
        try {
            response = connection.getInputStream();
            int bytesRead = -1;
            ByteArrayBuffer lastFmResponse = new ByteArrayBuffer(50);
            /*  Более медленная, но зато в строку (Можно использовать StringBuilder, будет быстрее)
            */
            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            String line = "";
            String serverResponseMessage = new String();
            while ((line = reader.readLine()) != null) {
                serverResponseMessage = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.disconnect();
    }

}
