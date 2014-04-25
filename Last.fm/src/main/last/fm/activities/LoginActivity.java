package main.last.fm.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import main.last.fm.content.provider.LastFmDatabaseHelper;
import main.last.fm.content.provider.LastFmMainData;
import main.last.fm.service.LastFmServiceHelper;
import main.last.fm.R;

public class LoginActivity extends Activity {

    private static final String LOG_TAG = "LoginActivity";

    private LastFmServiceHelper lfServiceHelper;
    private int ACTIVITY_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //******************************************************************************************************************************************************************************
        //пример запроса в бд
        // ПОКА НЕ УДАЛЯТЬ
        String[] projection = {LastFmMainData.UsersColumns.LOGIN, LastFmMainData.UsersColumns.PASSWORD, LastFmMainData.UsersColumns.MOBILE_SESSION};
        //String selection  = MainDatabaseHelper."";
        Cursor cursor = getContentResolver().query(Uri.parse("content://" + LastFmMainData.CONTENT_AUTHORITY + "/" + LastFmMainData.PATH_USERS), projection, null, null, null);
        if (cursor != null) Log.i(LOG_TAG, " get cursor -- Ok " + cursor.toString());
        else Log.i(LOG_TAG, "get cursor FAILED!");

        //пример инсерта
        // ПОКА НЕ УДАЛЯТЬ
        ContentValues contentValues = new ContentValues();
        contentValues.put(LastFmMainData.UsersColumns.LOGIN, "Sofia");
        contentValues.put(LastFmMainData.UsersColumns.PASSWORD, "password");
        contentValues.put(LastFmMainData.UsersColumns.MOBILE_SESSION, "qwertyujikolp");
        getContentResolver().insert(Uri.parse("content://" + LastFmMainData.CONTENT_AUTHORITY + "/" + LastFmMainData.PATH_USERS), contentValues);

        String selection  = "login = ?";
        String[] selectionArgs = {"Sofia"};
        cursor = getContentResolver().query(Uri.parse("content://" + LastFmMainData.CONTENT_AUTHORITY + "/" + LastFmMainData.PATH_USERS), projection, selection, selectionArgs, null);
        if (cursor != null) Log.i(LOG_TAG, " get cursor -- Ok "+ cursor.getColumnCount());
        else Log.i(LOG_TAG, "get cursor FAILED! " );
        //******************************************************************************************************************************************************************************

        final LoginActivity ptr = this;

        Button comeInBtn = (Button)findViewById(R.id.button);
        lfServiceHelper = LastFmServiceHelper.getInstance();
        comeInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText loginEdt = (EditText) findViewById(R.id.editText1);
                EditText passwdEdt = (EditText) findViewById(R.id.editText2);
                String login = loginEdt.getText().toString();
                String passwd = passwdEdt.getText().toString();
                lfServiceHelper.authIntent(ptr, login, passwd, ACTIVITY_ID);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
}
