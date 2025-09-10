package app.vucinicvaso.resumebuilder.presentation.bindings.account;

import android.content.Context;
import app.vucinicvaso.resumebuilder.core.service.WTService;
import app.vucinicvaso.resumebuilder.domain.entity.account.Account;

public abstract class AccountService extends WTService<AccountService> {

    protected static AccountService instance;

    Account account;

    public abstract void exists(Context context, Callback<Boolean> callback);

    public abstract void signIn(Context context, Callback<Boolean> callback);

    public abstract void signUp(Context context, Callback<Boolean> callback);

    public abstract void signOut(Context context, Callback<Boolean> callback);

}
