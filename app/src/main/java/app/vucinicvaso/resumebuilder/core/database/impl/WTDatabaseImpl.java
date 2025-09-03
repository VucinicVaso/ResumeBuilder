package app.vucinicvaso.resumebuilder.core.database.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import app.vucinicvaso.resumebuilder.core.database.WTDatabase;

public class WTDatabaseImpl extends WTDatabase {

    private WTDatabaseImpl(Context context) {
        super(context, "WT_RESUME_BUILDER_DB", null, 1);
        
        if(instance != null) {
            throw new RuntimeException("Use getInstance() to get the single instance.");
        }
    }

    public static synchronized WTDatabase getInstance(Context context) {
        if(instance == null) {
            instance = new WTDatabaseImpl(context.getApplicationContext());

        }
        return instance;
    }

    @Override
    public void ensureTableExists(String tableName, String createTableSql) {
        final SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
            "SELECT name FROM sqlite_master WHERE type='table' AND name=?",
            new String[]{tableName}
        );
        boolean exists = (cursor.getCount() > 0);
        cursor.close();

        if(!exists) {
            db.execSQL(createTableSql);
        }
    }

}