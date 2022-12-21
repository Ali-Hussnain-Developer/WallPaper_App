package com.example.wallpaperapp.data.dataManager

import com.example.wallpaperapp.model.ModelClass


interface DataManagerImp {
    fun getAllDataLatestWallpaper(): ArrayList<ModelClass>
    fun getAllDataPopularWallpaper(): ArrayList<ModelClass>
    fun getAllDataRandomWallpaper(): ArrayList<ModelClass>

}
