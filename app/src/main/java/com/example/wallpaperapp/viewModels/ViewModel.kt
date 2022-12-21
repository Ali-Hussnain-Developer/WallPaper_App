package com.example.wallpaperapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.wallpaperapp.data.dataManager.DataManager
import com.example.wallpaperapp.model.ModelClass

class ViewModel : ViewModel() {


    var latestWallpaperList: ArrayList<ModelClass>
    var popularWallpaperList: ArrayList<ModelClass>
    var randomWallpaperList: ArrayList<ModelClass>
    var dataManager = DataManager

    init {

        latestWallpaperList = dataManager.getAllDataLatestWallpaper()
        popularWallpaperList = dataManager.getAllDataPopularWallpaper()
        randomWallpaperList = dataManager.getAllDataRandomWallpaper()


    }


}
