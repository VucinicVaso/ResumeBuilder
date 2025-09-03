package app.vucinicvaso.resumebuilder.domain.usecase.account;

import android.content.Context;
import app.vucinicvaso.resumebuilder.core.cleanarchitecture.usecase.WTUseCase;
import app.vucinicvaso.resumebuilder.data.repository.account.AccountRepositoryImpl;
import app.vucinicvaso.resumebuilder.domain.repository.account.AccountRepository;

public class AccountExistsUseCase extends WTUseCase<Boolean> {

    @Override
    public void call(Context context, Callback<Boolean> callback) {
        AccountRepository accountRepository = AccountRepositoryImpl.getInstance(context);

        accountRepository.exists(callback::onComplete);
    }

}