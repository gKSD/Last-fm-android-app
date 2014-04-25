package main.last.fm.content.provider;

import android.content.ContentValues;
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


    private static final String SQL_CREATE_USERS= "CREATE TABLE " + LastFmMainData.PATH_USERS + " (" +
            LastFmMainData.UsersColumns.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LastFmMainData.UsersColumns.LOGIN + " VARCHAR(200) UNIQUE,"+
            LastFmMainData.UsersColumns.PASSWORD + " VARCHAR(100),"+
            LastFmMainData.UsersColumns.MOBILE_SESSION + " VARCHAR(40))";

    public LastFmDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //onCreate(getWritableDatabase());
    }


    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            sqLiteDatabase.execSQL(SQL_CREATE_USERS);
        }
        catch( 	android.database.sqlite.SQLiteException exception)
        {
            Log.i(LOG_TAG, exception.getMessage());
        }
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

    public long insertUser(String table, ContentValues contentValues)
    {

        String sql1 = "INSERT OR IGNORE INTO " + table + "( '"+LastFmMainData.UsersColumns.LOGIN+"', '"+LastFmMainData.UsersColumns.PASSWORD+"', '"+ LastFmMainData.UsersColumns.MOBILE_SESSION +"') VALUES ('" + contentValues.get(LastFmMainData.UsersColumns.LOGIN) + "', '" + contentValues.get(LastFmMainData.UsersColumns.PASSWORD) +"', '"
            + contentValues.get(LastFmMainData.UsersColumns.MOBILE_SESSION) +"'); ";
        String sql2 = "UPDATE " + table + " SET " + LastFmMainData.UsersColumns.MOBILE_SESSION + " = '" + contentValues.get(LastFmMainData.UsersColumns.MOBILE_SESSION) +"' "+
                " WHERE " + LastFmMainData.UsersColumns.LOGIN + " = '" + contentValues.get(LastFmMainData.UsersColumns.LOGIN) + "' ;";

        try{
            getWritableDatabase().execSQL(sql1);
            Log.i(LOG_TAG, "11");
            getWritableDatabase().execSQL(sql2);
            Log.i(LOG_TAG, "22");
        }
        catch( 	android.database.sqlite.SQLiteException exception)
        {
            Log.i(LOG_TAG, exception.getMessage());
        }
        return 0;
    }

    //INSERT OR IGNORE INTO mytable VALUES ($id, 0);
    //UPDATE mytable SET count = count + 1 WHERE id = $id;
    /// ===
    //insert ON DUPLICATE KEY UPDATE
}
