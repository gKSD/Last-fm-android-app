package main.last.fm.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import main.last.fm.R;
import main.last.fm.service.LastFmService;
import main.last.fm.service.LastFmServiceHelper;
import main.last.fm.service.ServiceResultReceiver;

/**
 * Created by step on 17.04.14.
 */
public class MainScreenActivity extends BaseActivity implements ServiceResultReceiver.Receiver{
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
    public  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, getIntent().getLongExtra("order_id", -1) + "");

        //((ImageView) findViewById(R.id.recomImg1)).setMaxWidth();
        //((ImageView) findViewById(R.id.recomImg2)).setMaxWidth();
        //((ImageView) findViewById(R.id.recomImg3)).setMaxWidth();
        //((ImageView) findViewById(R.id.recomImg4)).setMaxWidth();

        //((ImageView) findViewById(R.id.newRelImg1)).setMaxWidth();
        //((ImageView) findViewById(R.id.newRelImg2)).setMaxWidth();

        //((ImageView) findViewById(R.id.upComImg1)).setMaxWidth();

        setContentView(R.layout.activity_main_screen);

        resultReceiver = new ServiceResultReceiver(new Handler());
        resultReceiver.setReceiver(this);

        lastFmServiceHelper = LastFmServiceHelper.getInstance();

        Log.i(LOG_TAG, "123456");
        //lastFmServiceHelper.getRecomendedMusic(this, 1, itemAmount, ACTIVITY_ID, resultReceiver);
        lastFmServiceHelper.getRecomendedMusic(this, 1, itemAmount, ACTIVITY_ID, resultReceiver);
        //lastFmServiceHelper.getNewReleases(this, 1, itemAmount, 20, resultReceiver);

        final MainScreenActivity ptr = this;

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //УДАЛЮ ПОТОМ
        //Bundle resultData = new Bundle();
        //resultData.putInt("title", LastFmService.IS_MUSIC);
        //onReceiveResult(33, resultData);
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


        Button button1 = (Button) findViewById(R.id.moreButton);
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

        Button button2 = (Button) findViewById(R.id.moreButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                // TODO Auto-generated method stub
                Intent intent = new Intent(ptr, MoreNewReleasesActivity.class);
                startActivity(intent);
                finish();
                //TODO ЗАМЕНИТЬ НА ОСТАНОВКУ ГЛАВНОЙ СТРАНИЦЫ, А НЕ ВЫЗОВ FINISH() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            }
        });


        Button button3 = (Button) findViewById(R.id.moreButton3);
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

        FrameLayout frameLayout1 = (FrameLayout) findViewById(R.id.recomGroup1);
        frameLayout1.setOnClickListener(new View.OnClickListener() {
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

        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.recomGroup2);
        frameLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = (TextView) ptr.findViewById(R.id.recomName2);
                ptr.getLastFmServiceHelper().getConcreteMusic(ptr, textView.getText().toString(), ACTIVITY_ID, resultReceiver);

            }
        });

        FrameLayout frameLayout3 = (FrameLayout) findViewById(R.id.recomGroup3);
        frameLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = (TextView) ptr.findViewById(R.id.recomName3);
                ptr.getLastFmServiceHelper().getConcreteMusic(ptr, textView.getText().toString(), ACTIVITY_ID, resultReceiver);

            }
        });

        FrameLayout frameLayout4 = (FrameLayout) findViewById(R.id.recomGroup4);
        frameLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = (TextView) ptr.findViewById(R.id.recomName4);
                ptr.getLastFmServiceHelper().getConcreteMusic(ptr, textView.getText().toString(), ACTIVITY_ID, resultReceiver);

            }
        });

        //
        FrameLayout frameLayout5 = (FrameLayout) findViewById(R.id.newRel1);
        frameLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = (TextView) ptr.findViewById(R.id.newRelName1);
                ptr.getLastFmServiceHelper().getConcreteMusic(ptr, textView.getText().toString(), ACTIVITY_ID, resultReceiver);

            }
        });
        FrameLayout frameLayout6 = (FrameLayout) findViewById(R.id.newRel2);
        frameLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = (TextView) ptr.findViewById(R.id.newRelName2);
                ptr.getLastFmServiceHelper().getConcreteMusic(ptr, textView.getText().toString(), ACTIVITY_ID, resultReceiver);

            }
        });
    }


    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {

        Log.i(LOG_TAG, "QQQQQQQQQQQQ");

        /*
        Log.i(LOG_TAG, "44444444444444444444444444444444444444444444444444444444444444444");
        RelativeLayout relativeLayout1 = (RelativeLayout) findViewById(R.id.recomGroup1);
        //relativeLayout1.setBackground(Drawable.createFromPath("@drawable/ic_launcher.png"));
        Resources res = getResources(); //resource handle
        Drawable drawable = res.getDrawable(R.drawable.ic_launcher); //new Image that was added to the res folder
        relativeLayout1.setBackground(drawable);
        Log.i(LOG_TAG, "77777777777777777777777777777777777777777777777777777777777777777777");*/

        if (resultData.getInt("init") >= 0) //!!!!!!
        {
            Log.i(LOG_TAG, "TTTTTTT");
            int code = resultData.getInt("init");

            String[] titles = resultData.getStringArray("title");
            String[] img = resultData.getStringArray("img");

            Log.i(LOG_TAG, titles[0]);
            Log.i(LOG_TAG, titles[1]);
            Log.i(LOG_TAG, titles[3]);

            Log.i(LOG_TAG, img[0]);


            int n1 = titles.length;
            int n2 = img.length;
            int n = Math.min(n1, n2);

            Log.i(LOG_TAG, "99999999999999999");

            switch(code)
            {
                case LastFmService.IS_MUSIC:
                    /*for (int i = 0; i < n; i++)
                    {
                        RelativeLayout relativeLayout1 = (RelativeLayout) findViewById(R.id.recomGroup1);
                        Resources res = getResources(); //resource handle
                        Drawable drawable = res.getDrawable(R.drawable.ic_launcher); //new Image that was added to the res folder
                        relativeLayout1.setBackground(drawable);

                        TextView textView = (TextView) findViewById(R.id.recomName1);
                        textView.setText(titles[0]);
                    }*/
                    Log.i(LOG_TAG, "8888888888888888");

                    ImageView imageView1 = (ImageView) findViewById(R.id.recomImg1);
                    Picasso.with(this).load(img[0]).into(imageView1);

                    TextView textView = (TextView) findViewById(R.id.recomName1);
                    textView.setText(titles[0]);

                    ImageView imageView2 = (ImageView) findViewById(R.id.recomImg2);
                    Picasso.with(this).load(img[1]).into(imageView2);

                    TextView textView2 = (TextView) findViewById(R.id.recomName2);
                    textView2.setText(titles[1]);

                    ImageView imageView3 = (ImageView) findViewById(R.id.recomImg3);
                    Picasso.with(this).load(img[2]).into(imageView3);

                    TextView textView3 = (TextView) findViewById(R.id.recomName3);
                    textView3.setText(titles[2]);

                    ImageView imageView4 = (ImageView) findViewById(R.id.recomImg4);
                    Picasso.with(this).load(img[3]).into(imageView4);

                    TextView textView4 = (TextView) findViewById(R.id.recomName4);
                    textView4.setText(titles[3]);

                    break;
                case LastFmService.IS_UPCOMING_EVENT:
                    break;
                case LastFmService.IS_RELEASE:
                    break;
                default:
                    break;
            }
        }

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }*/
}
