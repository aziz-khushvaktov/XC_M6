package com.example.xc_m6_java.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xc_m6_java.MyApplication;
import com.example.xc_m6_java.R;
import com.example.xc_m6_java.databinding.ActivityLanguageBinding;
import com.example.xc_m6_java.manager.LocaleManager;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    ActivityLanguageBinding binding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    private void initViews() {
        context = this;

        binding.bEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.instance.localeManager.setNewLocale(context, LocaleManager.LANGUAGE_ENGLISH);
                finish();
            }
        });

        binding.bRussian.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                MyApplication.instance.localeManager.setNewLocale(context,LocaleManager.LANGUAGE_RUSSIAN);
                finish();
            }
        });

        binding.bUzbek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.instance.localeManager.setNewLocale(context,LocaleManager.LANGUAGE_UZBEK);
                finish();
            }
        });
        // one = 1
        String one = getResources().getQuantityString(R.plurals.my_cats,1,1);
        // few = 2~3
        String few = getResources().getQuantityString(R.plurals.my_cats,2,3);
        // many = 5~
        String many = getResources().getQuantityString(R.plurals.my_cats,5,10);

        Log.d("LanguageActivity one",one);
        Log.d("LanguageActivity few",few);
        Log.d("LanguageActivity many",many);
    }

    private void setLocale(String lan) {
        Locale locale = new Locale(lan);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        finish();
    }
}