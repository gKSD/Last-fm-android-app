package main.last.fm.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by step on 17.04.14.
 */
public class LastFmServiceHelper{

    //для формирования intenta

    boolean bound = false;
    String API_KEY = "544aa2e6717625cc3fd72da91fcfa7df";
    String API_SIG = "609a04e369e81ab1759e13f7c2a64559";
    //String API_SIG;

    private LastFmServiceHelper() {

    }

    private static class SingletonHolder {  //используем вложенный класс для того, чтобы синглтон остался "ленивым" и потокобезопасным
        private static final LastFmServiceHelper INSTANCE = new LastFmServiceHelper();
    }
    public static LastFmServiceHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void authIntent(Context context, String login, String passwd, int ActivityNumber)
    {
        API_SIG = generateApiSig("auth.getMobileSession", login, passwd);
        String strAuth = "password="+passwd+"&username="+ login+"&api_key="+API_KEY+"&api_sig="+API_SIG;
        Log.i("AUTH", login);
        Log.i("AUTH", strAuth);
        final Intent intent = new Intent(context, LastFmService.class);
        intent.putExtra("Auth",strAuth);
        intent.putExtra("id", ActivityNumber);

        context.startService(intent);
    }

    public String generateApiSig(String method, String psw, String username) {
        return md5("api_key" + this.API_KEY + "method" + method + "password" + psw + "username" + username);
    }
    private static String md5(String s) { try {

        // Create MD5 Hash
        MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
        digest.update(s.getBytes());
        byte messageDigest[] = digest.digest();

        // Create Hex String
        StringBuffer hexString = new StringBuffer();
        for (int i=0; i<messageDigest.length; i++)
            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
        return hexString.toString();

    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
        return "";

    }
}
