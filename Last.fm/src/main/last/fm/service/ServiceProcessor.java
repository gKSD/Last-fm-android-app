package main.last.fm.service;

import main.last.fm.webservice.RestExecutor;

/**
 * Created by phil on 21.05.14.
 */
public class ServiceProcessor {
    RestExecutor executor;
    ServiceProcessor() {
        executor = new RestExecutor();
    }

    boolean ProcessLogin(String PostParams) {
        String method = new String("auth.getmobilesession");
        String response = new String(executor.exec(method, " ", PostParams));
        return true;
    }
}
