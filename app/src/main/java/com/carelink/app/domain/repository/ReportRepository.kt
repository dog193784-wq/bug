package com.carelink.app.domain.repository

interface ReportRepository {
    suspend fun getConfigs(parentId: String): List<com.carelink.app.domain.model.ReportConfig>
}
