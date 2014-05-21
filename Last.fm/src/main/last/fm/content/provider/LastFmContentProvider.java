package main.last.fm.content.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Path;
import android.net.Uri;
import android.util.Log;

/**
 * Created by sofia on 17.04.14.
 */
public class LastFmContentProvider extends ContentProvider {

    private static final String LOG_TAG = "LastFmContentProvider";

    private static UriMatcher sUriMatcher = buildUriMatcher();
    private LastFmDatabaseHelper databaseHelper;
    private SQLiteDatabase db;


    //Здесь мы храним id  для каждого отдельного uri
    public static final int USERS = 100;

    public LastFmContentProvider() {
    }

    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = LastFmMainData.CONTENT_AUTHORITY;

        matcher.addURI(authority, LastFmMainData.PATH_USERS, USERS);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        final Context context = getContext();
        databaseHelper = new LastFmDatabaseHelper(context);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.i(LOG_TAG, "&&& query,  selection = "+ selection);
        db = databaseHelper.getWritableDatabase();
        /*Cursor cursor = db.query(STUDENT_TABLE, projection, selection,selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), CONTACT_CONTENT_URI);
        return cursor;
        return null;*/
        switch (sUriMatcher.match(uri))
        {

            case USERS:
                Log.i(LOG_TAG, "33");
                return databaseHelper.getWritableDatabase().query(LastFmMainData.PATH_USERS, projection,selection, selectionArgs, null, null, sortOrder);
            default:

        }
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Long id;
        switch (sUriMatcher.match(uri))
        {
            // If the incoming URI was for all of table3
            case USERS:
                //id = databaseHelper.getWritableDatabase().insert(LastFmDatabaseHelper.STUDENT_TABLE, null, values);
                databaseHelper.insertUser(LastFmMainData.PATH_USERS, contentValues);
                break;
            default:
                // If the URI is not recognized, you should do some error handling here.
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        Long id;
        switch (sUriMatcher.match(uri))
        {
            // If the incoming URI was for all of table3
            case USERS:
                databaseHelper.getWritableDatabase().delete(LastFmMainData.PATH_USERS, null, null);
                break;
            default:
                // If the URI is not recognized, you should do some error handling here.
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
