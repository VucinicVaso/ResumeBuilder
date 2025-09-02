package app.vucinicvaso.resumebuilder.data.repository.account;

import android.content.ContentValues;
import android.content.Context;
import java.util.Collections;
import java.util.List;
import app.vucinicvaso.resumebuilder.core.database.impl.WTDatabaseImpl;
import app.vucinicvaso.resumebuilder.domain.entity.account.Account;
import app.vucinicvaso.resumebuilder.domain.repository.account.AccountRepository;

public class AccountRepositoryImpl extends AccountRepository {

    private AccountRepositoryImpl() {
        if(instance != null) {
            throw new RuntimeException("Use getInstance() to get the single instance.");
        }
    }

    public static AccountRepository getInstance(Context context) {
        if(instance == null) {
            instance = new AccountRepositoryImpl();
        }
        instance.init(context);
        return instance;
    }

    @Override
    public void init(Context context) {
        setTableName("WT_TABLE_ACCOUNT");
        db = WTDatabaseImpl.getInstance(null);

        if(db.getDatabase().isOpen()) {
            final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + getTableName() + " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " date TEXT, " +
                " firstname TEXT, " +
                " lastname TEXT, " +
                " email TEXT " +
            ");";
            db.ensureTableExists(getTableName(), CREATE_TABLE);
        }
    }

    @Override
    public void insert(Account entity, Callback<Boolean> callback) {
        executorService.execute(() -> {
            ContentValues values = new ContentValues();
            values.put("date",      entity.getDate());
            values.put("firstname", entity.getFirstname());
            values.put("lastname",  entity.getLastname());
            values.put("email",     entity.getEmail());

            long rowId = db.getDatabase().insert(getTableName(), null, values);
            handler.post(() -> callback.onComplete(rowId != 0));
        });

        callback.onComplete(false);
    }

    @Override
    public void update(Account entity, Callback<Boolean> callback) {
        callback.onComplete(false);
    }

    @Override
    public void delete(Account entity, Callback<Boolean> callback) {
        callback.onComplete(false);
    }

    @Override
    public void getById(int id, Callback<Account> callback) {
        callback.onComplete(null);
    }

    @Override
    public void getAll(Callback<List<Account>> callback) {
        callback.onComplete(Collections.emptyList());
    }

}
