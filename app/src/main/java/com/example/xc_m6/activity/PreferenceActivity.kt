package com.example.xc_m6.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.view.isVisible
import com.example.xc_m6.R
import com.example.xc_m6.databinding.ActivityPreferenceBinding
import com.example.xc_m6.manager.PrefsManager
import kotlinx.android.synthetic.main.activity_language.*
import kotlinx.android.synthetic.main.activity_preference.*

class PreferenceActivity : AppCompatActivity() {

    lateinit var binding: ActivityPreferenceBinding
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {

        binding.apply {
            b_save.setOnClickListener {
                val email = et_email.text.toString().trim()
                PrefsManager.getInstance(this@PreferenceActivity)!!.saveData("email",email,this@PreferenceActivity)
                et_email.text.clear()
                et_email.hint = "Successfully saved!"
                handler = Handler(mainLooper)
                handler.postDelayed(object : Runnable{
                    override fun run() {
                        et_email.hint = ""
                    }
                },3000)
            }

            b_load.setOnClickListener {
                tv_email.text = PrefsManager(this@PreferenceActivity).loadData("email")
            }

            b_remove.setOnClickListener {
                PrefsManager.getInstance(this@PreferenceActivity)!!.removeData("email")
                b_remove.text = "Removing..."
                handler = Handler(mainLooper)
                handler.postDelayed({ b_remove.text = "Successfully removed!" },3000)
                handler.postDelayed({b_remove.text = "Remove"},4000)
            }

            b_clear.setOnClickListener { PrefsManager(this@PreferenceActivity).clearAll() }

        }

    }



}