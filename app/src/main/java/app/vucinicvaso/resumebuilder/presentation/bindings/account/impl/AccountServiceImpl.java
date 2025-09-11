package app.vucinicvaso.resumebuilder.presentation.bindings.account.impl;

import android.content.Context;
import app.vucinicvaso.resumebuilder.domain.entity.account.Account;
import app.vucinicvaso.resumebuilder.domain.usecase.account.AccountExistsUseCase;
import app.vucinicvaso.resumebuilder.domain.usecase.account.AccountGetSelectedUseCase;
import app.vucinicvaso.resumebuilder.presentation.bindings.account.AccountService;
import app.vucinicvaso.resumebuilder.domain.usecase.account.AccountCreateUseCase;
import app.vucinicvaso.resumebuilder.domain.usecase.account.AccountCreateUseCaseParams;

public class AccountServiceImpl extends AccountService {

    private AccountServiceImpl() {
        if(instance != null) {
            throw new RuntimeException("Use getInstance() to get the single instance.");
        }
    }

    public static AccountService getInstance() {
        if(instance == null) {
            instance = new AccountServiceImpl();
        }
        return instance;
    }

    @Override
    public void exists(Context context, Callback<Boolean> callback) {
        new AccountExistsUseCase().call(
            context,
            response -> {
                if(response) { callback.onComplete(true); }
                if(!response) { callback.onComplete(false); }
            }
        );
    }

    @Override
    public void signIn(Context context, Callback<Boolean> callback) {
        new AccountGetSelectedUseCase().call(
            context,
            response -> {
                if(response != null) {
                    account = response;
                    callback.onComplete(true);
                }
                if(response == null) { callback.onComplete(false); }
            }
        );
    }

    @Override
    public void signUp(Context context, Callback<Boolean> callback) {
        Account entity = new Account(0, "", "", "", "", true);

        new AccountCreateUseCase().call(
            context,
            new AccountCreateUseCaseParams(entity),
            response -> {
                if(response) { callback.onComplete(true); }
                if(!response) { throw new RuntimeException("AccountService.signUp(): failed to create new account"); }
            }
        );
    }

    @Override
    public void signOut(Context context, Callback<Boolean> callback) {
        ///
    }

}
