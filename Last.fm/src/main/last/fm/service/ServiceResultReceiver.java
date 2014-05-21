package main.last.fm.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by sofia on 21.05.14.
 */

public class ServiceResultReceiver extends ResultReceiver {

    private Receiver receiver;

    public ServiceResultReceiver(Handler handler) {
        super(handler);

    }

    public interface Receiver {
        public void onReceiveResult(int resultCode, Bundle resultData);

    }

    public void setReceiver(Receiver receiver) {
        receiver = receiver;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {

        if (receiver != null) {
            receiver.onReceiveResult(resultCode, resultData);
        }
    }

}
