package app.vucinicvaso.resumebuilder.core.router;

import java.util.Map;
import app.vucinicvaso.resumebuilder.core.router.impl.WTRouterImpl;

public abstract class WTRoutes {

    public void registerRoutes(Map<String, String> map) {
        WTRouter router = WTRouterImpl.getInstance();
        map.forEach(router::addRoute);
    }

}
