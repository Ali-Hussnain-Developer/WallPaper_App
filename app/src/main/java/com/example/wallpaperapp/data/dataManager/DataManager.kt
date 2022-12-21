package com.example.wallpaperapp.data.dataManager

import com.example.wallpaperapp.R
import com.example.wallpaperapp.model.ModelClass

object DataManager : DataManagerImp {

    override fun getAllDataLatestWallpaper(): ArrayList<ModelClass> {
        val latestWallpaperList = ArrayList<ModelClass>()
        latestWallpaperList.add(ModelClass(R.drawable.wallpaper_one))
        latestWallpaperList.add(ModelClass(R.drawable.splash_wallpaper))
        latestWallpaperList.add(ModelClass(R.drawable.wallpaper_six))
        latestWallpaperList.add(ModelClass(R.drawable.wallpaper_seven))
        latestWallpaperList.add(ModelClass(R.drawable.wallpaper_eight))
        latestWallpaperList.add(ModelClass(R.drawable.wallpaper_thirty))
        latestWallpaperList.add(ModelClass(R.drawable.wallpaper_thirty_one))
        latestWallpaperList.add(ModelClass(R.drawable.wallpaper_thirty_three))
        return latestWallpaperList

    }

    override fun getAllDataPopularWallpaper(): ArrayList<ModelClass> {
        val popularWallpaperList = ArrayList<ModelClass>()
        popularWallpaperList.add(ModelClass(R.drawable.wallpaper_ten))
        popularWallpaperList.add(ModelClass(R.drawable.wallpaper_eleve))
        popularWallpaperList.add(ModelClass(R.drawable.wallpaper_twelve))
        popularWallpaperList.add(ModelClass(R.drawable.wallpaper_twenty_two))
        popularWallpaperList.add(ModelClass(R.drawable.wallpaper_twenty_three))
        popularWallpaperList.add(ModelClass(R.drawable.wallpaper_twenty_six))
        popularWallpaperList.add(ModelClass(R.drawable.wallpaper_sixty_seven))
        popularWallpaperList.add(ModelClass(R.drawable.wallpaper_sixty_six))
        return popularWallpaperList

    }

    override fun getAllDataRandomWallpaper(): ArrayList<ModelClass> {
        val randomWallpaperList = ArrayList<ModelClass>()
        randomWallpaperList.add(ModelClass(R.drawable.wallpaper_thirteen))
        randomWallpaperList.add(ModelClass(R.drawable.wallpaper_sixteen))
        randomWallpaperList.add(ModelClass(R.drawable.wallpaper_nineteen))
        randomWallpaperList.add(ModelClass(R.drawable.wallpaper_twenty))
        randomWallpaperList.add(ModelClass(R.drawable.wallpaper_thirty_eight))
        randomWallpaperList.add(ModelClass(R.drawable.wallpaper_sixty_eight))
        randomWallpaperList.add(ModelClass(R.drawable.wallpaper_sixty_nine))
        randomWallpaperList.add(ModelClass(R.drawable.wallpaper_seventy))
        return randomWallpaperList

    }


}







