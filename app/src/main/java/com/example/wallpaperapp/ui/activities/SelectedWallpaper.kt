package com.example.wallpaperapp.ui.activities

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wallpaperapp.R
import com.example.wallpaperapp.constants.Constants
import com.example.wallpaperapp.databinding.ActivitySelectedWallpaperBinding
import java.io.IOException


class SelectedWallpaper : AppCompatActivity() {
    lateinit var binding: ActivitySelectedWallpaperBinding
    lateinit var wallpaperManager: WallpaperManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivitySelectedWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeViews()
        clickListener()

    }

    @SuppressLint("ResourceType")
    private fun initializeViews() {
        val window = this.window
        window.statusBarColor = Color.parseColor(getString(R.color.color_tab_layout))
        wallpaperManager = WallpaperManager.getInstance(applicationContext)
        val intent = intent
        val selectedWallpaper = intent.getIntExtra(Constants.SELECTED_WALLPAPER, 0)
        binding.imgSelectedWallpaper.setImageResource(selectedWallpaper)


    }

    private fun clickListener() {

        binding.btnSetWallpaper.setOnClickListener {
            try {
                wallpaperManager.setResource(getIntent().getIntExtra(Constants.SELECTED_WALLPAPER,
                    0))
                Toast.makeText(applicationContext,
                    getString(R.string.txt_wallpaper_is_set),
                    Toast.LENGTH_LONG).show()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }


    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}