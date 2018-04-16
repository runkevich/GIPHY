package com.gmail.runkevich8.app;


import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.gmail.runkevich8.injection.AppComponent;
import com.gmail.runkevich8.injection.AppModule;
import com.gmail.runkevich8.injection.DaggerAppComponent;

import io.fabric.sdk.android.Fabric;

public class App  extends Application {

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    private static AppComponent appComponent;

    //класс создается один раз при старте приложения в целом!
    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this,new Crashlytics());

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }
}
