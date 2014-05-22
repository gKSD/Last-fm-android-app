package main.last.fm.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import main.last.fm.activities.LoginActivity;

/**
 * Created by step on 17.04.14.
 */
public class LastFmServiceHelper{

    private static final String LOG_TAG = "LastFmServiceHelper";



    //для формирования intenta

    boolean bound = false;
    String API_KEY = new String("544aa2e6717625cc3fd72da91fcfa7df");
    String API_SIG = "609a04e369e81ab1759e13f7c2a64559";
    String SECRET_K = "609a04e369e81ab1759e13f7c2a64559";
    //String API_SIG;

    private LastFmServiceHelper() {

    }

    private static class SingletonHolder {
        //используем вложенный класс для того, чтобы синглтон остался "ленивым" и потокобезопасным
        private static final LastFmServiceHelper INSTANCE = new LastFmServiceHelper();
    }
    public static LastFmServiceHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void authIntent(Context context, String login, String passwd, int ActivityNumber, ServiceResultReceiver receiver)
    {

        String method = "auth.getmobilesession";
        String params = "method" + method + "password" + passwd + "username" + login;
        API_SIG = generateApiSig(params);
        String strAuth = "password="+passwd+"&username="+ login+"&api_key="+API_KEY+"&api_sig="+API_SIG;
        final Intent intent = new Intent(context, LastFmService.class);

        intent.putExtra("Auth",strAuth);
        intent.putExtra("PostAuth",strAuth);
        intent.putExtra("id", ActivityNumber);
        intent.putExtra (LastFmService.INTENT_SERVICE_EXTRA_STATUS_RECEIVER, receiver);

        context.startService(intent);
    }

    public void getRecomendedMusic(Context context, int page, int limit, int ActivityNumber, ServiceResultReceiver receiver) {
        String method = "user.getRecommendedArtists";
        String params = "limit" + limit + "method" + method + "page" + page + "sk" + LoginActivity.SESSION_KEY;
        API_SIG = generateApiSig(params);
        String url = "&limit=" + limit + "&page=" + page + "&sk=" + LoginActivity.SESSION_KEY+"&api_key="+API_KEY+"&api_sig="+API_SIG;;
        final Intent intent = new Intent(context, LastFmService.class);
        intent.putExtra("getParams",url);
        intent.putExtra("id", ActivityNumber);
        intent.putExtra("limit", limit);
        intent.putExtra (LastFmService.INTENT_SERVICE_EXTRA_STATUS_RECEIVER, receiver);

        context.startService(intent);
    }

    public void  getNewReleases(Context context, int page, int limit, int ActivityNumber, ServiceResultReceiver receiver)
    {

    }

    public void getConcreteMusic(Context context, String title, int ActivityNumber, ServiceResultReceiver receiver)
    {

    }

    public void getConcreteRelease(Context context, String title, int ActivityNumber, ServiceResultReceiver receiver)
    {

    }

    public String generateApiSig(String methods) {

        Log.i("MD5","api_key" + this.API_KEY + methods + SECRET_K);

        return md5SumMaker.digest("api_key" + this.API_KEY + methods + SECRET_K, "MD5");
    }

}
