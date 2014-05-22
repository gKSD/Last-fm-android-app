package main.last.fm.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by sofia on 20.05.14.
 */
public abstract class BaseActivity extends Activity{

    private static final String LOG_TAG = "BaseActivity";


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(LOG_TAG, "onOptionsItemSelected(), item = " + item.getItemId());
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        return super.onCreateOptionsMenu(menu);

    }

    public void goHome() {
        //if (this instanceof RecentOrdersActivity) {
        //    return;
        //}

        //final Intent intent = new Intent(this, RecentOrdersActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //this.startActivity(intent);

    }
}
