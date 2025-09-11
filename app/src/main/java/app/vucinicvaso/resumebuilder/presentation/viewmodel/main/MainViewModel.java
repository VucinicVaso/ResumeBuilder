package app.vucinicvaso.resumebuilder.presentation.viewmodel.main;

import android.content.Context;
import app.vucinicvaso.resumebuilder.core.cleanarchitecture.mvvm.viewmodel.WTViewModel;
import app.vucinicvaso.resumebuilder.presentation.bindings.account.AccountService;
import app.vucinicvaso.resumebuilder.presentation.bindings.account.impl.AccountServiceImpl;

public class MainViewModel extends WTViewModel {

    public MainViewModel() {
        accountService = AccountServiceImpl.getInstance();
    }

    AccountService accountService;

    public void init(Context context) {
        accountService.exists(
            context,
            response -> {
                if(response) { signIn(context); }
                if(!response) { signUp(context); }
            }
        );
    }

    public void signIn(Context context) {
        accountService.signIn(
            context,
            response -> {
                if(response) { navigateTo(context, "dashboard"); }
                if(!response) { System.out.println("MainViewModel.signIn(): Failed to signIn."); }
            }
        );
    }

    public void signUp(Context context) {
        accountService.signUp(
            context,
            response -> {
                if(response) { signIn(context); }
                if(!response) { System.out.println("MainViewModel.signUp(): Failed to signUp."); }
            }
        );
    }

}
