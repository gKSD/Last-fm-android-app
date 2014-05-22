package main.last.fm.processor;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import main.last.fm.service.LastFmService;

/**
 * Created by phil on 25.04.14.
 */
public class LoginProcessor {
    private String uniName;
    private String sessionKey;
    private String errorMessage;
    private String userName;
   public LoginProcessor() {

   };


    public String getSessionKey() {
        return sessionKey;
    }
    public String getUserName() {
        return userName;
    }

    public String getUniName() {
        return uniName;
    }
    public int LoginProcess(String response) throws JSONException {
        JSONObject uniObject = null;
        JSONObject user = new JSONObject(response);
        Log.i("PROC",response);
        try {
            Log.i("PROC",response);
            uniObject = user.getJSONObject("session");
            if (uniObject != null) {
                uniName = new String(uniObject.getString("name"));
                sessionKey = new String(uniObject.getString("key"));
                return LastFmService.SERVICE_STATUS_OK;
            }
        } catch (JSONException e) {
            errorMessage = new String(user.getString("message"));
            //throw new RuntimeException(e);
            //String  = user.getJSONObject("error");
            return LastFmService.SERVICE_STATUS_ERROR;
        }
        return LastFmService.SERVICE_STATUS_ERROR;
    }

}