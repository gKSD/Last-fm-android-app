package main.last.fm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import main.last.fm.R;

/**
 * Created by step on 17.04.14.
 */
public class MainScreenActivity extends BaseActivity {
    private static final String LOG_TAG = "MainScreenActivity";

    @Override
    public  void  onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, getIntent().getLongExtra("order_id", -1) + "");
        setContentView(R.layout.activity_main_screen);

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

            }
        });

        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.recomGroup2);
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.recomGroup3);
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.recomGroup4);
        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }*/
}
