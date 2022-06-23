package com.example.xc_m6.activity

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.xc_m6.R
import kotlinx.android.synthetic.main.activity_language.*
import java.util.*

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        initViews()
    }

    private fun initViews() {
        b_english.setOnClickListener { setLocale("en") }

        b_russian.setOnClickListener { setLocale("ru") }

        b_uzbek.setOnClickListener { setLocale("uz") }

        // one = 1
        val one = resources.getQuantityString(R.plurals.my_cats, 1, 1)
        // few = 2~4
        val few = resources.getQuantityString(R.plurals.my_cats, 2, 3)
        // many = 5~
        val many = resources.getQuantityString(R.plurals.my_cats, 5, 10)

        Log.d("LanguageActivity one", one)
        Log.d("LanguageActivity few", few)
        Log.d("LanguageActivity many", many)
    }

    private fun setLocale(lan: String) {
        val locale = Locale(lan)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        finish()
    }
}