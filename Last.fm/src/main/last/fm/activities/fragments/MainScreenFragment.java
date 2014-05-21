package main.last.fm.activities.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import main.last.fm.R;

/**
 * Created by sofia on 20.05.14.
 */
public class MainScreenFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.activity_login, container);
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.hide();
        return view;
    }
}
