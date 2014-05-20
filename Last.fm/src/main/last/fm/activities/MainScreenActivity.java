package main.last.fm.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
}
