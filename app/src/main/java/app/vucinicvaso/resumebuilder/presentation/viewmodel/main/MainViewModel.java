package app.vucinicvaso.resumebuilder.presentation.viewmodel.main;

import android.content.Context;
import android.content.Intent;
import app.vucinicvaso.resumebuilder.core.cleanarchitecture.mvvm.viewmodel.WTViewModel;
import app.vucinicvaso.resumebuilder.domain.entity.account.Account;
import app.vucinicvaso.resumebuilder.domain.usecase.account.AccountExistsUseCase;
import app.vucinicvaso.resumebuilder.domain.usecase.account.AccountCreateUseCase;
import app.vucinicvaso.resumebuilder.domain.usecase.account.AccountCreateUseCaseParams;
import app.vucinicvaso.resumebuilder.presentation.view.dashboard.DashboardView;

public class MainViewModel extends WTViewModel {

    public MainViewModel() { }

    public void init(Context context) {
        new AccountExistsUseCase().call(context, response -> {
            if(response) { redirect(context); }
            if(!response) { createAccount(context); }
        });
    }

    public void createAccount(Context context) {
        Account account = new Account(0, "", "", "", "");

        new AccountCreateUseCase().call(context, new AccountCreateUseCaseParams(account), response -> {
            if(response) { redirect(context); }
            if(!response) { System.out.println("failed to create new account"); }
        });
    }

    public void redirect(Context context) {
        Intent intent = new Intent(context, DashboardView.class);
        context.startActivity(intent);
    }

}
