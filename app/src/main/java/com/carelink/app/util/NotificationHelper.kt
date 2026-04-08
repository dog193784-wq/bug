package com.carelink.app.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

class NotificationHelper(private val context: Context) {
    fun createChannels() {
        val manager = context.getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(NotificationChannel("carelink_alerts", "CareLink Alerts", NotificationManager.IMPORTANCE_HIGH))
    }

    fun buildBasic(title: String, body: String) = NotificationCompat.Builder(context, "carelink_alerts").setContentTitle(title).setContentText(body).build()
}
