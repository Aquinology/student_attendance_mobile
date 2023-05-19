package com.example.attendance

import android.app.Application
import com.example.attendance.data.AppContainer
import com.example.attendance.data.AppContainerImpl

class AttendanceApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}
