package com.example.xc_m6

import android.app.Application
import android.content.res.Configuration
import android.util.Log
import com.example.xc_m6.manager.LocaleManager
import io.realm.Realm
import io.realm.RealmCollection
import io.realm.RealmConfiguration

/**
 * MyApplication - is a class that opens even before MainActivity.
 * Here we can control the language that set last time.
 */

class MyApplication: Application() {
    companion object {
        val TAG = MyApplication::class.java.simpleName
        var localeManger: LocaleManager? = null
    }

    override fun onCreate() {
        super.onCreate()
        localeManger = LocaleManager(this)
        localeManger!!.setLocale(this)
        Log.d("language_key", localeManger!!.language.toString())
        initRealm()
    }
    // For REALM DATABASE
    private fun initRealm() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localeManger!!.setLocale(this)
    }
}