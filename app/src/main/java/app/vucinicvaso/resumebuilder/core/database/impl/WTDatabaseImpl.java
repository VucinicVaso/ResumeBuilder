package app.vucinicvaso.resumebuilder.core.database.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import app.vucinicvaso.resumebuilder.core.database.WTDatabase;

public class WTDatabaseImpl extends WTDatabase {

    private WTDatabaseImpl() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() to get the single instance.");
        }
    }

    private static WTDatabase instance;
    public static WTDatabase getInstance(Context context) {
        if(instance == null) {
            instance = new WTDatabaseImpl();
            instance.setContext(context);
            instance.setDatabaseName("resume_builder_db");
            instance.setDatabaseVersion(1);
            instance.init();
        }
        return instance;
    }

    @Override
    public void init() {
        DatabaseHelper dbHelper = new DatabaseHelper(context, databaseName, databaseVersion);
        db = dbHelper.getWritableDatabase();
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context, String DATABASE_NAME, int DATABASE_VERSION) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {}

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onCreate(db);
        }

    }

}
