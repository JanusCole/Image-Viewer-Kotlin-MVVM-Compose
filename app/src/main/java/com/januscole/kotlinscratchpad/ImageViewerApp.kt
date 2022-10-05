package com.januscole.kotlinscratchpad

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ImageViewerApp: Application() {

    companion object {
        lateinit var instance: ImageViewerApp
            private set
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

}