package com.example.xc_m6_java;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.example.xc_m6_java.manager.LocaleManager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * MyApplication - is a class that opens even before MainActivity.
 * Here we can control the language that set last time.
 */

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();
    public static MyApplication instance;
    public LocaleManager localeManager;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        localeManager = new LocaleManager(this);
        localeManager.setLocale(this);
        initRealm();
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localeManager.setLocale(this);
    }

    private void initRealm() {
        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .allowWritesOnUiThread(true)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

}
