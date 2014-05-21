package main.last.fm.activities.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import main.last.fm.R;
import main.last.fm.activities.LoginActivity;
import main.last.fm.service.LastFmServiceHelper;

/**
 * Created by sofia on 21.05.14.
 */
public class LoginFragment extends Fragment {

    private static final String LOG_TAG = "LoginFragment";

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
        View view = inflater.inflate(R.layout.fragment_login, container);
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.hide();
        return view;
    }
}
