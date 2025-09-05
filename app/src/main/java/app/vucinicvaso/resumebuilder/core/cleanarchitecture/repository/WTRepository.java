package app.vucinicvaso.resumebuilder.core.cleanarchitecture.repository;

import android.content.Context;
import java.util.List;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import app.vucinicvaso.resumebuilder.core.database.WTDatabase;

public abstract class WTRepository<T> {

    public abstract void init(Context context);

    protected final ExecutorService executorService = Executors.newSingleThreadExecutor();
    protected final Handler handler = new Handler(Looper.getMainLooper());

    public interface Callback<T> {
        void onComplete(T result) throws ClassNotFoundException;
    }

    protected WTDatabase database;

    protected String tableName;
    public void setTableName(String v) { tableName = v; }
    public String getTableName() { return tableName; }

    public abstract void insert(T entity, Callback<Boolean> callback);
    public abstract void update(T entity, Callback<Boolean> callback);
    public abstract void delete(T entity, Callback<Boolean> callback);
    public abstract void getById(int id, Callback<T> callback);
    public abstract void getAll(Callback<List<T>> callback);

}
