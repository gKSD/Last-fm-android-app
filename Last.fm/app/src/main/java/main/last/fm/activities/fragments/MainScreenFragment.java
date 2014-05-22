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
public class MainScreenFragment extends Fragment{

    private static final String LOG_TAG = "MainScreenFragment";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
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
}
