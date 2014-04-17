package main.last.fm;

import android.app.Application;

/**
 * Created by step on 17.04.14.
 */
public class LastFmServiceHelper extends Application {
    private LastFmServiceHelper() {
    };

    private static class SingletonHolder {  //используем вложенный класс для того, чтобы синглтон остался "ленивым" и потокобезопасным
        private static final LastFmServiceHelper INSTANCE = new LastFmServiceHelper();
    }
    public static LastFmServiceHelper getInstance() {

        return SingletonHolder.INSTANCE;
    }

    public boolean getAuthParams(String login, String passwd) {

    }
}
