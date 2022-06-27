package com.example.xc_m6.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.xc_m6.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        btn_languageActivity.setOnClickListener { callLanguageActivity() }

        b_PreferenceActivity.setOnClickListener { callSharedPreferenceActivity() }

        b_databaseActivity.setOnClickListener { callDatabaseActivity() }
    }

    private fun callDatabaseActivity() {
        val intent = Intent(this,DatabaseActivity::class.java)
        startActivity(intent)
    }

    private fun callSharedPreferenceActivity() {
        val intent = Intent(this,PreferenceActivity::class.java)
        startActivity(intent)
    }

    private fun callLanguageActivity() {
        var intent = Intent(this,LanguageActivity::class.java)
        startActivity(intent)
    }
}