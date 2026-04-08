package com.carelink.app.data.remote.telegram

import com.carelink.app.domain.model.HealthData

object TelegramMessageFormatter {
    fun formatSummary(parentName: String, data: List<HealthData>): String = buildString {
        append("*CareLink Report*\n")
        append("Parent: *$parentName*\n")
        data.forEach { append("✅ *${it.metricType}*: `${it.value}` ${it.unit}\n") }
        append("\n[📋 View Full Report](https://carelink.example/report)")
    }
}
