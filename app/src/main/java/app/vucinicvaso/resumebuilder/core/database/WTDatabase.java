package app.vucinicvaso.resumebuilder.core.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class WTDatabase extends SQLiteOpenHelper {

    protected static WTDatabase instance;

    public WTDatabase(Context context, String name, Object o, int version) {
        super(context, name, null, version);
        setDatabaseName(name);
        setDatabaseVersion(version);
        setDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create tables
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // upgrade logic
    }

    protected SQLiteDatabase db;
    public void setDatabase() { db = this.getReadableDatabase(); }
    public SQLiteDatabase getDatabase() { return db; }

    protected String databaseName;
    public void setDatabaseName(String v) { databaseName = v; }
    public String getDatabaseName() { return databaseName; }

    protected int databaseVersion;
    public void setDatabaseVersion(int v) { databaseVersion = v; }
    public int getDatabaseVersion() { return databaseVersion; }

    public abstract void ensureTableExists(String tableName, String createTableSql);

}
