package app.vucinicvaso.resumebuilder.domain.usecase.account;

import android.content.Context;
import app.vucinicvaso.resumebuilder.core.cleanarchitecture.usecase.WTUseCaseWithParams;
import app.vucinicvaso.resumebuilder.domain.repository.account.AccountRepository;
import app.vucinicvaso.resumebuilder.data.repository.account.AccountRepositoryImpl;

public class AccountCreateUseCase extends WTUseCaseWithParams<AccountCreateUseCaseParams, Boolean> {

    @Override
    public void call(Context context, AccountCreateUseCaseParams params, Callback<Boolean> callback) {
        AccountRepository accountRepository = AccountRepositoryImpl.getInstance(context);

        accountRepository.insert(params.account, callback::onComplete);
    }

}

