package main.last.fm.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    final String ATTRIBUTE_NAME_TEXT = "title";
    final String ATTRIBUTE_NAME_IMAGE = "image";
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
        ListView recGroupFullList=(ListView)findViewById(android.R.id.list);
        // массив данных
        String[] recomGroupsNames = resultData.getStringArray("title");
        Log.i(LOG_TAG, recomGroupsNames[2]);
        String[] recomGroupImages = resultData.getStringArray("img");

        ArrayList<Map<String, String>> summaryData = new ArrayList<Map<String, String>>(
                recomGroupsNames.length);

        Map<String, String> m;
        int img = 0;
        for (int i = 0; i < recomGroupsNames.length; i++) {
            m = new HashMap<String, String>();
            m.put(ATTRIBUTE_NAME_TEXT, recomGroupsNames[i]);
            summaryData.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = { ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE };
        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = { R.id.bandName, R.id.recomGroupItem };

        // создаем адаптер
        RecommendedGroupAdapter recGroupAdapter = new RecommendedGroupAdapter(this, summaryData, R.layout.activity_recommended_group_item, from, to);
        recGroupFullList.setAdapter(recGroupAdapter);
    }
}
