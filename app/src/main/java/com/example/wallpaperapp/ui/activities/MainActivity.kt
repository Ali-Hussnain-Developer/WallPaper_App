package com.example.wallpaperapp.ui.activities

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wallpaperapp.R
import com.example.wallpaperapp.adapter.ViewPagerAdapter
import com.example.wallpaperapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var viewPagerAdapter: ViewPagerAdapter? = null

    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val window = this.window
        window.statusBarColor = Color.parseColor(getString(R.color.color_tab_layout))
        viewPagerAdapter = ViewPagerAdapter(getSupportFragmentManager())
        binding.viewPager.setAdapter(viewPagerAdapter)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}