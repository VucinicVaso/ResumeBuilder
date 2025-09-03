package app.vucinicvaso.resumebuilder.presentation.bindings.router;

import java.util.Map;
import java.util.HashMap;
import app.vucinicvaso.resumebuilder.core.router.WTRoutes;
import app.vucinicvaso.resumebuilder.presentation.view.main.MainView;
import app.vucinicvaso.resumebuilder.presentation.view.dashboard.DashboardView;

public class ResumeBuilderRoutes extends WTRoutes {

    public ResumeBuilderRoutes() {
        Map<String, String> map = new HashMap<>();
        map.put("main",      MainView.class.getCanonicalName());
        map.put("dashboard", DashboardView.class.getCanonicalName());

        registerRoutes(map);
    }

}
