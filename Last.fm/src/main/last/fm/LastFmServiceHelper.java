package main.last.fm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import main.last.fm.activities.LoginActivity;

/**
 * Created by step on 17.04.14.
 */
public class LastFmServiceHelper extends Application {  //через это будем формировать intent
    boolean bound = false;
    String API_KEY = "544aa2e6717625cc3fd72da91fcfa7df";
    String API_SIG = "609a04e369e81ab1759e13f7c2a64559";
    Intent intent;
    Context context = LoginActivity.context;

    private LastFmServiceHelper() {

    }

    private static class SingletonHolder {  //используем вложенный класс для того, чтобы синглтон остался "ленивым" и потокобезопасным
        private static final LastFmServiceHelper INSTANCE = new LastFmServiceHelper();
    }
    public static LastFmServiceHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void authIntent(String login, String passwd, int ActivityNumber) {
        String strAuth = "password="+passwd+"&username="+ login+"&api_key ="+API_KEY+"&api_sig="+API_SIG;

        intent = new Intent(context, LastFmService.class);
        intent.putExtra("Auth",strAuth);
        intent.putExtra("id", ActivityNumber);
        startService(intent);
    }
}
