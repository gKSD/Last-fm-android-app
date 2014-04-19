package main.last.fm.content.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sofia on 17.04.14.
 */
public class LastFmDatabaseHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "last_fm_database";


    private Integer version;

    LastFmDatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.version = 1;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //db.execSQL(SQL_CREATE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
