package main.last.fm.activities;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import main.last.fm.content.provider.LastFmMainData;
import main.last.fm.service.LastFmService;
import main.last.fm.service.LastFmServiceHelper;
import main.last.fm.R;
import main.last.fm.service.ServiceResultReceiver;

public class LoginActivity extends Activity implements ServiceResultReceiver.Receiver{

    private static final String LOG_TAG = "LoginActivity";

    private LastFmServiceHelper lastFmServiceHelper;
    private final int ACTIVITY_ID = 0;

    private ProgressDialog progressDialog;

    private ServiceResultReceiver resultReceiver;

    public final LastFmServiceHelper getLastFmServiceHelper() {
        return lastFmServiceHelper;
    }

    public final int getActivityId()
    {
        return ACTIVITY_ID;
    }

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

        if (cursor.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            int loginColIndex = cursor.getColumnIndex(LastFmMainData.UsersColumns.LOGIN);
            int pswdColIndex = cursor.getColumnIndex(LastFmMainData.UsersColumns.PASSWORD);
            int mbSessionColIndex = cursor.getColumnIndex(LastFmMainData.UsersColumns.MOBILE_SESSION);

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(LOG_TAG, "login = " + cursor.getInt(loginColIndex) + ", password = " + cursor.getString(pswdColIndex) + ", mobile session = " + cursor.getString(mbSessionColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (cursor.moveToNext());
        } else
            Log.d(LOG_TAG, "0 rows");
        cursor.close();
        //******************************************************************************************************************************************************************************

        lastFmServiceHelper = LastFmServiceHelper.getInstance();
        final LoginActivity ptr = this;

        Button comeInBtn = (Button)findViewById(R.id.button);

        comeInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "111111111111111111111111111111111111111111111111111111111111111");
                EditText loginEdt = (EditText) ptr.findViewById(R.id.editText1);
                EditText passwdEdt = (EditText) ptr.findViewById(R.id.editText2);
                String login = loginEdt.getText().toString();
                String passwd = passwdEdt.getText().toString();
                ptr.getLastFmServiceHelper().authIntent(ptr, login, passwd, ACTIVITY_ID, resultReceiver);
            }
        });

        resultReceiver = new ServiceResultReceiver(new Handler());
        resultReceiver.setReceiver(this);

        ActionBar actionBar = getActionBar();
        actionBar.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.login, menu);
        //return true;
        Log.d(LOG_TAG, "onCreateOptionsMenu() ia called");
        return false;
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {

        resultCode = LastFmService.SERVICE_STATUS_OK;

        switch (resultCode)
        {
            case LastFmService.SERVICE_STATUS_OK:
                //progressDialog.dismiss();
                Intent intent = new Intent(this, MainScreenActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                break;
            case LastFmService.SERVICE_STATUS_ERROR:
                break;
            case LastFmService.SERVICE_STATUS_PROCESSING:
                //progressDialog = ProgressDialog.show(this,"", getString(R.string.progress_login_message), true);
                break;
        }

    }
}
