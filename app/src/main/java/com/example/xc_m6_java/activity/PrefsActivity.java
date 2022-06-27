package com.example.xc_m6_java.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xc_m6_java.databinding.ActivityPrefsBinding;
import com.example.xc_m6_java.manager.PrefsManager;

public class PrefsActivity extends AppCompatActivity {

    ActivityPrefsBinding binding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrefsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    private void initViews() {
        context = this;

        binding.bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrefsManager.getInstance(context).saveData("email", binding.etEmail.getText().toString());
            }
        });

        binding.bLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvEmail.setText(PrefsManager.getInstance(context).loadData("email"));
            }
        });

        binding.bRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrefsManager.getInstance(context).remove("email");
            }
        });

        binding.bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrefsManager.getInstance(context).clearAll();
            }
        });
    }


    private void saveEmail(String email) {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email", email);
        editor.apply();
    }

    private String loadEmail() {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return prefs.getString("email", "There is nothing yet!");
    }
}