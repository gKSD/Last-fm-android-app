package main.last.fm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by step on 17.04.14.
 */
public class LastFmServiceHelper extends Application {  //через это будем формировать intent
    boolean bound = false;
    String API_KEY = "544aa2e6717625cc3fd72da91fcfa7df";
    String API_SIG = "609a04e369e81ab1759e13f7c2a64559";
    Intent intent;
    private LastFmServiceHelper() {
     /*   intent = new Intent("main.last.fm.LastFmService");
        lfConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                bound = false;
            }
        };
        bindService(intent, lfConnection, BIND_AUTO_CREATE);*/

    }

    private static class SingletonHolder {  //используем вложенный класс для того, чтобы синглтон остался "ленивым" и потокобезопасным
        private static final LastFmServiceHelper INSTANCE = new LastFmServiceHelper();
    }
    public static LastFmServiceHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void authIntent(String login, String passwd, int ActivityNumber) {
        String strAuth = "password="+passwd+"&username="+ login+"&api_key ="+API_KEY+"&api_sig="+API_SIG;
        intent = new Intent(this, LastFmService.class);
        intent.putExtra("Auth",strAuth);
        intent.putExtra("id", ActivityNumber);
        startService(intent);
    }
}
