package main.last.fm.service;

import android.content.Context;
import android.content.Intent;

/**
 * Created by step on 17.04.14.
 */
public class LastFmServiceHelper{

    //для формирования intenta

    boolean bound = false;
    String API_KEY = "544aa2e6717625cc3fd72da91fcfa7df";
    String API_SIG = "609a04e369e81ab1759e13f7c2a64559";


    private LastFmServiceHelper() {

    }

    private static class SingletonHolder {  //используем вложенный класс для того, чтобы синглтон остался "ленивым" и потокобезопасным
        private static final LastFmServiceHelper INSTANCE = new LastFmServiceHelper();
    }
    public static LastFmServiceHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void authIntent(Context context, String login, String passwd, int ActivityNumber)
    {
        String strAuth = "password="+passwd+"&username="+ login+"&api_key ="+API_KEY+"&api_sig="+API_SIG;

        final Intent intent = new Intent(context, LastFmService.class);
        intent.putExtra("Auth",strAuth);
        intent.putExtra("id", ActivityNumber);

        context.startService(intent);
    }
}
