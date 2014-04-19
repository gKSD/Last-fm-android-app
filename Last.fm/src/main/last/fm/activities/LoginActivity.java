package main.last.fm.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import main.last.fm.LastFmServiceHelper;
import main.last.fm.R;

public class LoginActivity extends Activity {
    private LastFmServiceHelper lfServiceHelper;
    private int ACTIVITY_ID = 0;

    //****
    public static String PACKAGE_NAME;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = getApplicationContext();
        if (context==null) Log.i("TTTT", "tttt");
        //*****

        PACKAGE_NAME = getApplicationContext().getPackageName();
        Log.i("asdadsa ", PACKAGE_NAME);


        Button comeInBtn = (Button)findViewById(R.id.button);
        lfServiceHelper = LastFmServiceHelper.getInstance();
        comeInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText loginEdt = (EditText) findViewById(R.id.editText1);
                EditText passwdEdt = (EditText) findViewById(R.id.editText2);
                String login = loginEdt.getText().toString();
                String passwd = passwdEdt.getText().toString();
                lfServiceHelper.authIntent(login, passwd, ACTIVITY_ID);
            }
        });
        Log.i("asdasd", "adasd");
        //this.
        Log.i("aaaaaa", "bbbbbb");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
}
