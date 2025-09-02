package app.vucinicvaso.resumebuilder.core.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class WTDatabase {

    public abstract void init();

    protected SQLiteDatabase db;
    public SQLiteDatabase getDatabase() { return db; }

    protected Context context;
    public void setContext(Context v) { context = v; }
    public Context getContext() { return context; }

    protected String databaseName;
    public void setDatabaseName(String v) { databaseName = v; }
    public String getDatabaseName() { return databaseName; }

    protected int databaseVersion;
    public void setDatabaseVersion(int v) { databaseVersion = v; }
    public int getDatabaseVersion() { return databaseVersion; }

    public abstract void ensureTableExists(String tableName, String createTableSql);

}
