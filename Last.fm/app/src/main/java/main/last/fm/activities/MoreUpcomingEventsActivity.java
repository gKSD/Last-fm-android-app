package main.last.fm.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import main.last.fm.service.LastFmServiceHelper;
import main.last.fm.service.ServiceResultReceiver;

/**
 * Created by sofia on 21.05.14.
 */
public class MoreUpcomingEventsActivity extends Activity implements ServiceResultReceiver.Receiver {
    //ListACtivity

    private static final String LOG_TAG = "MoreUpcomingEventsActivity";
    private final int ACTIVITY_ID = 4;
    private ServiceResultReceiver resultReceiver;
    private LastFmServiceHelper lastFmServiceHelper;

    public final int getActivityId()
    {
        return ACTIVITY_ID;
    }

    @Override
    public  void  onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        resultReceiver = new ServiceResultReceiver(new Handler());
        resultReceiver.setReceiver(this);
        lastFmServiceHelper = LastFmServiceHelper.getInstance();
        lastFmServiceHelper.getRecomendedMusic(this, 1, 8, ACTIVITY_ID, resultReceiver);

    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {

    }
}
