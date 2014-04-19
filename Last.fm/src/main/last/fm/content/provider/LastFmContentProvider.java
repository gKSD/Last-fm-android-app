package main.last.fm.content.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by sofia on 17.04.14.
 */
public class LastFmContentProvider extends ContentProvider {

    //private MainDatabaseHelper databaseHelper;
    private static UriMatcher sUriMatcher;
    public static final String AUTHORITY = "main.last.fm.content.provider";


    private LastFmDatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    LastFmContentProvider()
    {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        //sUriMatcher.addURI(AUTHORITY, "student", 1);
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new LastFmDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2) {
        db = databaseHelper.getWritableDatabase();
        /*Cursor cursor = db.query(STUDENT_TABLE, projection, selection,selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), CONTACT_CONTENT_URI);
        return cursor;
        return null;*/
        switch (sUriMatcher.match(uri))
        {
            // If the incoming URI was for all of table3
            case 1:
                //id = databaseHelper.getWritableDatabase().insert(LastFmDatabaseHelper.STUDENT_TABLE, null, values);
                break;
            case 2:
                //id = databaseHelper.getWritableDatabase().insert(LastFmDatabaseHelper.STUDENT_LIST_TABLE, null, values);
                break;

            default:
                // If the URI is not recognized, you should do some error handling here.
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
            case 1:
                //id = databaseHelper.getWritableDatabase().insert(LastFmDatabaseHelper.STUDENT_TABLE, null, values);
                break;
            case 2:
                //id = databaseHelper.getWritableDatabase().insert(LastFmDatabaseHelper.STUDENT_LIST_TABLE, null, values);
                break;

            default:
                // If the URI is not recognized, you should do some error handling here.
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
