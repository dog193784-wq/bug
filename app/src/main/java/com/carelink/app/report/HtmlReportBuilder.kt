package com.carelink.app.report

import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.ReportConfig

class HtmlReportBuilder {
    fun build(config: ReportConfig, data: List<HealthData>): String = """
        <html><body><h1>CareLink ${config.reportType}</h1><p>Samples: ${data.size}</p></body></html>
    """.trimIndent()
}
