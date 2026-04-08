package com.carelink.app.domain.model

import java.time.DayOfWeek
import java.time.LocalTime
import java.util.UUID

data class HealthData(val parentId: String, val metricType: HealthMetric, val value: Double, val unit: String, val timestamp: Long, val rawData: String? = null)

data class AlertRule(
    val id: Long = 0,
    val parentId: String,
    val alertType: AlertType,
    val metricType: HealthMetric,
    val condition: ThresholdCondition,
    val thresholdValue: Double,
    val secondaryThreshold: Double? = null,
    val durationMinutes: Int = 0,
    val sensitivity: AlertSensitivity = AlertSensitivity.MEDIUM,
    val deliveryChannel: DeliveryChannel = DeliveryChannel.BOTH,
    val enabled: Boolean = true,
    val cooldownMinutes: Int = 60,
    val lastTriggered: Long? = null,
)

data class ReportConfig(
    val id: Long = 0,
    val parentId: String,
    val reportType: ReportType,
    val enabled: Boolean,
    val format: ReportFormat,
    val deliveryChannel: DeliveryChannel,
    val recipients: List<String>,
    val scheduledTime: String,
    val lastSent: Long? = null,
)

data class DeliveryLog(val parentId: String, val type: String, val channel: DeliveryChannel, val status: String, val recipient: String, val sentAt: Long, val errorMessage: String? = null)

data class ParentProfile(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val relation: String,
    val age: Int,
    val watchBrand: String,
    val watchModel: String,
    val medicalConditions: List<String>,
    val normalHeartRateRange: IntRange = 60..100,
    val profilePhotoUri: String? = null,
    val googleFitAccountEmail: String,
    val isSetupComplete: Boolean = false,
    val lastSyncTime: Long? = null,
    val lastDataReceivedTime: Long? = null,
)

data class UserSettings(
    val syncIntervalMinutes: Int = 60,
    val batteryAwareSync: Boolean = true,
    val batteryThresholdPercent: Int = 20,
    val wifiOnlySync: Boolean = false,
    val nightModeSync: Boolean = false,
    val nightModeStartHour: Int = 22,
    val nightModeEndHour: Int = 7,
    val enabledMetrics: Set<HealthMetric> = setOf(HealthMetric.HEART_RATE, HealthMetric.STEPS, HealthMetric.SLEEP, HealthMetric.SPO2),
    val dailyReportEnabled: Boolean = true,
    val dailyReportTime: LocalTime = LocalTime.of(8, 0),
    val dailyReportFormat: ReportFormat = ReportFormat.STANDARD,
    val dailyReportChannel: DeliveryChannel = DeliveryChannel.TELEGRAM,
    val weeklyReportEnabled: Boolean = true,
    val weeklyReportDay: DayOfWeek = DayOfWeek.SUNDAY,
    val weeklyReportTime: LocalTime = LocalTime.of(19, 0),
    val weeklyReportFormat: ReportFormat = ReportFormat.STANDARD,
    val weeklyReportChannel: DeliveryChannel = DeliveryChannel.GMAIL,
    val monthlyReportEnabled: Boolean = true,
    val monthlyReportDay: Int = 1,
    val monthlyReportFormat: ReportFormat = ReportFormat.COMPREHENSIVE,
    val monthlyReportChannel: DeliveryChannel = DeliveryChannel.GMAIL,
    val emailRecipients: List<String> = emptyList(),
    val telegramChatIds: List<String> = emptyList(),
    val alertSensitivity: AlertSensitivity = AlertSensitivity.MEDIUM,
    val emergencyChannel: DeliveryChannel = DeliveryChannel.BOTH,
    val quietHoursEnabled: Boolean = true,
    val quietHoursStart: LocalTime = LocalTime.of(22, 0),
    val quietHoursEnd: LocalTime = LocalTime.of(7, 0),
    val textSizeMode: TextSize = TextSize.LARGE,
    val themeMode: ThemeMode = ThemeMode.LIGHT,
    val interfaceMode: InterfaceMode = InterfaceMode.DETAILED,
    val colorBlindMode: Boolean = false,
    val appLanguage: String = "en",
    val reportLanguage: String = "en",
    val useIndianNumberFormat: Boolean = true,
    val dateFormat: String = "dd/MM/yyyy",
    val use24HourFormat: Boolean = true,
    val dataRetentionDays: Int = 90,
    val autoBackupEnabled: Boolean = false,
)
