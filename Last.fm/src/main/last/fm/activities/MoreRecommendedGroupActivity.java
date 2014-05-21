package main.last.fm.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import main.last.fm.R;
import main.last.fm.service.LastFmService;
import main.last.fm.service.LastFmServiceHelper;
import main.last.fm.service.ServiceResultReceiver;

/**
 * Created by sofia on 21.05.14.
 */
public class MoreRecommendedGroupActivity extends Activity implements ServiceResultReceiver.Receiver{
    //ListActivity
    private static final String LOG_TAG = "MoreRecommendedMusicActivity";
    private final int ACTIVITY_ID = 2;
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

        Log.d(LOG_TAG, getIntent().getLongExtra("order_id", -1) + "");
        setContentView(R.layout.activity_more_recommended_group);
        resultReceiver = new ServiceResultReceiver(new Handler());
        resultReceiver.setReceiver(this);
        lastFmServiceHelper = LastFmServiceHelper.getInstance();
        lastFmServiceHelper.getRecomendedMusic(this, ACTIVITY_ID, resultReceiver);

    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {

    }
}
