package app.vucinicvaso.resumebuilder;

import android.app.Application;
import app.vucinicvaso.resumebuilder.presentation.bindings.router.ResumeBuilderRoutes;

public class ResumeBuilderApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new ResumeBuilderRoutes();
    }

}
