package com.carelink.app.data.local.db.entity

import androidx.room.*

@Entity(tableName = "health_data", indices = [Index(value = ["parent_id", "metric_type", "timestamp"])])
data class HealthDataEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, @ColumnInfo(name = "parent_id") val parentId: String, @ColumnInfo(name = "metric_type") val metricType: String, val value: Double, val unit: String, val timestamp: Long, @ColumnInfo(name = "date") val date: String, @ColumnInfo(name = "raw_data") val rawData: String? = null)

@Entity(tableName = "alert_rules")
data class AlertRuleEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, @ColumnInfo(name = "parent_id") val parentId: String, @ColumnInfo(name = "alert_type") val alertType: String, @ColumnInfo(name = "metric_type") val metricType: String, val condition: String, val threshold: Double, @ColumnInfo(name = "secondary_threshold") val secondaryThreshold: Double? = null, @ColumnInfo(name = "duration_minutes") val durationMinutes: Int = 0, val sensitivity: String, @ColumnInfo(name = "delivery_channel") val deliveryChannel: String, val enabled: Boolean = true, @ColumnInfo(name = "cooldown_minutes") val cooldownMinutes: Int = 60, @ColumnInfo(name = "last_triggered") val lastTriggered: Long? = null)

@Entity(tableName = "report_configs")
data class ReportConfigEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, @ColumnInfo(name = "parent_id") val parentId: String, @ColumnInfo(name = "report_type") val reportType: String, val enabled: Boolean, val format: String, @ColumnInfo(name = "delivery_channel") val deliveryChannel: String, @ColumnInfo(name = "recipients") val recipients: String, @ColumnInfo(name = "scheduled_time") val scheduledTime: String, @ColumnInfo(name = "last_sent") val lastSent: Long? = null)

@Entity(tableName = "delivery_log")
data class DeliveryLogEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, @ColumnInfo(name = "parent_id") val parentId: String, val type: String, @ColumnInfo(name = "channel") val channel: String, val status: String, val recipient: String, @ColumnInfo(name = "sent_at") val sentAt: Long, @ColumnInfo(name = "error_message") val errorMessage: String? = null)

@Entity(tableName = "parent_profiles")
data class ParentProfileEntity(@PrimaryKey val id: String, val name: String, val relation: String, val age: Int, @ColumnInfo(name = "watch_brand") val watchBrand: String, @ColumnInfo(name = "watch_model") val watchModel: String? = null, @ColumnInfo(name = "medical_conditions") val medicalConditions: String, @ColumnInfo(name = "normal_hr_min") val normalHrMin: Int = 60, @ColumnInfo(name = "normal_hr_max") val normalHrMax: Int = 100, @ColumnInfo(name = "photo_uri") val photoUri: String? = null, @ColumnInfo(name = "google_fit_email") val googleFitEmail: String, @ColumnInfo(name = "is_setup_complete") val isSetupComplete: Boolean = false, @ColumnInfo(name = "last_sync_time") val lastSyncTime: Long? = null, @ColumnInfo(name = "last_data_time") val lastDataTime: Long? = null)
