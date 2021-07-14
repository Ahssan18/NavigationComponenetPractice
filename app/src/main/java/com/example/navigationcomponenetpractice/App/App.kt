package com.example.navigationcomponenetpractice.App

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

public const val AppId = "Demoapp"
class App : Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        try {
            val channel = NotificationChannel(AppId, "Notification Channel", NotificationManager.IMPORTANCE_HIGH)
            (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(
                channel
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}