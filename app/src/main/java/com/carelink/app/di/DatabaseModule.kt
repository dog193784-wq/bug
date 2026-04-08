package com.carelink.app.di

import android.content.Context
import androidx.room.Room
import com.carelink.app.data.local.db.CareLinkDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun db(@ApplicationContext context: Context): CareLinkDatabase =
        Room.databaseBuilder(context, CareLinkDatabase::class.java, "carelink.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides fun healthDao(db: CareLinkDatabase) = db.healthDataDao()
    @Provides fun alertDao(db: CareLinkDatabase) = db.alertRuleDao()
    @Provides fun reportDao(db: CareLinkDatabase) = db.reportConfigDao()
    @Provides fun deliveryDao(db: CareLinkDatabase) = db.deliveryLogDao()
}
