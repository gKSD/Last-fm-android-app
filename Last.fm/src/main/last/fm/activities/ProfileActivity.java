package main.last.fm.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import main.last.fm.R;

/**
 * Created by sofia on 20.05.14.
 */
public class ProfileActivity extends BaseActivity {

    private static final String LOG_TAG = "ProfileActivity";

    @Override
    public  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
}
