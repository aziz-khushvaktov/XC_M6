package com.example.xc_m6_java.manager;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {

    Context context;
    SharedPreferences sharedPreferences;

    public PrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
    }

    public static PrefsManager prefsManager;

    public static PrefsManager getInstance(Context context) {
        if (prefsManager == null) {
            prefsManager = new PrefsManager(context);
        }
        return prefsManager;
    }

    public void saveData(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key,value);
        prefsEditor.commit();
    }

    public String loadData(String key) {
        return sharedPreferences.getString(key,"");
    }

    public void remove(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
    }

    public void clearAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
    }

}
