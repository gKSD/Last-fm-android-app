package main.last.fm.webservice;

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

/**
 * Created by phil on 25.04.14.
 */
public class RestExecutor {
    public RestExecutor() {

    }
    public static String REQUEST_URL = "https://ws.audioscrobbler.com/2.0/?method=";

    public String exec(String method, String urlParams, String PostParams) {
        String serverResponseMessage = new String();
        URL url = null;
        try {
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            String line = "";
            while ((line = reader.readLine()) != null) {
                serverResponseMessage = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return serverResponseMessage;
    }
}
