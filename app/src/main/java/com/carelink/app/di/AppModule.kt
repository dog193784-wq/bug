package com.carelink.app.di

import android.content.Context
import com.carelink.app.data.local.preferences.UserPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun prefs(@ApplicationContext context: Context): UserPreferencesManager = UserPreferencesManager(context)
}
