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
    }

    private fun callLanguageActivity() {
        var intent = Intent(this,LanguageActivity::class.java)
        startActivity(intent)
    }
}