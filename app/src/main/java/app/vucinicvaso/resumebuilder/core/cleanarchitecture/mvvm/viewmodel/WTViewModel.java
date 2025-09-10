package app.vucinicvaso.resumebuilder.core.cleanarchitecture.mvvm.viewmodel;

import android.content.Context;
import app.vucinicvaso.resumebuilder.core.router.impl.WTRouterImpl;

public abstract class WTViewModel {

    public void navigateTo(Context context, String route) throws ClassNotFoundException {
        var router = WTRouterImpl.getInstance();
        router.navigateTo(context, route);
    }

}
