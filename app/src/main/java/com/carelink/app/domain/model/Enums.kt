package com.carelink.app.domain.model

enum class HealthMetric { HEART_RATE, STEPS, SLEEP, SPO2, STRESS, CALORIES, BLOOD_PRESSURE, FALL, DISTANCE }
enum class AlertType { INACTIVITY, HEART_RATE_HIGH, HEART_RATE_LOW, FALL_DETECTED, SLEEP_DISRUPTION, SPO2_LOW, WATCH_NOT_WORN }
enum class ReportType { DAILY, WEEKLY, MONTHLY, EMERGENCY }
enum class ReportFormat { COMPACT, STANDARD, COMPREHENSIVE }
enum class DeliveryChannel { GMAIL, TELEGRAM, BOTH }
enum class AlertSensitivity { LOW, MEDIUM, HIGH, CUSTOM }
enum class ThresholdCondition { ABOVE, BELOW, OUTSIDE_RANGE, EQUALS }
enum class TextSize { MEDIUM, LARGE, EXTRA_LARGE, MAXIMUM }
enum class ThemeMode { LIGHT, DARK, HIGH_CONTRAST }
enum class InterfaceMode { SIMPLIFIED, DETAILED }
