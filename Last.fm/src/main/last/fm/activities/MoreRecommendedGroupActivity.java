package main.last.fm.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import main.last.fm.R;
import main.last.fm.adapters.RecommendedGroupAdapter;
import main.last.fm.service.LastFmServiceHelper;
import main.last.fm.service.ServiceResultReceiver;

/**
 * Created by sofia on 21.05.14.
 */
public class MoreRecommendedGroupActivity extends ListActivity implements ServiceResultReceiver.Receiver{
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
        //setContentView(R.layout.activity_more_recommended_group);
        resultReceiver = new ServiceResultReceiver(new Handler());
        resultReceiver.setReceiver(this);
        lastFmServiceHelper = LastFmServiceHelper.getInstance();
        lastFmServiceHelper.getRecomendedMusic(this, 1, 8, ACTIVITY_ID, resultReceiver);

    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        setContentView(R.layout.activity_more_recommended_group);
        ListView check=(ListView)findViewById(android.R.id.list);
        String[] recomGroupsNames = resultData.getStringArray("title");
        String[] recomGroupImages = resultData.getStringArray("img");
        ArrayList<String[]> checkArr = new ArrayList<String[]>();
        checkArr.add(recomGroupsNames);
        checkArr.add(recomGroupImages);
        RecommendedGroupAdapter adapter = new RecommendedGroupAdapter(this, R.layout.activity_recommended_group_item, checkArr);
        check.setAdapter(adapter);
    }
}
