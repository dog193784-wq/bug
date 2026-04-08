package com.carelink.app.report

import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.ReportConfig

class ReportGenerator(private val htmlReportBuilder: HtmlReportBuilder, private val telegramReportFormatter: TelegramReportFormatter) {
    fun buildHtml(config: ReportConfig, data: List<HealthData>): String = htmlReportBuilder.build(config, data)
    fun buildTelegram(config: ReportConfig, data: List<HealthData>): String = telegramReportFormatter.build(config, data)
}
