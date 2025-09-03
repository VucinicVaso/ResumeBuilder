package app.vucinicvaso.resumebuilder.core.router.impl;

import java.util.Map;
import android.content.Intent;
import android.content.Context;
import app.vucinicvaso.resumebuilder.core.router.WTRouter;

public class WTRouterImpl extends WTRouter {

    private WTRouterImpl() {
        if(instance != null) {
            throw new RuntimeException("Use getInstance() to get the single instance.");
        }
    }

    public static synchronized WTRouter getInstance() {
        if(instance == null) {
            instance = new WTRouterImpl();
        }
        return instance;
    }

    @Override
    public void addRoute(String key, String route) { routes.put(key, route); }

    @Override
    public Map<String, String> getRoutes() { return routes; }

    @Override
    public void navigateTo(Context context, String route) {
        try {
            String routeClass = routes.get(route);

            assert routeClass != null;
            if(!routeClass.isEmpty()) {
                Intent intent = new Intent(context, Class.forName(routeClass));
                context.startActivity(intent);
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}