package com.dcode.challangechapter6.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dcode.challangechapter6.databinding.ActivitySplashscreenBinding


class SplashscreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var data = getSharedPreferences("registerData", Context.MODE_PRIVATE)
        var username = data.getString("usernamelgn", null)
        var pass = data.getString("passwordlgn", null)

        Handler(Looper.myLooper()!!).postDelayed({
            if(username != null && pass != null)
                startActivity(Intent(this, MainActivity::class.java))
            else
                startActivity(Intent(this, LoginActivity::class.java))
        },500)
    }
}