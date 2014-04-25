package main.last.fm.content.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sofia on 17.04.14.
 */
public class LastFmDatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = "LastFmDatabaseHelper";

    private static final String DATABASE_NAME = "last_fm.db";
    private static final int DATABASE_VERSION = 1;

    private Integer version;

    private static final String SQL_CREATE_USERS= "CREATE TABLE " + LastFmMainData.PATH_USERS + " (" +
            LastFmMainData.UsersColumns.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LastFmMainData.UsersColumns.LOGIN + " VARCHAR(200),"+
            LastFmMainData.UsersColumns.PASSWORD + " VARCHAR(100),"+
            LastFmMainData.UsersColumns.MOBILE_SESSION + " VARCHAR(40))";

    public LastFmDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.version = 1;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        if (i < i2) // old version < new version
        {
            Log.d(LOG_TAG, "onUpgrade() from " + i + " to " + i2);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LastFmMainData.PATH_USERS);
            onCreate(sqLiteDatabase);

        }
    }
}
