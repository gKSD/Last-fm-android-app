package main.last.fm.service;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.content.Intent;
import android.util.Log;

import org.json.JSONException;

import main.last.fm.content.provider.LastFmMainData;
import main.last.fm.processor.LoginProcessor;
import main.last.fm.webservice.RestExecutor;

/**
 * Created by phil on 21.05.14.
 */
public class ServiceProcessor {
    String LOG_TAG = "ServiceProcessor";
    RestExecutor executor;
    ServiceProcessor() {
        executor = new RestExecutor();
    }

   int ProcessLogin(Context context, String PostParams) throws JSONException {
        String method = new String("auth.getmobilesession");
        String response = new String(executor.exec(method, "", PostParams));
        Log.i(LOG_TAG, response);
        LoginProcessor processor = new LoginProcessor();
        int status = processor.LoginProcess(response);
                if (processor.getSessionKey() != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(LastFmMainData.UsersColumns.LOGIN, processor.getUniName());
                    contentValues.put(LastFmMainData.UsersColumns.PASSWORD, "password");
                    contentValues.put(LastFmMainData.UsersColumns.MOBILE_SESSION, processor.getSessionKey());
                    context.getContentResolver().insert(Uri.parse("content://" + LastFmMainData.CONTENT_AUTHORITY + "/" + LastFmMainData.PATH_USERS), contentValues);
                }
        Log.i(LOG_TAG, response);
        return status;
    }
}

