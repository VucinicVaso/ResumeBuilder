package app.vucinicvaso.resumebuilder.domain.usecase.account;

import android.content.Context;
import app.vucinicvaso.resumebuilder.core.cleanarchitecture.usecase.WTUseCase;
import app.vucinicvaso.resumebuilder.domain.entity.account.Account;
import app.vucinicvaso.resumebuilder.domain.repository.account.AccountRepository;
import app.vucinicvaso.resumebuilder.data.repository.account.AccountRepositoryImpl;

public class AccountGetSelectedUseCase extends WTUseCase<Account> {

    @Override
    public void call(Context context, Callback<Account> callback) {
        AccountRepository accountRepository = AccountRepositoryImpl.getInstance(context);
        accountRepository.getSelected(callback::onComplete);
    }

}