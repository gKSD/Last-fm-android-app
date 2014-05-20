package main.last.fm.processor;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by phil on 25.04.14.
 */
public class LoginProcessor {
    public LoginProcessor(String response) {
        JSONObject uniObject = null;
        JSONObject user = null;
        try {
            user = new JSONObject(response);
            uniObject = user.getJSONObject("session");
            String uniName = new String(uniObject.getString("name"));
            String session = new String(uniObject.getString("session"));
            Log.i("PROC",uniName);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}