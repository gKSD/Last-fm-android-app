package main.last.fm.activities.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import main.last.fm.R;
import main.last.fm.activities.MainScreenActivity;
import main.last.fm.activities.MoreNewReleasesActivity;
import main.last.fm.activities.MoreRecommendedGroupActivity;
import main.last.fm.activities.MoreUpcomingEventsActivity;
import main.last.fm.service.ServiceResultReceiver;

/**
 * Created by sofia on 20.05.14.
 */
public class MainScreenFragment extends Fragment  implements ServiceResultReceiver.Receiver{

    private static final String LOG_TAG = "MainScreenFragment";

    private ServiceResultReceiver resultReceiver;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        resultReceiver = new ServiceResultReceiver(new Handler());
        resultReceiver.setReceiver(this);


        Button button1 = (Button)getActivity().findViewById(R.id.moreButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getActivity(), MoreRecommendedGroupActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                getActivity().finish();
                //TODO ЗАМЕНИТЬ НА ОСТАНОВКУ ГЛАВНОЙ СТРАНИЦЫ, А НЕ ВЫЗОВ FINISH() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
        });

        Button button2 = (Button)getActivity().findViewById(R.id.moreButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                // TODO Auto-generated method stub
                //startActivity(new Intent(MainActivity.this, ActivityOk.class));
                Intent intent = new Intent(getActivity(), MoreNewReleasesActivity.class);
                startActivity(intent);
                getActivity().finish();
                //TODO ЗАМЕНИТЬ НА ОСТАНОВКУ ГЛАВНОЙ СТРАНИЦЫ, А НЕ ВЫЗОВ FINISH() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            }
        });


        Button button3 = (Button)getActivity().findViewById(R.id.moreButton3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), MoreUpcomingEventsActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                getActivity().finish();
                //TODO ЗАМЕНИТЬ НА ОСТАНОВКУ ГЛАВНОЙ СТРАНИЦЫ, А НЕ ВЫЗОВ FINISH() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
        });

        RelativeLayout relativeLayout1 = (RelativeLayout) getActivity().findViewById(R.id.recomGroup1);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RelativeLayout relativeLayout2 = (RelativeLayout) getActivity().findViewById(R.id.recomGroup2);
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RelativeLayout relativeLayout3 = (RelativeLayout) getActivity().findViewById(R.id.recomGroup3);
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RelativeLayout relativeLayout4 = (RelativeLayout) getActivity().findViewById(R.id.recomGroup4);
        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_main_screen, null);
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.hide();
        return view;
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {

    }
}
