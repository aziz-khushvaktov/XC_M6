package com.example.xc_m6.manager

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import kotlin.coroutines.coroutineContext

class PrefsManager(context: Context) {

    private val sharedPreferences: SharedPreferences?

    companion object {
        private var prefsManager: PrefsManager? = null
        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences("MyPrefs",Context.MODE_PRIVATE)
        // A file that named MyPrefs will open in the locale memory
    }

    fun saveData(key: String?, value: String?,context: Context) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key,value)
        prefsEditor.commit()
    }

    fun loadData(key: String?): String? {
        return if (sharedPreferences != null) sharedPreferences.getString(key,"") else ""
    }

    fun removeData(key: String?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.remove(key)
    }

    fun clearAll() {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.clear()
    }
}