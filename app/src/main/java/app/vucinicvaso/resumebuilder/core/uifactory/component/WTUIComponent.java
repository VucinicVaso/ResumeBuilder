package app.vucinicvaso.resumebuilder.core.uifactory.component;

import android.content.Context;
import android.view.View;

public abstract class WTUIComponent {

    protected Context context;
    public void setContext(Context v) { context = v; }
    public Context getContext() { return context; }

    public abstract View build();

}
