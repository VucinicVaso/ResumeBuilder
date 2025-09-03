package app.vucinicvaso.resumebuilder.core.router;

import java.util.Map;
import java.util.HashMap;
import android.content.Context;

public abstract class WTRouter {

    protected static WTRouter instance;

    protected final Map<String, String> routes = new HashMap<>();
    public abstract void addRoute(String key, String route);
    public abstract Map<String, String> getRoutes();

    public abstract void navigateTo(Context context, String route) throws ClassNotFoundException;

}
