package main.last.fm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;

import main.last.fm.R;
import main.last.fm.service.LastFmServiceHelper;
import main.last.fm.service.ServiceResultReceiver;

/**
 * Created by sofia on 20.05.14.
 */
public class ConcreteMusicActivity extends main.last.fm.activities.BaseActivity implements ServiceResultReceiver.Receiver {

    private static final String LOG_TAG = "ConcreteMusicActivity";

    private LastFmServiceHelper lastFmServiceHelper;
    private final int ACTIVITY_ID = 3;

    private ServiceResultReceiver resultReceiver;

    private String title  = new String();

    @Override
    public  void  onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        lastFmServiceHelper = LastFmServiceHelper.getInstance();

        resultReceiver = new ServiceResultReceiver(new Handler());
        resultReceiver.setReceiver(this);

        Intent intent = getIntent();
        this.title = intent.getStringExtra("title");

        Log.i(LOG_TAG, intent.getStringExtra("title"));

        lastFmServiceHelper.getConcreteMusic(this, title, ACTIVITY_ID, resultReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {

    }

    public String getMusicTitle()
    {
        return  this.title;
    }
}
