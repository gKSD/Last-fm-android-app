package main.last.fm.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.ResultReceiver;

/**
 * Created by step on 17.04.14.
 */
public class LastFmService extends IntentService {

    private static final String LOG_TAG = "LastFmService";
    String REQUEST_URL = "https://ws.audioscrobbler.com/2.0/?method=";
    String API_K = "544aa2e6717625cc3fd72da91fcfa7df";
    public ServiceProcessor serviceProcessor = new ServiceProcessor();

    public static final int SERVICE_STATUS_OK = 0;
    public static final int SERVICE_STATUS_ERROR = 1;
    public static final int SERVICE_STATUS_PROCESSING = 2;

    public static final String INTENT_SERVICE_EXTRA_STATUS_RECEIVER = "main.last.fm.RESULT_RECEIVER";

    public LastFmService () {
        super("LastFmService");

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        int ID = intent.getIntExtra("id",0);
        ResultReceiver receiver =  intent.getParcelableExtra(INTENT_SERVICE_EXTRA_STATUS_RECEIVER);
        String urlParams = "";
        String PostParams="";

        boolean isPost = false;
      //  method = new String("auth.getMobileSession");
        switch (ID)
        {
            case 0:
                PostParams = intent.getStringExtra("PostAuth");
                serviceProcessor.ProcessLogin(PostParams);
        }
        //LoginProcessor processor = new LoginProcessor(response);


    }
}





