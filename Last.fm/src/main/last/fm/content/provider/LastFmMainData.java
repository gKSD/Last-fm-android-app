package main.last.fm.content.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by sofia on 25.04.14.
 */
public class LastFmMainData {

    private static final String LOG_TAG = "LastFmMainData";

    public interface UsersColumns {
        String USER_ID = "_id";
        String LOGIN = "login";
        String PASSWORD = "password";
        String MOBILE_SESSION = "mobile_session";
    }


    public static final String CONTENT_AUTHORITY = "main.last.fm.content.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_USERS = "users"; // оно же название таблицы


    public static class Users implements UsersColumns{
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_USERS).build();

        public static Uri buildUsersUri(String userId) {
            return CONTENT_URI.buildUpon().appendPath(userId).build();
        }

        //public static String getUserId(Uri uri) {
        //    return uri.getPathSegments().get(1);
        //}
    }
}
