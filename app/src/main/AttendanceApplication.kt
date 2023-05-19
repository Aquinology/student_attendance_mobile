package com.example.sacheck

import android.app.Application
import com.example.sacheck.data.AppContainer
import com.example.sacheck.data.AppContainerImpl

class SACheckApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}
