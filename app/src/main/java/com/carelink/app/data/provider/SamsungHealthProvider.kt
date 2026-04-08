package com.carelink.app.data.provider

import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.HealthMetric

class SamsungHealthProvider : HealthDataProvider {
    override suspend fun fetch(parentId: String, metrics: Set<HealthMetric>, startTimeMillis: Long, endTimeMillis: Long): List<HealthData> = emptyList()
}
