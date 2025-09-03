package app.vucinicvaso.resumebuilder.domain.usecase.account;

import app.vucinicvaso.resumebuilder.domain.entity.account.Account;

public class AccountCreateUseCaseParams {

    protected Account account;

    public AccountCreateUseCaseParams(Account v) {
        account = v;
    }

}
