package com.carelink.app.report

import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.ReportConfig

class TelegramReportFormatter {
    fun build(config: ReportConfig, data: List<HealthData>): String = "*${config.reportType}*\n" + data.joinToString("\n") { "✅ *${it.metricType}*: `${it.value}` ${it.unit}" }
}
