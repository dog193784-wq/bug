package com.carelink.app.data.local.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.carelink.app.domain.model.UserSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("carelink_settings")

class UserPreferencesManager(private val context: Context) {
    private object Keys {
        val SYNC_INTERVAL = intPreferencesKey("sync_interval")
        val WIFI_ONLY = booleanPreferencesKey("wifi_only")
    }

    val settings: Flow<UserSettings> = context.dataStore.data.map { prefs ->
        UserSettings(syncIntervalMinutes = prefs[Keys.SYNC_INTERVAL] ?: 60, wifiOnlySync = prefs[Keys.WIFI_ONLY] ?: false)
    }

    suspend fun setSyncInterval(minutes: Int) {
        context.dataStore.edit { it[Keys.SYNC_INTERVAL] = minutes }
    }
}
