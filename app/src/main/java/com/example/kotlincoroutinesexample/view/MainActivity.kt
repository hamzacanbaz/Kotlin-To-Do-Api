package com.example.kotlincoroutinesexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlincoroutinesexample.R
import com.example.kotlincoroutinesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}