package com.carelink.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carelink.app.data.local.db.dao.*
import com.carelink.app.data.local.db.entity.*

@Database(entities = [HealthDataEntity::class, AlertRuleEntity::class, ReportConfigEntity::class, DeliveryLogEntity::class, ParentProfileEntity::class], version = 1, exportSchema = true)
abstract class CareLinkDatabase : RoomDatabase() {
    abstract fun healthDataDao(): HealthDataDao
    abstract fun alertRuleDao(): AlertRuleDao
    abstract fun reportConfigDao(): ReportConfigDao
    abstract fun deliveryLogDao(): DeliveryLogDao
    abstract fun parentProfileDao(): ParentProfileDao
}
