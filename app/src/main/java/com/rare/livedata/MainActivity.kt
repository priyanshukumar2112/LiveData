package com.rare.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rare.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var passViewModel: PassViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        passViewModel = ViewModelProvider(this)[PassViewModel::class.java]
        passViewModel.addStrings()
        binding.btnfrd.setOnClickListener {
            passViewModel.switchForward()
        }
    }
}