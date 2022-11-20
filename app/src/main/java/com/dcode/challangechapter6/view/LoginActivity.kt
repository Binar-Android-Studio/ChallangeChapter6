package com.dcode.challangechapter6.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dcode.challangechapter6.databinding.ActivityLoginBinding


class LoginActivity() : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var  sharedPrefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            sharedPrefs = getSharedPreferences("registerData", Context.MODE_PRIVATE)

            var usernameData = sharedPrefs.getString("username", null)
            var passwordData = sharedPrefs.getString("pass", null)

            var usernamelgn = binding.username.text.toString()
            var passwordlgn = binding.password.text.toString()

            if (usernamelgn == usernameData && passwordData == passwordlgn){
                var addData = sharedPrefs.edit()
                addData.putString("usernamelgn", usernamelgn)
                addData.putString("passwordlgn", passwordlgn)
                addData.apply()
                Toast.makeText(this, "Login Sucsessfull", Toast.LENGTH_SHORT).show()

                var move = Intent(this, MainActivity::class.java)
                startActivity(move)
            }
            else
                Toast.makeText(this, "Username Dan Password Tidak Cocok !!", Toast.LENGTH_SHORT).show()

        }

        binding.register.setOnClickListener(){
            var move = Intent(this, RegisterActivity::class.java)
            startActivity(move)
        }
    }
}