package app.vucinicvaso.resumebuilder.domain.repository.account;

import app.vucinicvaso.resumebuilder.core.cleanarchitecture.repository.WTRepository;
import app.vucinicvaso.resumebuilder.domain.entity.account.Account;

public abstract class AccountRepository extends WTRepository<Account> {

    protected static AccountRepository instance;

}
