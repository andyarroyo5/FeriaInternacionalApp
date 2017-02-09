package edu.udem.feriainternacional;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by laboratorio on 2/8/17.
 */

public class GlobalApp extends Application {

    private GlobalApp globalApp;


    public GlobalApp getInstance() {
        return globalApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Required initialization logic here! singleton
        globalApp=this;

    }

    // Called by the system when the device configuration changes while your component is running.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


}
