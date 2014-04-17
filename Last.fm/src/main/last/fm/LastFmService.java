package main.last.fm;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by step on 17.04.14.
 */
public class LastFmService extends IntentService {

    public LastFmService(){
        super("LastFmService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
