package com.example.challangechapter6.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.challangechapter6.R
import com.example.challangechapter6.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)


        val bundle = intent.extras
//        var getname = bundle?.getString("name").toString()
        var getname = intent.extras?.getString("name")
        var getpopularity = intent.extras?.getString("popularity")
        var getimagelink = intent.extras?.getString("imagelink")
        var getdesc = intent.extras?.getString("desc")

        Glide.with(this).load(getimagelink).into(binding.ivPoster)
        binding.title.setText(getname)
        binding.popularity.setText(getpopularity)
        binding.overview.setText(getdesc)


        setContentView(binding.root)
    }
}