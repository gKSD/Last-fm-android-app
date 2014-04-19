package main.last.fm.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import org.apache.http.util.ByteArrayBuffer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    String REQUEST_URL = "http://ws.audioscrobbler.com/2.0/?method=";
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
        switch (ID)
        {
            case 1:
                urlParams = intent.getStringExtra("Auth");
                method = "auth.getMobileSession";

        }
        URL url = null;
        Log.i("AUTH","AUTH");
        try {
            url = new URL(REQUEST_URL+method+"&api_key="+API_K+"&format=json");
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
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParams.getBytes().length));
        connection.setUseCaches (false);
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
            byte[] buffer = new byte[1024];
            while ((bytesRead = response.read(buffer)) >= 0) {
                lastFmResponse.append(buffer, 0, bytesRead);
            }
            Log.i("AUTH", buffer.toString());
            /*  Более медленная, но зато в строку (Можно использовать StringBuilder, будет быстрее)
            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            String line = "";
            while ((line = reader.readLine()) != null) {
                serverResponseMessage += line;
            }  */
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.disconnect();
    }

}
