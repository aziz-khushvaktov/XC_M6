package com.example.xc_m6_java.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xc_m6_java.R;
import com.example.xc_m6_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    private void initViews() {
        binding.btnLanguageActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLanguageActivity();
            }
        });

        binding.btnSharedPreferenceActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSharedPreferenceActivity();
            }
        });

        binding.bDatabaseActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDatabaseActivity();
            }
        });
    }

    private void callDatabaseActivity() {
        Intent intent = new Intent(this,DatabaseActivity.class);
        startActivity(intent);
    }

    private void callSharedPreferenceActivity() {
        Intent intent = new Intent(this,PrefsActivity.class);
        startActivity(intent);
    }

    private void callLanguageActivity() {
        Intent intent = new Intent(this,LanguageActivity.class);
        startActivity(intent);
    }
}