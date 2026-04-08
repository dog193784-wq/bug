package com.carelink.app.domain.repository

interface HealthDataRepository {
    suspend fun insertAll(items: List<com.carelink.app.domain.model.HealthData>)
    suspend fun getLatest(parentId: String): List<com.carelink.app.domain.model.HealthData>
}
