package app.vucinicvaso.resumebuilder.data.model.account;

import app.vucinicvaso.resumebuilder.core.cleanarchitecture.entity.WTObjectMapper;
import app.vucinicvaso.resumebuilder.domain.entity.account.Account;

public class AccountMapper extends WTObjectMapper<Account, AccountModel> {

    @Override
    public Account toEntity(AccountModel model) {
        return new Account(
            model.getId(),
            model.getDate(),
            model.getFirstname(),
            model.getLastname(),
            model.getEmail()
        );
    }

    @Override
    public AccountModel toModel(Account entity) {
        return new AccountModel(
            entity.getId(),
            entity.getDate(),
            entity.getFirstname(),
            entity.getLastname(),
            entity.getEmail()
        );
    }

}
