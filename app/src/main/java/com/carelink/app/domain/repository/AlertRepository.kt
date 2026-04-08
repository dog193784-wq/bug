package com.carelink.app.domain.repository

interface AlertRepository {
    suspend fun getEnabled(parentId: String): List<com.carelink.app.domain.model.AlertRule>
}
