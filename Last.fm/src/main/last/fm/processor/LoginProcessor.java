package main.last.fm.processor;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by phil on 25.04.14.
 */
public class LoginProcessor {
    private String uniName;
    private String sessionKey;
    public String getSessionKey() {
        return sessionKey;
    }

    public String getUniName() {
        return uniName;
    }
    public LoginProcessor(String response) {
        JSONObject uniObject = null;
        JSONObject user;
        Log.i("PROC",response);
        try {
            user = new JSONObject(response);
            Log.i("PROC",response);
            uniObject = user.getJSONObject("session");
            uniName = new String(uniObject.getString("name"));
            sessionKey = new String(uniObject.getString("key"));
            Log.i("PROC",uniName);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}