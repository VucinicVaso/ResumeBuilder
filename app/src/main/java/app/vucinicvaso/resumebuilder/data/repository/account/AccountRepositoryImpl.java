package app.vucinicvaso.resumebuilder.data.repository.account;

import java.util.List;
import java.util.Collections;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
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
            instance.init(context);
        }
        return instance;
    }

    @Override
    public void init(Context context) {
        setTableName("WT_TABLE_ACCOUNT");
        db = WTDatabaseImpl.getInstance(context);

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
            handler.post(() -> {
                try {
                    callback.onComplete(rowId != 0);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    @Override
    public void update(Account entity, Callback<Boolean> callback) {
        try {
            callback.onComplete(false);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Account entity, Callback<Boolean> callback) {
        try {
            callback.onComplete(false);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getById(int id, Callback<Account> callback) {
        try {
            callback.onComplete(null);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getAll(Callback<List<Account>> callback) {
        try {
            callback.onComplete(Collections.emptyList());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exists(Callback<Boolean> callback) {
        executorService.execute(() -> {
            final String query = "SELECT COUNT(*) FROM " + getTableName() + " WHERE id = 1;";
            final Cursor cursor = db.getDatabase().rawQuery(query, null);

            handler.post(() -> {
                if(cursor.moveToFirst()) {
                    try {
                        callback.onComplete(cursor.getInt(0) > 0);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                cursor.close();
            });
        });
    }

}