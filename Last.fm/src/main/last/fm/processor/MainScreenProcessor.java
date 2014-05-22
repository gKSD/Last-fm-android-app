package main.last.fm.processor;

import android.provider.MediaStore;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLDecoder;

/**
 * Created by phil on 22.05.14.
 */
public class MainScreenProcessor {
    private String LOG_TAG = "MainScrreenProcessor";

    public MainScreenProcessor() {

    }

    public void ProcessRecomendedArtists(String response,int Limit) throws JSONException {
        JSONObject recommendations = new JSONObject(response).getJSONObject("recommendations");
       // Log.i(LOG_TAG, recommendations.toString());
        JSONArray artists = recommendations.getJSONArray("artist");
      //  Log.i(LOG_TAG,artists.getJSONObject(1).get("name").toString());
        String[] artist = new String[Limit];
        String[] urls = new String[Limit];
        for (int i=0;i<Limit;i++){
           //String artist = artists.getJSONObject(1).getJSONObject("name").toString();
            artist[i] = artists.getJSONObject(i).get("name").toString();
            urls[i] = artists.getJSONObject(i).getJSONArray("image").getJSONObject(2).get("#text").toString();
        }
        Log.i(LOG_TAG,artist[1]);
        //  String s = "\\u0421\\u043b\\u043e\\u0442";
        // String s = new String("\\u0421\\u043b\\u043e\\u0442", "UTF-8")
    }
}
