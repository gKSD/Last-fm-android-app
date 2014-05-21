package main.last.fm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import main.last.fm.R;
import main.last.fm.service.LastFmServiceHelper;
import main.last.fm.service.ServiceResultReceiver;

/**
 * Created by step on 17.04.14.
 */
public class MainScreenActivity extends BaseActivity  implements ServiceResultReceiver.Receiver{
    private static final String LOG_TAG = "MainScreenActivity";

    private LastFmServiceHelper lastFmServiceHelper;
    private final int ACTIVITY_ID = 1;

    private ServiceResultReceiver resultReceiver;

    private int itemAmount = 8;

    public final LastFmServiceHelper getLastFmServiceHelper() {
        return lastFmServiceHelper;
    }
    public final int getActivityId()
    {
        return ACTIVITY_ID;
    }

    @Override
    public  void  onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, getIntent().getLongExtra("order_id", -1) + "");
        setContentView(R.layout.activity_main_screen);

        resultReceiver = new ServiceResultReceiver(new Handler());
        resultReceiver.setReceiver(this);

        lastFmServiceHelper = LastFmServiceHelper.getInstance();

        Log.i(LOG_TAG, "123456");
        lastFmServiceHelper.getRecomendedMusic(this, 1, itemAmount, ACTIVITY_ID, resultReceiver);

        final MainScreenActivity ptr = this;

        Button button1 = (Button)findViewById(R.id.moreButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(ptr, MoreRecommendedGroupActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                //TODO ЗАМЕНИТЬ НА ОСТАНОВКУ ГЛАВНОЙ СТРАНИЦЫ, А НЕ ВЫЗОВ FINISH() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
        });

        Button button2 = (Button)findViewById(R.id.moreButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                // TODO Auto-generated method stub
                //startActivity(new Intent(MainActivity.this, ActivityOk.class));
                Intent intent = new Intent(ptr, MoreNewReleasesActivity.class);
                startActivity(intent);
                finish();
                //TODO ЗАМЕНИТЬ НА ОСТАНОВКУ ГЛАВНОЙ СТРАНИЦЫ, А НЕ ВЫЗОВ FINISH() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            }
        });


        Button button3 = (Button)findViewById(R.id.moreButton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ptr, MoreUpcomingEventsActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                //TODO ЗАМЕНИТЬ НА ОСТАНОВКУ ГЛАВНОЙ СТРАНИЦЫ, А НЕ ВЫЗОВ FINISH() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
        });

        RelativeLayout relativeLayout1 = (RelativeLayout) findViewById(R.id.recomGroup1);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ptr, ConcreteMusicActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("title", ((TextView) ptr.findViewById(R.id.recomName1)).getText().toString());
                startActivity(intent);
                finish();
                //ptr.getLastFmServiceHelper().getConcreteMusic(ptr, textView.getText().toString(), ACTIVITY_ID, resultReceiver);
            }
        });

        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.recomGroup2);
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = (TextView) ptr.findViewById(R.id.recomName2);
                ptr.getLastFmServiceHelper().getConcreteMusic(ptr, textView.getText().toString(), ACTIVITY_ID, resultReceiver);

            }
        });

        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.recomGroup3);
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = (TextView) ptr.findViewById(R.id.recomName3);
                ptr.getLastFmServiceHelper().getConcreteMusic(ptr, textView.getText().toString(), ACTIVITY_ID, resultReceiver);

            }
        });

        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.recomGroup4);
        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = (TextView) ptr.findViewById(R.id.recomName4);
                ptr.getLastFmServiceHelper().getConcreteMusic(ptr, textView.getText().toString(), ACTIVITY_ID, resultReceiver);

            }
        });
    }


    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }*/
}
